package com.test.modelo;


public class Registro {


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Registro(String cedula, String hora) {
        this.cedula = cedula;
        this.hora = hora;
    }

    public Registro() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
   private String cedula, hora;
     
    
}
