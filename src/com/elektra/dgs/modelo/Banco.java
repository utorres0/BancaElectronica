/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.modelo.dato.Cliente;
import com.elektra.dgs.modelo.dato.Domicilio;
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

    private Banco() {
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
}
