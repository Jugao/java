package com.test.dao;

import com.test.modelo.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.sql.Timestamp;


public class registroDao extends Dao {

    public void registrarHora(Registro re) {
              
        long now = System.currentTimeMillis();
        Timestamp sqlTimestamp = new Timestamp(now);
        System.out.println("SqlTimestamp          : " + sqlTimestamp);
        
        try {
            this.conectar();           
            String insert = "insert into Registro( cedula, hora) values (?,?)";
            PreparedStatement st = this.getCon().prepareStatement(insert);
            st.setString(1, re.getCedula());
            st.setTimestamp(2, sqlTimestamp);          
            st.executeUpdate();            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Registrado"));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error! verifique Datos "));
        } finally {
            this.cerrar();
        }
    }

    public List<Registro> listar() {
        List<Registro> registros = new ArrayList<Registro>();
        String cedula, hora;
        try {
            this.conectar();
            ResultSet rs;
            String select = "select cedula,hora from Registro";
            PreparedStatement st = this.getCon().prepareStatement(select);
            rs = st.executeQuery();
            while (rs.next()) {
                Registro r;
                cedula = rs.getString("cedula");
                hora = rs.getString("hora");
                r = new Registro(cedula, hora);
                registros.add(r);
            }
            this.cerrar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(registroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registros;

    }
}
