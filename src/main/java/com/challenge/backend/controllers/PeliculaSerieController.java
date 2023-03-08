package com.challenge.backend.controllers;

import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.services.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pelicula")
public class PeliculaSerieController {

    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @GetMapping("/{nombre}")
    public PeliculaDTO ObtenerPeliculaDetalle(@PathVariable String nombre) {
        PeliculaSerie peliculaSerie = peliculaSerieService.ObtenerPeliculaNombre(nombre);
        return new PeliculaDTO(peliculaSerie);
    }

}