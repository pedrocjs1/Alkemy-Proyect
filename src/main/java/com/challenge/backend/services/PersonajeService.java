package com.challenge.backend.services;

import com.challenge.backend.models.Personaje;

import java.util.List;

public interface PersonajeService {
    void CrearPersonaje(Personaje personaje);
    List<Personaje> ObtenerPersonajes();
    Personaje ObtenerPersonaje(Long id);
    void ActualizarPersonaje(Personaje personaje, Long id);
    void EliminarPersonaje(Long id);
    List<Personaje> ObtenerCarecteristicasPersonaje(String nombre, Double edad, Long idPelicula);
}