/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

/**
 *
 * @author tuananh
 */
public class ConnectToSQL {
    public String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=Phones;"
            + "integratedSecurity=true";
    public String USER_NAME = "tuananh";
    public String PASSWORD = "";

    public ConnectToSQL() {
    }
}
