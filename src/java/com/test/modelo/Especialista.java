
package com.test.modelo;


public class Especialista {

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCod_esp() {
        return cod_esp;
    }

    public void setCod_esp(String cod_esp) {
        this.cod_esp = cod_esp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Especialista(String doc, String nom, String cod_esp, String especialidad) {
        this.doc = doc;
        this.nom = nom;
        this.cod_esp = cod_esp;
        this.especialidad = especialidad;
    }

    private String doc, nom, cod_esp, especialidad ;


    public Especialista() {
    }
  
    
}
