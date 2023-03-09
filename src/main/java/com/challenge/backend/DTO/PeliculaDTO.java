package com.challenge.backend.DTO;

import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.models.Personaje;

import java.util.Date;
import java.util.List;

public class PeliculaDTO {
    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private Calificacion calificacion;
    private List<Personaje> personajes;

    public PeliculaDTO(PeliculaSerie peliculaSerie) {
        this.titulo = peliculaSerie.getTitulo();
        this.fechaCreacion = peliculaSerie.getFechaCreacion();
        this.calificacion = peliculaSerie.getCalificacion();
        this.personajes = peliculaSerie.getPersonajes();
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

    public Calificacion getCalifacion() {
        return calificacion;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
