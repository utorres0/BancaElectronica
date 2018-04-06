/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.exception.CuentaInexistenteException;
import com.elektra.dgs.modelo.dato.Cliente;
import com.elektra.dgs.modelo.dato.Ejecutivo;
import com.elektra.dgs.modelo.dato.Persona;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class LoginService {

    private static final int EJECUTIVO = 1;
    private static final int CLIENTE = 1;
    private String user;
    private String pass;
    private Persona usuario;
    private static final Banco BANCO = Banco.getBanco();

    public LoginService(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public boolean isCliente() throws CuentaInexistenteException {
        ArrayList<Cliente> clientes = BANCO.getClientes();

        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.getUser().equals(this.user))
                .filter(c -> c.getPass().equals(this.pass))
                .findFirst();

        ArrayList<Ejecutivo> ejecutivos = BANCO.getEjecutivos();

        Optional<Ejecutivo> ejecutivo = ejecutivos.stream()
                .filter(c -> c.getUser().equals(this.user))
                .filter(c -> c.getPass().equals(this.pass))
                .findFirst();

        if (!ejecutivo.isPresent() && cliente.isPresent()) {
            this.usuario = cliente.get();
            return true;
        } else if (ejecutivo.isPresent() && !cliente.isPresent()) {
            this.usuario = ejecutivo.get();
            return false;
        } else {
            throw new CuentaInexistenteException();
        }
    }

    public Persona getUsuario() {
        return this.usuario;
    }

}
