/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclereservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nimos
 */
public class DbCon {
    
    //this is the method to create aconnection with our database.. oki pati? (y)
    //your username and passwor for mysql please?? those r corect. root n 123..oki
    
    //simply this method willl return a DB connection .gotcha
    public static Connection createCon() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://Localhost:3306/vrs", "root", "123");
        return c;
    }
}
