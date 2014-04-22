/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chargingserver;

/**
 *
 * @author Alex
 */


 public class ChargingServer {
    String input = "$001USERNR12345678*";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    void methode(String input){
        String dummy;
        if (input.startsWith("*")){
            dummy=input.substring(5, 5);
            switch (dummy){
                case "L" :  passcontrol(input); break;
                case "C" :  chargecharge(input); break;
            }
                    
        }
    }

    private void passcontrol(String input) {
        String user = input.substring(5, 9);
        String pass = input.substring(10, 17);
        //Check against database
        //respond to charger
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private void chargecharge(String input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
