package org.example.interfaces;



import org.example.Domain.Cliente;

import java.util.List;


    public interface ClienteRepository {
        void guardar(Cliente cliente);
      Cliente buscarPorId(int id);
        List<Cliente> obtenerTodos();
        void eliminar(int id);
    }

