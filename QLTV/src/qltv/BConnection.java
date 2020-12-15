/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BConnection {
    private static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=LibraryManagement";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234@";
    
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch(ClassNotFoundException e){
            Logger.getLogger(BConnection.class.getName()).log(Level.SEVERE,null,e);
        }catch(SQLException e){
            Logger.getLogger(BConnection.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}
