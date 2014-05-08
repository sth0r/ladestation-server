/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.ChargingStat;
import model.Customer;
import model.ResultSetTableModel;
/**
 *
 * @author ibr
 */
public interface ChargingDAO
{
    // From GUI
    public Customer findByUID(String uID);
    public ChargingStat findByTAID(String taID);
    public Customer findByFirstName(String uID);
    public Customer findByLastName(String uID);
    public Customer findByBalance(String uID);
    public Customer findByCreditLimit(String uID);
    public Customer findByEmail(String uID);
    public Customer findByTlf(String uID);
    public void select(ResultSetTableModel receiver) throws java.sql.SQLException;
    public void update(ResultSetTableModel receiver) throws java.sql.SQLException;
    public void insert(ResultSetTableModel receiver) throws java.sql.SQLException;
    public void delete(ResultSetTableModel receiver) throws java.sql.SQLException;
                   
    // From Charger to Server
    public String login(String costumerID); // Return password
    public void chargeEvent(int taID, String costumerID, String stopTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException;
    public double priceRequest(); // Return price
    public double balanceRequest(String costumerID); // Return balance
    // From Server to Charger
    public void newTAID(int taID, String startTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException; // Save taID and startTime
}