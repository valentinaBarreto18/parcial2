package org.example.Infrastructure;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Domain.ServicioPeluqueria;
import org.example.interfaces.ServicioPeluqueriaRepository;

import java.util.List;

    public class FileServicioPeluqueriaRepository implements ServicioPeluqueriaRepository {

        private final EntityManagerFactory emf;

        public FileServicioPeluqueriaRepository() {
            this.emf = Persistence.createEntityManagerFactory("PeluqueriaUp");
        }

        @Override
        public void save(ServicioPeluqueria servicio) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(servicio);  // Persistir un nuevo servicio
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }

        @Override
        public void update(ServicioPeluqueria servicio) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.merge(servicio);   // Actualizar un servicio existente
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }

        @Override
        public void delete(int id) {
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                ServicioPeluqueria servicio = em.find(ServicioPeluqueria.class, id);  // Buscar servicio por ID
                if (servicio != null) {
                    em.remove(servicio);  // Eliminar el servicio si se encuentra
                }
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }

        @Override
        public ServicioPeluqueria findById(int id) {
            EntityManager em = emf.createEntityManager();
            try {
                return em.find(ServicioPeluqueria.class, id);  // Buscar servicio por ID
            } finally {
                em.close();
            }
        }

        @Override
        public List<ServicioPeluqueria> findAll() {
            EntityManager em = emf.createEntityManager();
            try {
                return em.createQuery("SELECT s FROM ServicioPeluqueria s", ServicioPeluqueria.class)
                        .getResultList();  // Listar todos los servicios
            } finally {
                em.close();
            }
        }

        public void cerrar() {
            emf.close();  // Cerrar el EntityManagerFactory cuando ya no sea necesario
        }
    }


