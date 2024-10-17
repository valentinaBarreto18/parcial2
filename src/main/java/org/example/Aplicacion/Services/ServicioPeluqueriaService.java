package org.example.Aplicacion.Services;

import org.example.Domain.ServicioPeluqueria;
import org.example.interfaces.ServicioPeluqueriaRepository;

import java.util.List;

public class ServicioPeluqueriaService {


    private final ServicioPeluqueriaRepository servicioPeluqueriaRepository;

    public ServicioPeluqueriaService(ServicioPeluqueriaRepository servicioPeluqueriaRepository) {
        this.servicioPeluqueriaRepository = servicioPeluqueriaRepository;
    }


    public void crearServicio(ServicioPeluqueria servicio) {
        servicioPeluqueriaRepository.save(servicio);
    }


    public List<ServicioPeluqueria> listarServicios() {
        return servicioPeluqueriaRepository.findAll();
    }


    public void eliminarServicio(int id) {
        servicioPeluqueriaRepository.delete(id);
    }


    public ServicioPeluqueria buscarServicioPorId(int id) {
        return servicioPeluqueriaRepository.findById(id);
    }


    public void actualizarServicio(ServicioPeluqueria servicio) {
        servicioPeluqueriaRepository.update(servicio);
    }
}


