/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.quanlybanhang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author pc
 */
public class MySQLConnect {
    
    private static Connection conn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Connection getConn() throws SQLException {     
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/vlxd", "root", "17102000");
        return conn;
    }    
          
}
