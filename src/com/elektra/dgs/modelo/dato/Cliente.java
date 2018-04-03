/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo.dato;

import com.elektra.dgs.modelo.Cuenta;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Cliente extends Persona {

    private final int numCliente;
    private ArrayList<Cuenta> cuentas;
    private String rfc;

    public Cliente(int numCliente, ArrayList<Cuenta> cuentas, String rfc, String nombre, String pApellido, String sApellido, Domicilio domicilio, LocalDate fechaNac) {
        super(nombre, pApellido, sApellido, domicilio, fechaNac);
        this.numCliente = numCliente;
        this.cuentas = cuentas;
        this.rfc = rfc;
    }

    public void crearCuentaAhorros(double saldoInicial, double tasaAnualInteres) {

    }

    public void crearCuentaCheques(double saldoInicial, double comisionMensual) {

    }

    public void cancelarCuenta(int numCuenta) {

    }

    public Cuenta consultarCuenta(int numCuenta) {
        return null;
    }
    
    public ArrayList<Cuenta> consultarCuentasCliente(){
        return null;
    }

}
