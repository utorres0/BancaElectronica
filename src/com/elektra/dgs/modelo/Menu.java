/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.exception.CuentaInexistenteException;
import com.elektra.dgs.modelo.dato.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Menu {

    private static final int EJECUTIVO = 1;
    private static final int CLIENTE = 1;
    private final Scanner sc = new Scanner(System.in);
    private final Banco b = Banco.getBanco();

    public void imprimirMenuGeneral() {
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
    }

    public void menuAltaCliente() {

        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el primer apellido del cliente: ");
        String pApellido = sc.nextLine();
        System.out.println("Ingrese el segundo apellido del cliente: ");
        String sApellido = sc.nextLine();
        System.out.println("Ingrese RFC del cliente");
        String rfc = sc.nextLine();
        System.out.println("Ingrese la fecha nacimiento(Formato: AAAA-MM-DD): ");
        LocalDate fechaNac = LocalDate.parse(sc.nextLine());
        System.out.println("Ingrese el usuario deseado del cliente: ");
        String user = sc.nextLine();
        System.out.println("Ingrese la contraseña deseada del cliente: ");
        String pass = sc.nextLine();

        Cliente c = new Cliente(1, null, rfc, nombre, pApellido, sApellido, null, fechaNac, user, pass);
        System.out.println("Cliente creado. Datos: " + c);

    }

    public void menuBajaCliente() {
        System.out.println("Ingrese el numero de cliente: ");
        int numCliente = sc.nextInt();

        Iterator<Cliente> iterator = b.getClientes().iterator();

        while (iterator.hasNext()) {
            Cliente clienteToBeKilledKappa = iterator.next();
            if (clienteToBeKilledKappa.getNumCliente() == numCliente) {
                iterator.remove();
                System.out.println("Cliente encontrado y borrado con éxito.");
                break;
            }
        }
    }

    public void menuModificarCliente() {
        StringBuilder menu = new StringBuilder();
        menu.append("========== MODIFICAR CLIENTE ==========\n");

        menu.append("Opción '1': Nombre.\n");
        menu.append("Opción '2': Primer apellido.\n");
        menu.append("Opción '3': Segundo apellido.\n");
        menu.append("Opción '4': RFC.\n");
        menu.append("Opción '5': Dirección.\n");
        menu.append("Opción '6': Fecha de nacimiento.\n");
        menu.append("Seleccione la opción deseada:");

        System.out.print(menu.toString());
        int caso = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese numero de cliente: ");
        int numCliente = Integer.parseInt(sc.nextLine());
        Iterator<Cliente> iterator = b.getClientes().iterator();

        switch (caso) {
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");

                String nombre = sc.nextLine();
                while (iterator.hasNext()) {
                    Cliente clienteAModificar = iterator.next();
                    if (clienteAModificar.getNumCliente() == numCliente) {
                        clienteAModificar.setNombre(nombre);
                        System.out.println("Nombre del cliente modificado con éxito.");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese el primer apellido: ");

                String pApellido = sc.nextLine();
                while (iterator.hasNext()) {
                    Cliente clienteAModificar = iterator.next();
                    if (clienteAModificar.getNumCliente() == numCliente) {
                        clienteAModificar.setpApellido(pApellido);
                        System.out.println("Primer apellido del cliente modificado con éxito.");
                        break;
                    }
                }
                break;
            case 3:
                System.out.println("Ingrese el segundo apellido");

                String sApellido = sc.nextLine();
                while (iterator.hasNext()) {
                    Cliente clienteAModificar = iterator.next();
                    if (clienteAModificar.getNumCliente() == numCliente) {
                        clienteAModificar.setsApellido(sApellido);
                        System.out.println("Segundo apellido del cliente modificado con éxito.");
                        break;
                    }
                }
                break;
            case 4:
                System.out.println("Ingrese el nuevo RFC: ");

                String rfc = sc.nextLine();
                while (iterator.hasNext()) {
                    Cliente clienteAModificar = iterator.next();
                    if (clienteAModificar.getNumCliente() == numCliente) {
                        clienteAModificar.setRfc(rfc);
                        System.out.println("RFC del cliente modificado con éxito.");
                        break;
                    }
                }
                break;
            case 6:
                System.out.println("Ingrese la nueva fecha de nacimiento (Formato: AAAA-MM-DD): ");

                LocalDate fechaNac = LocalDate.parse(sc.nextLine());
                while (iterator.hasNext()) {
                    Cliente clienteAModificar = iterator.next();
                    if (clienteAModificar.getNumCliente() == numCliente) {
                        clienteAModificar.setFechaNac(fechaNac);
                        System.out.println("Fecha de nacimiento del cliente modificado con éxito.");
                        break;
                    }
                }

                break;
        }
    }

    public void altaCuentaMenu() {
        sc.useLocale(Locale.US);
        System.out.println("Seleccione tipo de cuenta: ");
        System.out.println("1 para ahorros y 2 para cheques: ");
        int caso = sc.nextInt();

        System.out.println("Ingrese el num de cliente: ");
        int numCliente = sc.nextInt();

        System.out.println("Ingrese el saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        Iterator<Cliente> iterator = b.getClientes().iterator();
        switch (caso) {
            case 1:

                System.out.println("Ingrese tasa de interes anual: ");
                double tasaInteres = sc.nextDouble();

                while (iterator.hasNext()) {
                    Cliente c = iterator.next();
                    if (c.getNumCliente() == numCliente) {
                        c.crearCuentaAhorros(saldoInicial, tasaInteres);
                        System.out.println("Cuenta creada");
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese el costo de manejo mensual: ");
                double costoManejoMensual = sc.nextDouble();
                while (iterator.hasNext()) {
                    Cliente c = iterator.next();
                    if (c.getNumCliente() == numCliente) {
                        c.crearCuentaCheques(saldoInicial, costoManejoMensual);
                        System.out.println("Cuenta creada");
                    }
                }
                break;
        }
    }

    public void consultaCuentaMenu() {
        System.out.println("Ingrese numero de cliente: ");
        int numCliente = sc.nextInt();

        System.out.println("Ingrese numero de cuenta a consular");
        int numCuenta = sc.nextInt();

        Iterator<Cliente> iterator = b.getClientes().iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getNumCliente() == numCliente) {

                try {
                    Cuenta cuenta = c.consultarCuenta(numCuenta);
                    if (cuenta instanceof CuentaDeAhorros) {
                        CuentaDeAhorros cuentaAhorro = (CuentaDeAhorros) cuenta;
                        System.out.println(cuenta.toString());
                    } else {
                        CuentaDeCheques cuentaCheques = (CuentaDeCheques) cuenta;
                        System.out.println(cuenta.toString());
                    }
                } catch (CuentaInexistenteException e) {
                    System.out.println("No se encontro la cuenta con ese numero");
                }

            }
        }
    }
}
