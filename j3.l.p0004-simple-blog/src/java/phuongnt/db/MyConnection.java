/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuongnt.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author USER
 */
public class MyConnection {
  public static Connection getMyConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SimpleBlog","sa","sa123456");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
