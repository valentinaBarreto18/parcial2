package org.example.interfaces;

import org.example.Domain.ServicioPeluqueria;
import java.util.List;

public interface ServicioPeluqueriaRepository {
    void save(ServicioPeluqueria servicio);      // Guardar un nuevo servicio
    void update(ServicioPeluqueria servicio);    // Actualizar un servicio existente
    void delete(int id);                         // Eliminar un servicio por ID
    ServicioPeluqueria findById(int id);         // Buscar un servicio por ID
    List<ServicioPeluqueria> findAll();          // Listar todos los servicios
}


