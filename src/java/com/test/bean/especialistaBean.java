package com.test.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.test.dao.especialistaDao;
import com.test.modelo.Especialista;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

@ManagedBean
@RequestScoped
public class especialistaBean {

    Especialista e = new Especialista();

    public Especialista getE() {
        return e;
    }

    public void setE(Especialista e) {
        this.e = e;
    }

    public List<Especialista> getEspecialistas() {
        return especialistas;
    }

    public void setEspecialistas(List<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    List<Especialista> especialistas = new ArrayList<>(); //Especialista

    public void registrar() {
        especialistaDao dao = new especialistaDao();
        dao.registrarEspecialista(e);
        this.listar();
        e = new Especialista();
    }

    @PostConstruct
    public void listar() {
        especialistaDao dao = new especialistaDao();
        especialistas = dao.listar();
    }
    
       public void leerId(Especialista e)
    {
        especialistaDao dao = new especialistaDao();
        Especialista temp = dao.getPersonasID(e);
        if(temp!=null)
        {
            this.e=temp;
        }
    }
        
    public void eliminar(Especialista e){
        especialistaDao dao = new especialistaDao();
        dao.eliminar(e);
        this.listar();
    }
    
    public void modificar(){
    especialistaDao dao = new especialistaDao();
    dao.modificar(e);
    this.listar();
    
    }
   
}
