package org.example.Aplicacion.Service;

import org.example.Domain.Cliente;

import java.util.Scanner;



import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            ClienteService clienteService = new ClienteServiceImpl();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Sistema de Gestión de Peluquería ---");
                System.out.println("1. Registrar cliente");
                System.out.println("2. Buscar cliente por ID");
                System.out.println("3. Mostrar todos los clientes");
                System.out.println("4. Eliminar cliente por ID");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Servicio solicitado: ");
                        String servicio = scanner.nextLine();
                        Cliente cliente = new Cliente(nombre, servicio);
                        clienteService.registrarCliente(cliente);
                        break;

                    case 2:
                        System.out.print("ID del cliente a buscar: ");
                        int idBuscar = scanner.nextInt();
                        clienteService.obtenerClientePorId(idBuscar);
                        break;

                    case 3:
                        System.out.println("Lista de clientes:");
                        clienteService.mostrarClientes();
                        break;

                    case 4:
                        System.out.print("ID del cliente a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        clienteService.eliminarCliente(idEliminar);
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            }
        }
    }

