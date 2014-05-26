/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;
import model.ResultSetTableModel;
import model.*;
import com.sun.rowset.CachedRowSetImpl;


/**
 *
 * @author ibr
 */
public class ChargingDerbyDAO implements ChargingDAO
{

    @Override
    public Customer findByUID(String uID)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\", \"PASSWORD\""
                + "from \"CUSTOMERS\" "
                + "where \"UID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, uID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
            System.out.println("SQLException: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ChargingStat findByTAID(String taID)
    {
        String titlesQuery = "select distinct \"TAID\", \"started\", \"stopped\", \"daration\""
                + "from \"CHARGINGSTATS\" "
                + "where \"TAID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, taID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                ChargingStat stats = createChargingStatsModel(resultSet);
                return stats;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }
    @Override
    public Customer findByFirstName(String firstName)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"FIRSTNAME\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }
    @Override
    public void findByFirstNameTEST(String firstName, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String titlesQuery = "select *"
                + "from \"CUSTOMERS\" "
                + "where \"FIRSTNAME\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }

    @Override
    public Customer findByLastName(String lastName)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"LASTNAME\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public Customer findByBalance(String balance)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"BALANCE\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, balance);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public Customer findByCreditLimit(String creditLimit)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"CREDITLIMIT\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, creditLimit);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public Customer findByEmail(String email)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"EMAIL\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public Customer findByTlf(String tlf)
    {
        String titlesQuery = "select distinct \"UID\", \"FIRSTNAME\",  "
                + "\"LASTNAME\", \"BALANCE\", \"CREDITLIMIT\", \"EMAIL\", \"TLF\""
                + "from \"CUSTOMERS\" "
                + "where \"TLF\" = ?";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, tlf);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumerModel(resultSet);
                return user;
            }
        } 
        catch (SQLException e)
        {
        }
        return null;
    }
    @Override
    public void addCustomerToDB(Customer customer, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "INSERT INTO CUSTOMERS (UID,firstName,lastName,balance,creditLimit,email,tlf)"
                + "VALUES ('"+customer.getUID()+"','"+customer.getFirstName()+"','"+customer.getLastName()+
                "','"+customer.getBalance()+"','"+customer.getCreditLimit()+"','"+customer.getEmail()+"','"+customer.getTlf()+"')";
        
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void editCustomerFromDB(String uID,ResultSetTableModel receiver) throws java.sql.SQLException
    {
        Customer editCustomer = findByUID(uID);
        String sQLCommand = "UPDATE CUSTOMERS SET firstName = "+editCustomer.getFirstName()+",lastName = "+editCustomer.getLastName()+
                ",balance = "+editCustomer.getBalance()+",creditLimit = "+editCustomer.getCreditLimit()+",email = "+editCustomer.getEmail()+
                ",tlf = "+editCustomer.getTlf()+", WHERE UID = '"+uID+"'";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void deleteCustomerFromDB(String uID, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "DELETE FROM CUSTOMERS WHERE UID = '"+uID+"'";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void getCustomersTableFromDB(ResultSetTableModel receiver) throws java.sql.SQLException
    {    
        String sQLCommand = "SELECT UID,firstName,lastName,balance,creditLimit,email,tlf FROM CUSTOMERS"; // Avoid getting password colum
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void getChargingstatsTableFromDB(ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "SELECT * FROM CHARGINGSTATS";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    // From Charger to Server

    @Override
    public String login(String costumerID) // Find the password that matches the costumerID and return it
    {
        return findByUID(costumerID).getPassword();
    }

    @Override
    public void chargeEvent(String taID, String costumerID, String stopTimeStamp, double price)
    {
        String sQLCommand = "UPDATE CHARGINGSTATS SET stopped = "+stopTimeStamp+", UID = "+costumerID+", WHERE TAID = '"+taID+"'";

        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
        }
        catch (SQLException e){
            System.out.print("SQL Fail!" + e.getMessage());
        }
        
        double newprice = balanceRequest(costumerID) - price; //Burde måske ikke foregå i DAO
        sQLCommand = "UPDATE COSTUMERS SET BALANCE = "+newprice+", WHERE UID = '"+costumerID+"'";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
        }
        catch (SQLException e){
            System.out.print("SQL Fail!" + e.getMessage());
        }
          
    }

    @Override
    public Price priceRequestDB()
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT Price FROM PRICESES", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            Price price = createPriceModel(resultSet);
            return price; 
        } 
        catch (SQLException e)
        {
        }
        return null;
    }
    
    @Override
    public double priceRequest()
    {
        return priceRequestDB().getPrice();
    }
    @Override
    public double balanceRequest(String costumerID)
    {
        return findByUID(costumerID).getBalance();
    }
    
    // From Server to Charger

    @Override
    public void newTAID(String taID, String startTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "INSERT INTO CHARGINGSTATS (TAID, started) VALUES ('"+ taID +"','" +startTimeStamp+"')";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    
    private Customer createCostumerModel(ResultSet resultSet) throws SQLException
    {
        String uID = resultSet.getString("UID");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        double balance = resultSet.getDouble("balance");
        double creditLimit = resultSet.getDouble("creditLimit");
        String email = resultSet.getString("email");
        String tlf = resultSet.getString("tlf");
        String password = resultSet.getString("password");
        return new Customer(uID, firstName, lastName, balance, creditLimit, email, tlf, password);
    }
    
    private ChargingStat createChargingStatsModel(ResultSet resultSet) throws SQLException
    {
        String taID = resultSet.getString("TAID");
        String started = resultSet.getString("started");
        String stopped = resultSet.getString("stopped");
        String duration = resultSet.getString("duration");
        String uID = resultSet.getString("UID");
        return new ChargingStat(taID, started, stopped, duration, uID);
    }
    
    private Price createPriceModel(ResultSet resultSet) throws SQLException
    {
        double price = resultSet.getDouble("Price");
        return new Price(price);
    }

    public void addCustomerToDB(Customer customer) throws SQLException {
        String sQLCommand = "INSERT INTO CUSTOMERS (UID,FIRSTNAME,LASTNAME,BALANCE,CREDITLIMIT,EMAIL,TLF,PASSWORD)"
                + "VALUES ('"+customer.getUID()+"','"+customer.getFirstName()+"','"+customer.getLastName()+
                "','"+customer.getBalance()+"','"+customer.getCreditLimit()+"','"+customer.getEmail()+"','"+customer.getTlf()+"','"+"123"+"')";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            stmt.executeUpdate();
            con.close();
        }
    }

    public void editCustomerFromDB(Customer editCustomer) throws SQLException {
        String sQLCommand = "UPDATE CUSTOMERS SET FIRSTNAME = '"+editCustomer.getFirstName()+"',LASTNAME = '"+editCustomer.getLastName()+
                "',BALANCE = '"+editCustomer.getBalance()+"',CREDITLIMIT = '"+editCustomer.getCreditLimit()+"',EMAIL = '"+editCustomer.getEmail()+
                "',TLF = '"+editCustomer.getTlf()+"' WHERE UID = '"+editCustomer.getUID()+"'";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            stmt.executeUpdate();
            con.close();
        }
    }

    public void deleteCustomerFromDB(String uID) throws SQLException 
    {
        String sQLCommand = "DELETE FROM CUSTOMERS WHERE UID = '"+uID+"'";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement(sQLCommand, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            stmt.executeUpdate();
            con.close();
        }
    }
}