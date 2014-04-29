/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Class
 * <code>DerbyDAOFactory</code> uses the Factory Method design pattern to create
 * a connection to a specific Java Derby database.
 *
 * NB Add derbyclient.jar to project
 *
 * @version 16/02/10
 * @author ibr
 */
public class DerbyDAOFactory
{
    private static final String URL = "jdbc:derby://localhost:1527/Charging";
    private static final String USERNAME = "Group9";
    private static final String PASSWORD = "1234";
    /**
     * Factory method to return a connection to a specific Java Derby database.
     *
     * @return the Java Derby database connection
     * @throws SQLException
     */
    public static Connection createConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
