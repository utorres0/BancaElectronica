/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo.dato;

import java.time.LocalDate;

/**
 *
 * @author 180402 Grupo Salinas
 */
public abstract class Persona {
    
    private String nombre;
    private String pApellido;
    private String sApellido;
    private Domicilio domicilio;
    private LocalDate fechaNac;
    private String user;
    private String pass;

    public Persona(String nombre, String pApellido, String sApellido, Domicilio domicilio, LocalDate fechaNac, String user, String pass) {
        this.nombre = nombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", pApellido=" + pApellido + ", sApellido=" + sApellido + ", domicilio=" + domicilio + ", fechaNac=" + fechaNac + ", user=" + user + ", pass=" + pass + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
   
    
    
    
}
