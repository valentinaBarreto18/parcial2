package org.example.Aplicacion.Service;

import org.example.Domain.Cliente;


    public interface ClienteService {
        void registrarCliente(Cliente cliente);
        Cliente obtenerClientePorId(int id);
        void eliminarCliente(int id);
        void mostrarClientes();
    }

