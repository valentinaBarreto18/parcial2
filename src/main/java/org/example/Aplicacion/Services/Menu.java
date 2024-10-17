package org.example.Aplicacion.Services;

import javax.swing.*;
import org.example.Domain.ServicioPeluqueria;


public class Menu {
    private final ServicioPeluqueriaService servicioPeluqueriaService;

    public Menu(ServicioPeluqueriaService servicioPeluqueriaService) {
        this.servicioPeluqueriaService = servicioPeluqueriaService;
    }

    public void iniciar() {
        while (true) {
            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opción válida: \n" +
                        "1. Registrar servicio \n" +
                        "2. Borrar servicio \n" +
                        "3. Actualizar servicio \n" +
                        "4. Lista de servicios \n" +
                        "5. Buscar servicio \n" +
                        "6. Salir"));

                switch (opcion) {
                    case 1 -> crearServicio();
                    case 2 -> eliminarServicio();
                    case 3 -> actualizarServicio();
                    case 4 -> listarServicios();
                    case 5 -> buscarServicio();
                    case 6 -> {
                        return;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }


    public void crearServicio() {
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del servicio: ");
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del servicio: ");
            int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del servicio: "));

            ServicioPeluqueria servicio = new ServicioPeluqueria(nombre, descripcion, precio);
            servicioPeluqueriaService.crearServicio(servicio);

            JOptionPane.showMessageDialog(null, "Servicio registrado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un valor numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el servicio: " + e.getMessage());
        }
    }


    public void eliminarServicio() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio a eliminar: "));
            servicioPeluqueriaService.eliminarServicio(id);
            JOptionPane.showMessageDialog(null, "Servicio eliminado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un valor numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el servicio: " + e.getMessage());
        }
    }

    // Método para actualizar un servicio de peluquería
    public void actualizarServicio() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio a actualizar: "));
            ServicioPeluqueria servicio = servicioPeluqueriaService.buscarServicioPorId(id);

            if (servicio != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del servicio: ", servicio.getNombre());
                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del servicio: ", servicio.getDescripcion());
                int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio del servicio: ", servicio.getPrecio()));

                servicio.setNombre(nuevoNombre);
                servicio.setDescripcion(nuevaDescripcion);
                servicio.setPrecio(nuevoPrecio);

                servicioPeluqueriaService.actualizarServicio(servicio);
                JOptionPane.showMessageDialog(null, "Servicio actualizado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el servicio con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio o ID debe ser un valor numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el servicio: " + e.getMessage());
        }
    }


    public void listarServicios() {
        try {
            var servicios = servicioPeluqueriaService.listarServicios();
            if (servicios.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay servicios registrados.");
            } else {
                StringBuilder listaServicios = new StringBuilder();
                for (ServicioPeluqueria servicio : servicios) {
                    listaServicios.append(servicio).append("\n");
                }
                JOptionPane.showMessageDialog(null, listaServicios.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los servicios: " + e.getMessage());
        }
    }


    public void buscarServicio() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del servicio a buscar: "));
            ServicioPeluqueria servicio = servicioPeluqueriaService.buscarServicioPorId(id);

            if (servicio != null) {
                JOptionPane.showMessageDialog(null, servicio.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el servicio con el ID proporcionado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID debe ser un valor numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el servicio: " + e.getMessage());
        }
    }
}
