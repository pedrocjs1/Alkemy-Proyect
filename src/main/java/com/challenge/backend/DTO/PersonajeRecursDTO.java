package com.challenge.backend.DTO;

import com.challenge.backend.models.Personaje;

public class PersonajeRecursDTO {
    private Long id;

    private String image;

    private String nombre;

    private Double edad;

    private Double peso;

    private String historia;

    public PersonajeRecursDTO(Personaje personaje) {
        this.id = personaje.getId();
        this.image = personaje.getNombre();
        this.nombre = personaje.getNombre();
        this.edad = personaje.getEdad();
        this.peso = personaje.getPeso();
        this.historia = personaje.getHistoria();
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
}
