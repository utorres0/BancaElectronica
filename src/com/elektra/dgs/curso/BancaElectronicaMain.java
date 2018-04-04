/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.curso;

import com.elektra.dgs.modelo.Banco;
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

        boolean running = true;

        while (running) {
            Scanner sc = new Scanner(System.in);

            Banco b = Banco.getBanco();
            System.out.println(b.obtenerMsgBienvenida());
            System.out.println("Ingrese usuario: ");
            String user = sc.nextLine();
            System.out.println("Ingrese pass: ");
            String pass = sc.nextLine();

            if (user.equals("utorres0") && pass.equals("123")) {

                StringBuilder menu = new StringBuilder();
                menu.append("========== MENU EJECUTIVO ==========\n");

                menu.append("Opción '1': Alta de Cliente.\n");
                menu.append("Opción '2': Baja de Cliente.\n");
                menu.append("Opción '3': Modificación de Cliente.\n");
                menu.append("Opción '4': Alta de Cuenta.\n");
                menu.append("Opción '5': Bloqueo de Cuenta.\n");
                menu.append("Opción '6': Consulta de Cuenta.\n");
                menu.append("Opción '7': Salir del sistema.\nSeleccione la opción deseada:");

                System.out.println(menu.toString());
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("TEST");
                        break;
                    case 2:
                        break;
                    case 3:
                        running = false;
                        break;
                    default:

                }
            } else {
                System.out.println("error");
            }
        }
    }

}
