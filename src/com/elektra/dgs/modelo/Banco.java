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
    private static final Banco banco = new Banco();
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cliente> clientes;
    
    private Banco(){}
}
