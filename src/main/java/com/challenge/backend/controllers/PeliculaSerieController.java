package com.challenge.backend.controllers;

import com.challenge.backend.DTO.NewPeliculaSerieDTO;
import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.Genero;
import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.models.Personaje;
import com.challenge.backend.repositories.PersonajeRepository;
import com.challenge.backend.services.PeliculaSerieService;
import com.challenge.backend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pelicula")
public class PeliculaSerieController {

    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @Autowired
    private PersonajeService personajeService;

    @Autowired
    private PersonajeRepository personajeRepository;

    @GetMapping("/{nombre}")
    public PeliculaDTO ObtenerPeliculaDetalle(@PathVariable String nombre) {
        PeliculaSerie peliculaSerie = peliculaSerieService.ObtenerPeliculaNombre(nombre);
        return new PeliculaDTO(peliculaSerie);
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Object> crearPelicula(@RequestBody NewPeliculaSerieDTO newPeliculaSerieDTO) {
        String titulo = newPeliculaSerieDTO.getTitulo();
        Date fecha = newPeliculaSerieDTO.getFechaCreacion();
        Calificacion calificacion = newPeliculaSerieDTO.getCalificacion();
        List<Personaje> personajes = newPeliculaSerieDTO.getPersonajes().stream().map(personajeDTO -> personajeRepository.findByNombre(personajeDTO.getNombre())).collect(Collectors.toList());
        List<Genero> generos = newPeliculaSerieDTO.getGeneros();
        PeliculaSerie peliculaSerie1 = new PeliculaSerie(titulo, fecha, calificacion, personajes, generos);
        peliculaSerieService.savePeliculaSerie(peliculaSerie1);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}