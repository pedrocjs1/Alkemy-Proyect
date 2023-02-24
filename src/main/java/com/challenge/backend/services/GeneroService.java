package com.challenge.backend.services;

import com.challenge.backend.models.Genero;

public interface GeneroService {
    void crearGenero(Genero genero);
    Genero findByNombre(String name);
}