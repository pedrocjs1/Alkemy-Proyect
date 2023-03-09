package com.challenge.backend.models;


import com.challenge.backend.enums.Calificacion;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PeliculaSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(strategy = "native", name = "native")
    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private Calificacion calificacion;
    @ManyToMany(mappedBy = "peliculas", fetch = FetchType.EAGER)
    private List<Personaje> personajes = new ArrayList<>();
    @OneToMany(mappedBy = "peliculaSerie")
    private List<Genero> generos = new ArrayList<>();
    public PeliculaSerie() {
    }

    public PeliculaSerie(String titulo, Date fechaCreacion, Calificacion calificacion, List<Personaje> personajes, List<Genero> generos) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.generos = generos;
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

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
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

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Personaje> getPersonaje() {
        return personajes;
    }

    public void setPersonaje(List<Personaje> personaje) {
        this.personajes = personaje;
    }
}
