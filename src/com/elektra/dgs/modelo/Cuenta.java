/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.modelo.dato.Estado;
import java.time.LocalDate;

/**
 *
 * @author 180402 Grupo Salinas
 */
public abstract class Cuenta {
    
    private final int numCuenta;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private double saldo;
    private Estado estado;
    
    public Cuenta(int numCuenta, LocalDate fechaApertura, double saldoInicial, Estado estado){
        this.numCuenta=numCuenta;
        this.fechaApertura=fechaApertura;
        this.saldo=saldoInicial;
        this.estado=estado;
    }
    
    public void abonar(double cantidad){
    
    }
    
    public void retirar(double cantidad){
    
    }
    
    public double consultarSaldo(){
        return this.saldo;
    }
    
    public void imprimirDatos(){
    
    }
}
