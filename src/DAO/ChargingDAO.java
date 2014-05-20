/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.*;
/**
 *
 * @author ibr
 */
public interface ChargingDAO
{
    // From GUI
    public Customer findByUID(String uID);
    public ChargingStat findByTAID(String taID);
    public Customer findByFirstName(String firstName);
    public void findByFirstNameTEST(String firstName, ResultSetTableModel receiver) throws java.sql.SQLException;
    public Customer findByLastName(String lastName);
    public Customer findByBalance(String balance);
    public Customer findByCreditLimit(String creditLimit);
    public Customer findByEmail(String email);
    public Customer findByTlf(String tlf);
    public void addCustomerToDB(Customer customer,ResultSetTableModel receiver) throws java.sql.SQLException;
    public void editCustomerFromDB(String uID,ResultSetTableModel receiver) throws java.sql.SQLException;
    public void deleteCustomerFromDB(String uID,ResultSetTableModel receiver) throws java.sql.SQLException;
    public void getCustomersTableFromDB(ResultSetTableModel receiver) throws java.sql.SQLException;
    public void getChargingstatsTableFromDB(ResultSetTableModel receiver) throws java.sql.SQLException;
    public Price priceRequestDB(); // Returns a priceModel from database
            
    // From Charger to Server
    public String login(String costumerID); // Return password
    public void chargeEvent(String taID, String costumerID, String stopTimeStamp, double price);
    public double priceRequest(); // Return price
    public double balanceRequest(String costumerID); // Return balance
    // From Server to Charger
    public void newTAID(String taID, String startTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException; // Save taID and startTime
}