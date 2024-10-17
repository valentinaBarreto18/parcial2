package org.example.Aplicacion.Services;
import org.example.Infrastructure.FileServicioPeluqueriaRepository;

    public class Main {
        public static void main(String[] args) {

            FileServicioPeluqueriaRepository servicioPeluqueriaRepository = new FileServicioPeluqueriaRepository();


            ServicioPeluqueriaService servicioPeluqueriaService = new ServicioPeluqueriaService(servicioPeluqueriaRepository);


            Menu menu = new Menu(servicioPeluqueriaService);


            menu.iniciar();


            servicioPeluqueriaRepository.cerrar();
        }
    }


