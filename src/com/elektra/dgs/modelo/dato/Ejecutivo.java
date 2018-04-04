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
public class Ejecutivo extends Persona{
    
    private final int numEjecutivo;

    public Ejecutivo(int numEjecutivo, String nombre, String pApellido, String sApellido, Domicilio domicilio, LocalDate fechaNac,
                        String user, String pass) {
        super(nombre, pApellido, sApellido, domicilio, fechaNac, user, pass);
        this.numEjecutivo = numEjecutivo;
        
    } 
    
    
}
