package com.challenge.backend.models;


import com.challenge.backend.enums.Calificacion;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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
    private Set<Personaje> personajes = new HashSet<>();

    @OneToMany(mappedBy = "peliculaSerie")
    private List<Genero> generos;

    public PeliculaSerie() {
    }

    public PeliculaSerie(String titulo, Date fechaCreacion, Calificacion calificacion, List<Genero> generos) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.generos = generos;
    }

    public void AddPersonajes(Personaje personaje) {
        this.personajes.add(personaje);
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

    public Set<Personaje> getPersonajes() {
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

    public void setPersonaje(Set<Personaje> personaje) {
        this.personajes = personaje;
    }
}
