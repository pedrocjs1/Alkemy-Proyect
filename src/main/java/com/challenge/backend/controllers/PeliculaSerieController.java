package com.challenge.backend.controllers;

import com.challenge.backend.DTO.NewPeliculaSerieDTO;
import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.enums.Calificacion;
import com.challenge.backend.models.Genero;
import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.models.Personaje;
import com.challenge.backend.services.PeliculaSerieService;
import com.challenge.backend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pelicula")
public class PeliculaSerieController {
    @Autowired
    private PeliculaSerieService peliculaSerieService;

    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/{nombre}")
    public PeliculaDTO ObtenerPeliculaDetalle(@PathVariable String nombre) {
        PeliculaSerie peliculaSerie = peliculaSerieService.ObtenerPeliculaNombre(nombre);
        return new PeliculaDTO(peliculaSerie);
    }

    @GetMapping("/obtenerPeliculas")
    public List<PeliculaDTO> ObtenerPeliculas() {
        return peliculaSerieService.ObtenerPeliculas().stream().map(peliculaSerie -> new PeliculaDTO(peliculaSerie)).collect(Collectors.toList());
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Object> crearPelicula(@RequestBody NewPeliculaSerieDTO newPeliculaSerieDTO) {
        String titulo = newPeliculaSerieDTO.getTitulo();
        Date fecha = newPeliculaSerieDTO.getFechaCreacion();
        Calificacion calificacion = newPeliculaSerieDTO.getCalificacion();
        List<Genero> generos = newPeliculaSerieDTO.getGeneros();
        PeliculaSerie peliculaSerie1 = new PeliculaSerie(titulo, fecha, calificacion, generos);
        peliculaSerieService.savePeliculaSerie(peliculaSerie1);
        List<Personaje> personajes = newPeliculaSerieDTO.getPersonajes().stream()
                .map(personaje -> {
                    new Personaje(personaje.getImage(), personaje.getNombre(), personaje.getEdad(), personaje.getPeso(), personaje.getHistoria());
                    personaje.AddPeliculas(peliculaSerie1);
                    personajeService.CrearPersonaje(personaje);
                    return personaje;
                }).collect(Collectors.toList());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}