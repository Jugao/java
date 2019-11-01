package com.test.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import com.test.dao.registroDao;
import javax.annotation.PostConstruct;
import com.test.modelo.Registro;

@ManagedBean
@RequestScoped
public class RegistroBean {

    public Registro getR() {
        return R;
    }

    public void setR(Registro R) {
        this.R = R;
    }
    
    Registro R = new Registro();

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
    
    List<Registro > registros = new ArrayList<Registro>();
    
     public void registrar() {         
       registroDao dao = new  registroDao();
        dao.registrarHora(R);
        this.listar();
        R= new Registro(); // faltaba 
     }
         
    @PostConstruct
    public void listar() {
        registroDao dao = new registroDao();
        registros = dao.listar();
    }    
}