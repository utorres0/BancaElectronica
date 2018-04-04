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

   
    
    
    
}
