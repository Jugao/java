
package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends Dao{
    Dao conexion = new Dao();
    
    public static boolean validate(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
    
        
         try {
             
            con = daoLogin.getConnection();
            
            ps = con.prepareStatement("select usuDoc, usuNom, usuContra from dbo.Usuario where usuNom = ? and usuContra = ?");
            ps.setString(1, user);
            ps.setString(2, password); 
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
            
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
           // DaoLogin.close(con);
            daoLogin.close(con);
        }
        return false;
        
        
    }
    
    /*
    
     public static boolean validateEmp(String user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
 
        try {
            con = daoLogin.getConnection();
            ps = con.prepareStatement("Select per_usuario, per_contrasena, per_rol from tblpersona where per_usuario = ? and per_contrasena = ? and per_rol = 'empleado'");
            ps.setString(1, user);
            ps.setString(2, password);          
 
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        
            
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            daoLogin.close(con);
        }
        return false;
    }
    
    */
    
}
