package org.example.Domain;

    public class Cliente {
        String nombre;
        private  int id;
        private String servicio;



        public Cliente(String nombre, String servicio) {
            this.nombre = nombre;
            this.servicio = servicio;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getServicio() {
            return servicio;
        }

        @Override
        public String toString() {
            return "Cliente{id=" + id + ", nombre='" + nombre + "', servicio='" + servicio + "'}";
        }
    }


