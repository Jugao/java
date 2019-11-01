package com.test.dao;

import com.test.modelo.Especialista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class especialistaDao extends Dao {

    public void registrarEspecialista(Especialista es) {

        try {
            this.conectar();
            String insert = "insert into Especialista ( cedula,nombre,cod_especialidad,especialidad) values (?,?,?,?)";
            PreparedStatement st = this.getCon().prepareStatement(insert);
            st.setString(1, es.getDoc());
            st.setString(2, es.getNom());
            st.setString(3, es.getCod_esp());
            st.setString(4, es.getEspecialidad());
            st.executeUpdate();         
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Guardado correctamente"));            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("error verifique datos la identificacion ya existe"));
        } finally {
            this.cerrar();
        }
    }

    public List<Especialista> listar() {
        List<Especialista> especialistas = new ArrayList<Especialista>();
        
       String cedula, nombre, cod_esp, especialidad;

        try {
            this.conectar();
            ResultSet rs;
            String select = "select cedula,nombre,cod_especialidad, especialidad from Especialista";
            PreparedStatement st = this.getCon().prepareStatement(select);
            rs = st.executeQuery();
            while (rs.next()) {
                Especialista e;
                cedula  = rs.getString("cedula");
                nombre  = rs.getString("nombre");
                cod_esp = rs.getString("cod_especialidad");
                especialidad = rs.getString("especialidad");                
                e = new Especialista(cedula, nombre, cod_esp, especialidad); //clase
                especialistas.add(e); // array
            }
            this.cerrar();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especialistas;

    }

    public Especialista getPersonasID(Especialista e) {
        Especialista esp = new Especialista();
        ResultSet rs;

       String cedula, nombre, cod_esp, especialidad;

        try {
            this.conectar();
            String select = "select cedula,nombre,cod_especialidad, especialidad from Especialista where cedula =?";
            PreparedStatement st = this.getCon().prepareStatement(select);
            st.setString(1, e.getDoc());

            rs = st.executeQuery();
            while (rs.next()) {
                 cedula  = rs.getString("cedula");
                nombre  = rs.getString("nombre");
                cod_esp = rs.getString("cod_especialidad");
                especialidad  = rs.getString("especialidad");
            }
        } catch (SQLException ex) {
            Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return esp;
    }
    
    
     public void modificar(Especialista e) {

        try {
            this.conectar();
            String update = "update specialists set esp_id=?, esp_nomb=? where esp_id=?";
            PreparedStatement st = this.getCon().prepareStatement(update);           
            st.setString(3, e.getDoc());
            st.setString(4, e.getNom());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cerrar();
        }
    }

    public void eliminar(Especialista e) {
        try {
            this.conectar();
            String delete = "delete from specialists where esp_id=?";
            PreparedStatement st = this.getCon().prepareStatement(delete);
            st.setString(1, e.getDoc());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(especialistaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
