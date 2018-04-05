/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo.dato;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Domicilio {
    private String calle;
    private String numero;
    private String colonia;
    private String estado;
    private int codigoPostal;

    public Domicilio(String calle, String numero, String colonia, String estado, int codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }
    
    
}
