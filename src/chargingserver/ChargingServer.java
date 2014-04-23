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
    String input = "$001USERNR12345678*";
    Transceiver tranciever;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public ChargingServer() {
        try {
            this.tranciever = new Transceiver("COM3");
        } catch (TooManyListenersException ex) {
            Logger.getLogger(ChargingServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void methode(String input){
        String dummy;
        if (input.startsWith("*")){
            dummy=input.substring(5, 5);
            switch (dummy){
                case "L" :  passcontrol(input); break;
                case "C" :  chargecharge(input); break;
                case "Q" :  pricequery(input); break;
            }
                    
        }
    }

    private void passcontrol(String input) {
        String user = input.substring(5, 9);
        String pass = input.substring(10, 17);
        boolean result = false;
        //Request User matching user string from database
        //result = Control if password matches pass string
        loginReturnPack(result);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private void chargecharge(String input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pricequery(String input1) {
        pricePack();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void loginReturnPack(boolean result) {
        transmit(result);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pricePack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
