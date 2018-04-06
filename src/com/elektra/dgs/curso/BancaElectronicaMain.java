/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.curso;

import com.elektra.dgs.exception.CuentaInexistenteException;
import com.elektra.dgs.modelo.Banco;
import com.elektra.dgs.modelo.LoginService;
import com.elektra.dgs.modelo.Menu;
import com.elektra.dgs.modelo.dato.Cliente;
import com.elektra.dgs.modelo.dato.Ejecutivo;
import com.elektra.dgs.modelo.dato.Persona;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class BancaElectronicaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        //bien
        //login
        //ejecutivo
        //alta CLIENTE
        //baja CLIENTE
        //modificar CLIENTE
        //alta CUENTA
        //bloquear CUENTA
        //consulta CUENTA
        //cliente
        //consultar listado CUENTAS
        //consultar estado CUENTA (determinar balance)
        //depositar a la CUENTA
        //retiro de la CUENTA
        //TRANFERIR entre CUENTAS del mismo CLIENTE(deseable) //mejor de entre cuentas de el mismo u otro cliente.
        Ejecutivo e = new Ejecutivo(1, "Ubaldo", "Torres", "Juarez", null, LocalDate.parse("1995-07-20"), "1", "1");
        Banco b = Banco.getBanco();
        b.agregarEjecutivo(e);

        Menu menu = new Menu();
        boolean running = true;

        while (running) {
            Scanner sc = new Scanner(System.in);

            System.out.println(b.obtenerMsgBienvenida());
            System.out.println("Ingrese usuario: ");
            String user = sc.nextLine();
            System.out.println("Ingrese pass: ");
            String pass = sc.nextLine();

            LoginService ls = new LoginService(user, pass);

            try {
                if (!ls.isCliente()) {
                    boolean logged = true;
                    while (logged) {

                        menu.imprimirMenuEjecutivo();
                        int option = sc.nextInt();
                        switch (option) {
                            case 1:
                                menu.altaClienteMenu();
                                break;
                            case 2:
                                menu.bajaClienteMenu();
                                break;
                            case 3:
                                menu.menuModificarCliente();
                                break;
                            case 4:
                                menu.altaCuentaMenu();
                                break;
                            case 5:
                                menu.bloqueoCuentaMenu();
                                break;
                            case 6:
                                menu.consultaCuentaMenu();
                                break;
                            case 7:
                                running = false;
                                logged = false;
                                break;
                            case 8:
                                logged = false;
                                break;
                            default:

                        }
                    }

                } else {
                    Cliente clienteLogeado = (Cliente) ls.getUsuario();
                    boolean logged = true;
                    while (logged) {
                        menu.imprimirMenuCliente();
                        int option = sc.nextInt();
                        switch (option) {
                            case 1:
                                menu.imprimeListadoCuenta(clienteLogeado);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                logged=false;
                                running=false;
                                break;
                            case 7:
                                logged = false;
                                break;

                        }
                    }
                }
            } catch (CuentaInexistenteException ex) {
                System.out.println("No existe el usuario. Verifique datos.");;
            }

        }
    }

}
