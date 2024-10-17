package org.example.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ServiciosPeluqueria")
public class ServicioPeluqueria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int precio;

    // Constructor con parámetros
    public ServicioPeluqueria(String nombre, String descripcion, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public ServicioPeluqueria() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Servicio: " +
                "ID = |" + id + "| \t" +
                "Nombre = |" + nombre + "| \t" +
                "Descripción = |" + descripcion + "| \t" +
                "Precio = |" + precio + "| \t";
    }
}



