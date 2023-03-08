package com.challenge.backend.DTO;

import com.challenge.backend.models.Personaje;




public class DetallePersonajeDTO {


    private Long id;
    private String nombre;
    private String imagen;

    public DetallePersonajeDTO(Personaje personaje) {
        this.imagen = personaje.getImage();
        this.nombre = personaje.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }
}
