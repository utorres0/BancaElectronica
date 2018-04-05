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

    public Cuenta(int numCuenta, LocalDate fechaApertura, double saldoInicial, Estado estado) {
        this.numCuenta = numCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
        this.estado = estado;
    }

    public void abonar(double cantidad) {
        this.saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (this.saldo > 0) {
            this.saldo -= cantidad;
        } else {

        }
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public double consultarSaldo() {
        return this.saldo;
    }

    public void imprimirDatos() {
        System.out.println("Datos");
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numCuenta=" + numCuenta + ", fechaApertura=" + fechaApertura + ", fechaCierre=" + fechaCierre + ", saldo=" + saldo + ", estado=" + estado + '}';
    }

}
