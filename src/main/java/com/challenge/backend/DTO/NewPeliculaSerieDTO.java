package com.challenge.backend.DTO;

import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.Genero;

import java.util.Date;
import java.util.List;

public class NewPeliculaSerieDTO {
    private String titulo;
    private Date fechaCreacion;
    private Calificacion calificacion;
    private List<PersonajeDTO> personajes;
    private List<Genero> generos;

    public NewPeliculaSerieDTO(String titulo, Date fechaCreacion, Calificacion calificacion, List<PersonajeDTO> personajes, List<Genero> generos) {
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.generos = generos;
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

    public List<PersonajeDTO> getPersonajes() {
        return personajes;
    }

    public List<Genero> getGeneros() {
        return generos;
    }
}
