package com.challenge.backend.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nombre;
    private String imagen;

    @ManyToOne()
    private PeliculaSerie peliculaSerie;

    public Genero() {
    }

    public Genero(String nombre, String imagen, PeliculaSerie peliculaSerie) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculaSerie = peliculaSerie;
    }

    public Genero(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PeliculaSerie getPelicula() {
        return peliculaSerie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPelicula(PeliculaSerie pelicula) {
        this.peliculaSerie = pelicula;
    }
}