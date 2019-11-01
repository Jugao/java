package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoLogin {

    public static Connection getConnection() {
        try {
            System.out.println("pasa");    
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");            
            System.out.println("pasa");  
//Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2VJHJF8:1433;databaseName=arriving;user=sa;password=zp3ak4pc5J");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1443;databaseName=arriving;user=sa;password=zp3ak4pc5J;");            
            System.out.println("Connected to database OK"); 
            return con;           
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database.getConnection() Error h-->" + ex.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}
