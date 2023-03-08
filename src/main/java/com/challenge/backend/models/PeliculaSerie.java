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

<<<<<<< Updated upstream
    @OneToMany(mappedBy = "peliculas")
    private List<Personaje> personajes = new ArrayList<>();
=======
    @ManyToMany(mappedBy = "peliculasSeries")
    private List<Genero> generos = new ArrayList<>();


    @ManyToMany(mappedBy = "")
    private List<Personaje>
>>>>>>> Stashed changes

    public PeliculaSerie() {
    }

    public PeliculaSerie(Long id, String titulo, Date fechaCreacion, Calificacion calificacion, List<Personaje> personajes) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
<<<<<<< Updated upstream
        this.personajes = personajes;
=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public List<Personaje> getPersonajes() {
        return personajes;
=======
    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
=======
    public List<Personaje> getPersonaje() {
        return personaje;
    }

    public void setPersonaje(List<Personaje> personaje) {
        this.personaje = personaje;
>>>>>>> Stashed changes
    }
}
