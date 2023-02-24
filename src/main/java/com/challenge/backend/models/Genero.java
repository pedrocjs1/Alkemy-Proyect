package com.challenge.backend.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String nombre;
    private String imagen;

    @ManyToMany
    @JoinTable(
            name = "peliculas_series_generos",
            joinColumns = @JoinColumn(name = "generos_id"),
            inverseJoinColumns = @JoinColumn(name = "peliculaSerie_id" )
    )
    private List<PeliculaSerie> pelicula = new ArrayList<>();


    public Genero() {
    }

    public Genero(Long id, String nombre, String imagen, List<PeliculaSerie> pelicula) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.pelicula = pelicula;
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

    public List<PeliculaSerie> getPelicula() {
        return pelicula;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPelicula(List<PeliculaSerie> pelicula) {
        this.pelicula = pelicula;
    }
}
