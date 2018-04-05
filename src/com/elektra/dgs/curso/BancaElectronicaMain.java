/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.curso;

import com.elektra.dgs.modelo.Banco;
import com.elektra.dgs.modelo.LoginService;
import com.elektra.dgs.modelo.Menu;
import java.util.Scanner;

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

        Menu menu = new Menu();
        boolean running = true;

        while (running) {
            Scanner sc = new Scanner(System.in);

            Banco b = Banco.getBanco();
            System.out.println(b.obtenerMsgBienvenida());
            System.out.println("Ingrese usuario: ");
            String user = sc.nextLine();
            System.out.println("Ingrese pass: ");
            String pass = sc.nextLine();

            LoginService ls = new LoginService();
            if (user.equals("1") && pass.equals("1") && ls.getTipoUsuario()==1) {
                boolean logged = true;
                while (logged) {

                    menu.imprimirMenuGeneral();
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            menu.menuAltaCliente();
                            break;
                        case 2:
                            menu.menuBajaCliente();
                            break;
                        case 3:
                            menu.menuModificarCliente();
                            break;
                        case 4:
                            menu.altaCuentaMenu();
                            break;
                        case 6:
                            menu.consultaCuentaMenu();
                            break;
                        case 7:
                            logged = false;
                            break;
                        default:

                    }
                }

            } else {
                System.out.println("error");
            }
            running = false;

        }
    }

}
