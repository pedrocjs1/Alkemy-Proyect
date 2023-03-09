package com.challenge.backend.DTO;

import com.challenge.backend.models.Personaje;

import java.util.List;
import java.util.stream.Collectors;

public class PersonajeDTO {
    private Long id;
    private String image;
    private String nombre;
    private Double edad;
    private Double peso;
    private String historia;
    private List<PeliculaDTO> peliculas;

    public PersonajeDTO(Personaje personaje) {
        this.id = personaje.getId();
        this.image = personaje.getImage();
        this.nombre = personaje.getNombre();
        this.edad = personaje.getEdad();
        this.peso = personaje.getPeso();
        this.historia = personaje.getHistoria();
        this.peliculas = personaje.getPeliculas().stream().map(peliculaSerie -> new PeliculaDTO(peliculaSerie)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getEdad() {
        return edad;
    }

    public Double getPeso() {
        return peso;
    }

    public String getHistoria() {
        return historia;
    }

    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }
}
