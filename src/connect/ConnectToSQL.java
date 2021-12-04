/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.*;
import static java.sql.DriverManager.getConnection;

/**
 *
 * @author tuananh
 */
public class ConnectToSQL {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Phones;"
            + "integratedSecurity=true";
    private static String USER_NAME = "tuananh";
    private static String PASSWORD = "";
    

}
