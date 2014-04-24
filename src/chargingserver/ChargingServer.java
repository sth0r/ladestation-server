/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chargingserver;
import ihk.ibr.serial.*;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */


 public class ChargingServer {
    Transceiver tranciever;

    public ChargingServer() {
        try {
            this.tranciever = new Transceiver("COM3",this);
        } catch (TooManyListenersException ex) {
            Logger.getLogger(ChargingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Datareceived() {
        String input = tranciever.getReceivedData();
        commandInterp(input);
    }
    
    void commandInterp(String input){
        if (input.startsWith("$") && input.endsWith("*")){
            String command = input.substring(5, 5);
            switch (command){
                case "L" :  passcontrol(input); break;
                case "C" :  chargecharge(input); break;
                case "H" :  clockquery(input); break;
                case "Q" :  pricequery(input); break;
            }
                    
        }
    }

    private void passcontrol(String input) {
        int nextTAID=0;
        String taID = String.valueOf(nextTAID);
        nextTAID++;
        String client = input.substring(2, 4);
        String user = input.substring(5, 9);
        String pass = input.substring(10, 16);
        boolean result = false;                 //result = Control if password matches pass string
        
        loginReturnPack(client,taID,user,result);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void chargecharge(String input) {
        String client = input.substring(2, 4);
        String taID = input.substring(5, 14);
        String user = input.substring(15, 21);
        String kr = input.substring(22, 25);
        String øre = input.substring(26, 29);
        String time = input.substring(30, 33);
        //træk kr/øre fra i brugerdatabase
        //put opladning i event database
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void clockquery(String input) {
        String client = input.substring(2, 4);
        clockPack(client);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pricequery(String input) {
        String client = input.substring(2, 4);
        pricePack(client);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void clockBroadcast(int clientcount){
        for (int i=1; i<=clientcount; i++){
            clockPack(String.format("%03d", i));
        }
    }
    
    private void priceBroadcast(int clientcount){
        for (int i=1; i<=clientcount; i++){
            pricePack(String.format("%03d", i));
        }
    }
    
    private void loginReturnPack(String client, String taID, String user, boolean result) {
        String pack='$'+client+taID+user+result;
        tranciever.transmit(pack);
    }

    private void pricePack(String client) {//"$"	"001"	"P"	New price kr	New price øre
        String krData="0";
        String øreData = "0";
        //get prisdata from database
        String pack='*'+client+krData+øreData;
        tranciever.transmit(pack);
    }
    
    private void clockPack(String client) {//"$"	"001"	"T"	Hours	Minutes	Seconds
        String hrData="0";
        String minData="0";
        String secData ="0";
        //get prisdata from database
        String pack='*'+client+hrData+minData+secData;
        tranciever.transmit(pack);
    }
}
