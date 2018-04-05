/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo.dato;

import com.elektra.dgs.modelo.Banco;
import com.elektra.dgs.modelo.Cuenta;
import com.elektra.dgs.modelo.CuentaDeAhorros;
import com.elektra.dgs.modelo.CuentaDeCheques;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Cliente extends Persona {

    private final int numCliente;
    private ArrayList<Cuenta> cuentas;
    private String rfc;

    /**
     *
     * @param numCliente Numero de cliente
     * @param cuentas cuentas del cliente
     * @param rfc rfc del cliente
     * @param nombre
     * @param pApellido
     * @param sApellido
     * @param domicilio
     * @param fechaNac
     * @param user
     * @param pass
     */
    public Cliente(int numCliente, ArrayList<Cuenta> cuentas, String rfc, String nombre, String pApellido, String sApellido, Domicilio domicilio, LocalDate fechaNac, String user, String pass) {
        super(nombre, pApellido, sApellido, domicilio, fechaNac, user, pass);
        this.numCliente = numCliente;
        //this.cuentas = cuentas;
        this.rfc = rfc;
        this.cuentas = new ArrayList<>();
        Banco b = Banco.getBanco();
        b.agregarCliente(this);
    }

    public int getNumCliente() {
        return this.numCliente;
    }

    public void crearCuentaAhorros(double saldoInicial, double tasaAnualInteres) {
        CuentaDeAhorros nuevaCuenta = new CuentaDeAhorros(tasaAnualInteres, 12, LocalDate.now(), saldoInicial, Estado.ACTIVA);
        this.cuentas.add(nuevaCuenta);
    }

    public void crearCuentaCheques(double saldoInicial, double comisionMensual) {
        CuentaDeCheques nuevaCuenta = new CuentaDeCheques(comisionMensual, 15, LocalDate.now(), saldoInicial, Estado.ACTIVA);
        this.cuentas.add(nuevaCuenta);
    }

    public void cancelarCuenta(int numCuenta) {
        Iterator<Cuenta> i = this.cuentas.iterator();
        while (i.hasNext()) {
            Cuenta c = i.next();
            if (c.consultarSaldo() == 0.0D && c.getNumCuenta() == numCuenta) {
                i.remove();
                System.out.println("Cuenta borrada exitosamente");
                break;
            }
        }
    }

    public Cuenta consultarCuenta(int numCuenta) {
        return null;
    }

    public ArrayList<Cuenta> consultarCuentasCliente() {
        return this.cuentas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numCliente=" + numCliente + ", cuentas=" + cuentas + ", rfc=" + rfc + '}' + super.toString();
    }

}
