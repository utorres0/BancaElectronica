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
public class CuentaDeCheques extends Cuenta {

    private double costoManejoMensual;

    public CuentaDeCheques(double costoManejoMensual, LocalDate fechaApertura, double saldoInicial, Estado estado) {
        super(fechaApertura, saldoInicial, estado);
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheques: " + this.costoManejoMensual + super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
