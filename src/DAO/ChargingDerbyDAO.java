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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, uID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
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
                ChargingStat stats = createStats(resultSet);
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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
                return user;
            }
        } catch (SQLException e)
        {
        }
        return null;
    }

    @Override
    public Customer findByLastName(String lastName)
    {
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, balance);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, creditLimit);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"uID\" = ?";

        try (Connection con = DerbyDAOFactory.createConnection();
                PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
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
        String titlesQuery = "select distinct \"uID\", \"firstName\",  "
                + "\"lastName\", \"balance\", \"creditLimit\", \"email\", \"tlf\""
                + "from \"Customers\" "
                + "where \"tlf\" = ?";
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement preparedStatement = con.prepareStatement(titlesQuery);)
        {
            preparedStatement.setString(1, tlf);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                Customer user = createCostumer(resultSet);
                return user;
            }
        } 
        catch (SQLException e)
        {
        }
        return null;
    }
    @Override
    public void select(ResultSetTableModel receiver) throws java.sql.SQLException
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("select", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void update(ResultSetTableModel receiver) throws java.sql.SQLException
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("update", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void insert(ResultSetTableModel receiver) throws java.sql.SQLException
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("insert", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
    }
    @Override
    public void delete(ResultSetTableModel receiver) throws java.sql.SQLException
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("delete", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
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
    public void chargeEvent(int taID, String costumerID, String stopTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "INSERT INTO CHARGINGSTATS (TAID, stopped, UID) VALUES ("+taID+",'" +costumerID+"','" +stopTimeStamp+"')";
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
    public double priceRequest() throws java.sql.SQLException
    {
        try (Connection con = DerbyDAOFactory.createConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT Price FROM PRICESES ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);)
        {
            ResultSet resultSet = stmt.executeQuery();
            CachedRowSetImpl cachedRowSet = new CachedRowSetImpl();
            cachedRowSet.populate(resultSet);
            con.close();
            receiver.setRowSet(cachedRowSet);
        }
       return Price.getPrice();
    }
    
    @Override
    public double balanceRequest(String costumerID)
    {
        return Double.parseDouble(findByUID(costumerID).getBalance());
    }
    
    // From Server to Charger

    @Override
    public void newTAID(int taID, String startTimeStamp, ResultSetTableModel receiver) throws java.sql.SQLException
    {
        String sQLCommand = "INSERT INTO CHARGINGSTATS (TAID, started) VALUES ("+ taID +",'" +startTimeStamp+"')";
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
    
    private Customer createCostumer(ResultSet resultSet) throws SQLException
    {
        String uID = resultSet.getString("uID");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String balance = resultSet.getString("balance");
        String creditLimit = resultSet.getString("creditLimit");
        String email = resultSet.getString("email");
        String tlf = resultSet.getString("tlf");
        String password = resultSet.getString("password");
        return new Customer(uID, firstName, lastName, balance, creditLimit, email, tlf, password);
    }
    
    private ChargingStat createStats(ResultSet resultSet) throws SQLException
    {
        String taID = resultSet.getString("TAID");
        String started = resultSet.getString("started");
        String stopped = resultSet.getString("stopped");
        String duration = resultSet.getString("duration");
        String uID = resultSet.getString("UID");
        return new ChargingStat(taID, started, stopped, duration, uID);
    }
    
    private Price createStats(ResultSet resultSet) throws SQLException
    {
        String taID = resultSet.getString("TAID");
        String started = resultSet.getString("started");
        String stopped = resultSet.getString("stopped");
        String duration = resultSet.getString("duration");
        String uID = resultSet.getString("UID");
        return new ChargingStat(taID, started, stopped, duration, uID);
    }
}