package com.challenge.backend.DTO;

import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.PeliculaSerie;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculaDTO {
    private Long id;
    private String titulo;
    private Date fechaCreacion;
    private Calificacion calificacion;
    private List<PersonajeRecursDTO> personajes;

    public PeliculaDTO(PeliculaSerie peliculaSerie) {
        this.id = peliculaSerie.getId();
        this.titulo = peliculaSerie.getTitulo();
        this.fechaCreacion = peliculaSerie.getFechaCreacion();
        this.calificacion = peliculaSerie.getCalificacion();
        this.personajes = peliculaSerie.getPersonajes().stream().map(PersonajeRecursDTO::new).collect(Collectors.toList());
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

    public List<PersonajeRecursDTO> getPersonajes() {
        return personajes;
    }
}