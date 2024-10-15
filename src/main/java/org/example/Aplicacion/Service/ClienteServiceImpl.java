package org.example.Aplicacion.Service;

import org.example.Domain.Cliente;

import java.util.List;

    public class ClienteServiceImpl implements ClienteService {
        private final ClienteRepository repository = new JpaClienteRepository();

        @Override
        public void registrarCliente(Cliente cliente) {
            repository.guardar(cliente);
            System.out.println("Cliente registrado: " + cliente);
        }

        @Override
        public Cliente obtenerClientePorId(int id) {
            Cliente cliente = repository.buscarPorId(id);
            System.out.println(cliente != null ? cliente : "Cliente no encontrado");
            return cliente;
        }

        @Override
        public void eliminarCliente(int id) {
            repository.eliminar(id);
            System.out.println("Cliente eliminado con ID: " + id);
        }

        @Override
        public void mostrarClientes() {
            List<Cliente> clientes = repository.obtenerTodos();
            clientes.forEach(System.out::println);
        }
    }

