/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.modelo.dato.Cliente;
import com.elektra.dgs.modelo.dato.Domicilio;
import com.elektra.dgs.modelo.dato.Ejecutivo;
import java.util.ArrayList;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Banco {

    private static final Banco BANCO = new Banco();
    private final String nombre = "BANCO NACIONAL";
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cliente> clientes;
    private ArrayList<Ejecutivo> ejecutivos;

    private Banco() {
        this.domicilio = new Domicilio("Calandrias", "298", "Juan Jose Rios", "Colima", 28984);
        this.rfc = "BAN850120KIU";
        this.telefono = "+523123391421";
        this.clientes = new ArrayList<>();
        this.ejecutivos = new ArrayList<>();

    }

    public static Banco getBanco() {
        return Banco.BANCO;
    }

    public String obtenerMsgBienvenida() {
        StringBuilder msg = new StringBuilder();
        msg.append("|============================================|\n");
        msg.append("|               " + this.nombre + "               |\n");
        msg.append("|============================================|\n");
        return msg.toString();
    }

    public void agregarCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void agregarEjecutivo(Ejecutivo e) {
        this.ejecutivos.add(e);
    }

    public String getNombre() {
        return nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Ejecutivo> getEjecutivos() {
        return ejecutivos;
    }
}
