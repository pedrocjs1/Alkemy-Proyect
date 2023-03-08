package com.challenge.backend.services;

import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.models.PeliculaSerie;

import java.util.List;

public interface PeliculaSerieService {
    PeliculaSerie ObtenerPeliculaNombre(String nombre);
    void savePeliculaSerie(PeliculaSerie peliculaSerie);
}