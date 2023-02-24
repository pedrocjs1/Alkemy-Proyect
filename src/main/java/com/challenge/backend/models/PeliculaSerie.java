package com.challenge.backend.models;


import com.challenge.backend.enums.Calificacion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PeliculaSerie {

    @Id
    private Long id;

    private String titulo;

    private Date fechaCreacion;

    private Calificacion calificacion;

    @ManyToMany(mappedBy = "peliculasSeries")
    private List<Genero> generos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "personajes_peliculas_series",
            joinColumns = @JoinColumn(name = "peliculaSerie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private Personaje personaje;

    public PeliculaSerie() {
    }

    public PeliculaSerie(Long id, String titulo, Date fechaCreacion, Calificacion calificacion, Personaje personaje) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personaje = personaje;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }
}
