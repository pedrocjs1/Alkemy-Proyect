package com.challenge.backend.DTO;

import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.PeliculaSerie;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculaDTO {
    private Long id;
    private String titulo;
    this.fechaCreacion = peliculaSerie.getFechaCreacion();
    this.personajes = peliculaSerie.getPersonajes().stream().map(DetallePersonajeDTO::new).collect(Collectors.toList());
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
        return califacion;
    }

    public List<DetallePersonajeDTO> getPersonajes() {
        return personajes;
    }
}
