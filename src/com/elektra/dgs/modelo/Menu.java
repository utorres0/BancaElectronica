/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dgs.modelo;

import com.elektra.dgs.exception.CuentaInexistenteException;
import com.elektra.dgs.modelo.dato.Cliente;
import com.elektra.dgs.modelo.dato.Estado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author 180402 Grupo Salinas
 */
public class Menu {

    private static final int EJECUTIVO = 1;
    private static final int CLIENTE = 1;
    private final Scanner sc = new Scanner(System.in);
    private final Banco b = Banco.getBanco();

    public void imprimirMenuEjecutivo() {
        StringBuilder menu = new StringBuilder();
        menu.append("========== MENU EJECUTIVO ==========\n");

        menu.append("Opción '1': Alta de Cliente.\n");
        menu.append("Opción '2': Baja de Cliente.\n");
        menu.append("Opción '3': Modificación de Cliente.\n");
        menu.append("Opción '4': Alta de Cuenta.\n");
        menu.append("Opción '5': Bloqueo de Cuenta.\n");
        menu.append("Opción '6': Consulta de Cuenta.\n");
        menu.append("Opción '7': Salir del sistema.\n");
        menu.append("Opción '8': Cerrar sesión.\nSeleccione la opción deseada:");

        System.out.println(menu.toString());
    }

    public void imprimirMenuCliente() {
        StringBuilder menu = new StringBuilder();
        menu.append("========== MENU CLIENTE ==========\n");

        menu.append("Opción '1': Consultar Listado de cuentas.\n");
        menu.append("Opción '2': Estado de cuenta.\n");
        menu.append("Opción '3': Deposito.\n");
        menu.append("Opción '4': Retiro.\n");
        menu.append("Opción '5': Transferir.\n");
        menu.append("Opción '6': Salir del sistema.\n");
        menu.append("Opción '7': Cerrar sesión.\nSeleccione la opción deseada:");

        System.out.println(menu.toString());
    }

    public void altaClienteMenu() {

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

    public void bajaClienteMenu() {
        System.out.println("Ingrese el numero de cliente: ");
        int numCliente = Integer.parseInt(sc.nextLine());

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
        int caso = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el num de cliente: ");
        int numCliente = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el saldo inicial: ");
        double saldoInicial = Double.parseDouble(sc.nextLine());

        ArrayList<Cliente> clientes = b.getClientes();
        switch (caso) {
            case 1:

                System.out.println("Ingrese tasa de interes anual: ");
                double tasaInteres = Double.parseDouble(sc.nextLine());
                Cliente cliente1 = clientes.stream()
                        .filter(c -> c.getNumCliente() == numCliente).findFirst().get();
                System.out.println(cliente1.crearCuentaAhorros(saldoInicial, tasaInteres));
                break;

            case 2:

                System.out.println("Ingrese el costo de manejo mensual: ");
                double costoManejoMensual = Double.parseDouble(sc.nextLine());
                Cliente cliente2 = clientes.stream()
                        .filter(c -> c.getNumCliente() == numCliente).findFirst().get();

                System.out.println(cliente2.crearCuentaCheques(saldoInicial, costoManejoMensual));

                break;
        }
    }

    /**
     * Realiza la consulta de una sola cuenta no importando el tipo.
     *
     */
    public void consultaCuentaMenu() {
        System.out.println("Ingrese numero de cliente: ");
        int numCliente = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese numero de cuenta a consular");
        int numCuenta = Integer.parseInt(sc.nextLine());

        ArrayList<Cliente> clientes = b.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNumCliente() == numCliente).findFirst().get();

        try {
            System.out.println(cliente.consultarCuenta(numCuenta));
        } catch (CuentaInexistenteException e) {
            System.out.println("No se encontro la cuenta: " + e.toString());
        }
    }

    public void bloqueoCuentaMenu() {
        System.out.println("Ingrese numero de cliente: ");
        int numCliente = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese numero de cuenta a bloquear");
        int numCuenta = Integer.parseInt(sc.nextLine());

        ArrayList<Cliente> clientes = b.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getNumCliente() == numCliente).findFirst().get();

        ArrayList<Cuenta> cuentas = cliente.consultarCuentasCliente();
        Cuenta cuenta = cuentas.stream().filter(c -> c.getNumCuenta() == numCuenta).findFirst().get();

        cuenta.setEstado(Estado.BLOQUEADA);
        System.out.println("Cuenta bloqueada: " + cuenta.toString());
    }

    public void imprimeListadoCuenta(Cliente c) {
        for (Cuenta cuenta : c.consultarCuentasCliente()) {
            System.out.println(cuenta);
        }
    }

    public void depositarACuenta(Cliente c, int numCuenta) {
        /*try {
            ArrayList<Cuenta> cuentas = c.consultarCuentasCliente();
            if (cuentas.contains(c)) {
            }
        } catch (CuentaInexistenteException ex) {
            System.out.println("Cuenta no existente");
        }*/
    }
}
