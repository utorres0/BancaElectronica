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
public class CuentaDeAhorros extends Cuenta {

    private double tasaInteresAnual;
    private static int indexNumCuenta=1;

    public CuentaDeAhorros(double tasaInteresAnual, LocalDate fechaApertura, double saldoInicial, Estado estado) {
        super(fechaApertura, saldoInicial, estado);
        this.tasaInteresAnual = tasaInteresAnual;
    }

    public void calcularIntereses() {

    }

    @Override
    public String toString() {
        return "CuentaDeAhorros: { tasaInteresAnual: " + this.tasaInteresAnual +"}"+ super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
