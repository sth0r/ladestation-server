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
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import model.Customer;
import model.ResultSetTableModel;

/**
 *
 * @author Alex
 */
public class ChargingServer
{

    Transceiver tranciever;

    public ChargingServer()
    {
        try
        {
            this.tranciever = new Transceiver("COM7", this);
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
            String command = input.substring(4, 5);
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
        String client = input.substring(1, 4);
        String cardUID = input.substring(5, 13);
        boolean validateUIDResult;                 //result = Control if password matches pass string
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        String customerUID = chargingDAO.findByUID(cardUID).getUID();
        validateUIDResult= cardUID.equals(customerUID); //true-false

        validateUIDReturnPack(client, validateUIDResult);
    }
    
    private void passcontrol(String input)
    {
        int nextTAID = 0;
        String taID = String.valueOf(nextTAID);
        nextTAID++;
        String client = input.substring(1, 4);
        String user = input.substring(5, 13);
        String typedPassword = input.substring(13, 21);
        boolean passResult;                 //result = Control if password matches pass string
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        String customerPassword = chargingDAO.login(user);
        passResult = typedPassword.equals(customerPassword);
        
        Customer customer = chargingDAO.findByUID(client);
        boolean creditResult = (customer.getBalance()+customer.getCreditLimit())>0;

        loginReturnPack(client, taID, user, passResult, creditResult);
    }

    private void chargecharge(String input)
    {
        String client = input.substring(1, 4);
        String taID = input.substring(5, 11);
        String user = input.substring(11, 19);
        String kr = input.substring(19, 23);
        String øre = input.substring(23, 25);
        String time = input.substring(25, 29);
        ChargingDAO chargingDAO = new ChargingDerbyDAO();
        double price = Double.parseDouble(kr+'.'+øre);
        
        chargingDAO.chargeEvent(taID, client, time, price);
    }
    
    
    private void clockquery(String input)
    {
        String client = input.substring(1, 4);
        clockPack(client);
    }

    private void pricequery(String input)
    {
        String client = input.substring(1, 4);
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
