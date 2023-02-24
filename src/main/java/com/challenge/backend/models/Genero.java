package com.challenge.backend.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Genero {

    private Long id;

    private String nombre;


    @ManyToMany
    @JoinTable(
            name = "peliculas_series_generos",
            joinColumns = @JoinColumn(name = "generos_id"),
            inverseJoinColumns = @JoinColumn(name = "peliculaSerie_id" )
    )
    private List<PeliculaSerie> pelicula = new ArrayList<>();


    public Genero() {
    }

    public Genero(Long id, String nombre, List<PeliculaSerie> pelicula) {
        this.id = id;
        this.nombre = nombre;
        this.pelicula = pelicula;
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
