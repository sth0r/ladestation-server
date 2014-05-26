/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chargingserver;

import ihk.ibr.serial.*;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAO.*;
import java.util.Calendar;
import model.Customer;


/**
 *
 * @author Alex
 */
public class ChargingServer
{

    private final int START_CHAR = 1;
    private final int CLIENT_ID = 3;
    private final int COMMAND_CHAR = 1;
    private final int DATA_START = 5;
    private final int TAID = 8;
    private final int COSTUMER_ID = 8;
    private final int PASSWORD_MAX = 4; //Maybe 8 later
    private final int CHARGE_KR = 4;
    private final int CHARGE_ØRE = 2;
    private final int TIMESTAMP = 5;
    private String taID;
    Transceiver tranciever;

    public ChargingServer()
    {
        try
        {
            this.tranciever = new Transceiver("COM22", this);
        } catch (TooManyListenersException ex)
        {
            Logger.getLogger(ChargingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Datareceived()
    {
        String input = tranciever.getReceivedData();
        //System.out.println("CS31. DataReceived: " + input);
        commandInterp(input);
    }
    // validate card UID packet %001V7B503FD7*

    void commandInterp(String input)
    {
        System.out.println("CS43. CommandInterp: " + input);
        if (input.startsWith("%") && input.endsWith("*"))
        {
            String command = input.substring(START_CHAR+CLIENT_ID, START_CHAR+CLIENT_ID+COMMAND_CHAR);
            switch (command)
            {
                case "V":
                    validateUIDcontrol(input);
                    break;
                case "L":
                    passcontrol(input);
                    break;
                case "C":
                    chargecharge(input);
                    break;
                case "H":
                    clockquery(input);
                    break;
                case "Q":
                    pricequery(input);
                    break;
            }
        }
    }

    private void validateUIDcontrol(String input)
    {
        String client = input.substring(START_CHAR, START_CHAR+CLIENT_ID);
        String cardUID = input.substring(DATA_START, DATA_START+COSTUMER_ID);
        boolean validateUIDResult;                 //result = Control if password matches pass string
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        String customerUID = chargingDAO.findByUID(cardUID).getUID();
        validateUIDResult= cardUID.equals(customerUID); //true-false

        validateUIDReturnPack(client, validateUIDResult);
    }
    //%001LxxxUIDxxPASS
    private void passcontrol(String input)
    {
        int nextTAID = 0;
        taID = String.valueOf(nextTAID);
        nextTAID++;
        String client = input.substring(START_CHAR, START_CHAR+CLIENT_ID);
        String user = input.substring(DATA_START, DATA_START+COSTUMER_ID);
        String typedPassword = input.substring(DATA_START+COSTUMER_ID, DATA_START+COSTUMER_ID+PASSWORD_MAX);                
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        String customerPassword = chargingDAO.login(user);
        boolean passResult = typedPassword.equals(customerPassword);//result = Control if password matches pass string
        
        Customer customer = chargingDAO.findByUID(client);
        boolean creditResult = (customer.getBalance()+customer.getCreditLimit())>0;

        loginReturnPack(client, taID, user, passResult, creditResult);
    }

    private void chargecharge(String input)
    {
        String client = input.substring(START_CHAR, START_CHAR+CLIENT_ID);
        String taIDReceived = input.substring(DATA_START, DATA_START+TAID);
        String user = input.substring(DATA_START, DATA_START+COSTUMER_ID);
        String kr = input.substring(DATA_START+COSTUMER_ID, DATA_START+COSTUMER_ID+CHARGE_KR);
        String øre = input.substring(DATA_START+COSTUMER_ID+CHARGE_KR, DATA_START+COSTUMER_ID+CHARGE_KR+CHARGE_ØRE);
        String time = input.substring(DATA_START+COSTUMER_ID+CHARGE_KR+CHARGE_ØRE, DATA_START+COSTUMER_ID+CHARGE_KR+CHARGE_ØRE+TIMESTAMP);
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        double price = Double.parseDouble(kr+'.'+øre);
        boolean chargeResult = taID.equals(taIDReceived);
        chargingDAO.chargeEvent(taIDReceived, user, time, price);
        chargeReturnPack(client, chargeResult);
    }
    
    
    private void clockquery(String input)
    {
        String client = input.substring(START_CHAR, START_CHAR+CLIENT_ID);
        clockPack(client);
    }

    private void pricequery(String input)
    {
        String client = input.substring(START_CHAR, START_CHAR+CLIENT_ID);
        pricePack(client);
    }

    public void clockBroadcast(int clientcount)
    {
        for (int i = 1; i <= clientcount; i++)
        {
            clockPack(String.format("%03d", i));
        }
    }

    public void priceBroadcast(int clientcount)
    {
        for (int i = 1; i <= clientcount; i++)
        {
            pricePack(String.format("%03d", i));
        }
    }

    private void loginReturnPack(String client, String taID, String user, boolean result, boolean creditResult)
    {
        String pack = client + "A" + taID + user + result + creditResult;
        tranciever.transmit(pack);
        System.out.println("CS159. Login return pack\n" + pack);
    }
    
    private void validateUIDReturnPack(String client, boolean result)
    {
        String pack = client + "A" + result;
        tranciever.transmit(pack);
        System.out.println("CS158. Validate UID return pack\n" + pack);
    }
    
    private void chargeReturnPack(String client, boolean result)
    {
        String pack = client + "A" + result;
        tranciever.transmit(pack);
        System.out.println("CS175. Charge return pack\n" + pack);
    }

    private void pricePack(String client)
    {//"$"	"001"	"P"	New price kr	New price øre
        String krData = "0000";
        String øreData = "00";
        //get prisdata from database
        double price = new ChargingDerbyDAO().priceRequest(); // Gets price from database
        String pack = client + "P" + krData + øreData;
        tranciever.transmit(pack);
        System.out.println("CS177. Price pack\n" + pack);
    }

    private void clockPack(String client)
    {//"$"	"001"	"T"	Hours	Minutes	Seconds
        Calendar time = Calendar.getInstance();
        String hrData = String.valueOf(time.get(Calendar.HOUR_OF_DAY));
        String minData = String.valueOf(time.get(Calendar.MINUTE));
        String secData = String.valueOf(time.get(Calendar.SECOND));
        String pack = client + hrData + minData + secData;
        tranciever.transmit(pack);
    }
}
