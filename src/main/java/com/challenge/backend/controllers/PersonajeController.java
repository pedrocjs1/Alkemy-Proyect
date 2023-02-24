package com.challenge.backend.controllers;

import com.challenge.backend.models.Personaje;
import com.challenge.backend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/obtenerPersonajes")
    public List<Personaje> obtenerPersonajes() {
        return personajeService.ObtenerPersonajes();
    }

    @GetMapping("/obtenerPersonajes/{id}")
    public Personaje obtenerPersonaje(@PathVariable Long id) {
        return personajeService.ObtenerPersonaje(id);
    }

    @PutMapping("/actualizarPersonaje/{id}")
    public ResponseEntity<?> actualizarPersonaje(@RequestBody Personaje personaje, @PathVariable Long id) {
        if(personaje.getNombre().trim().equals("") || personaje.getNombre() == null) {
            return new ResponseEntity<>("El nombre esta vacio",HttpStatus.FORBIDDEN);
        }
        if(personaje.getEdad() == null || personaje.getEdad().isNaN()) {
            return new ResponseEntity<>("La edad es incorrecta",HttpStatus.FORBIDDEN);
        }
        if(personaje.getHistoria() == null || personaje.getHistoria().equals("")) {
            return new ResponseEntity<>("La historia está vacía",HttpStatus.FORBIDDEN);
        }
        if(personaje.getPeso() == null || personaje.getPeso().isNaN()) {
            return new ResponseEntity<>("El peso no es válido",HttpStatus.FORBIDDEN);
        }
        if(personaje.getImage() == null || personaje.getImage().equals("")) {
            return new ResponseEntity<>("La URL no es válida", HttpStatus.FORBIDDEN);
        }
        personajeService.ActualizarPersonaje(personaje, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/crearPersonaje")
    public ResponseEntity<?> crearPersonaje(@RequestBody Personaje personaje) {
        if(personaje.getNombre().trim().equals("") || personaje.getNombre() == null) {
            return new ResponseEntity<>("El nombre esta vacio",HttpStatus.FORBIDDEN);
        }
        if(personaje.getEdad() == null || personaje.getEdad().isNaN()) {
            return new ResponseEntity<>("La edad es incorrecta",HttpStatus.FORBIDDEN);
        }
        if(personaje.getHistoria() == null || personaje.getHistoria().equals("")) {
            return new ResponseEntity<>("La historia está vacía",HttpStatus.FORBIDDEN);
        }
        if(personaje.getPeso() == null || personaje.getPeso().isNaN()) {
            return new ResponseEntity<>("El peso no es válido",HttpStatus.FORBIDDEN);
        }
        if(personaje.getImage() == null || personaje.getImage().equals("")) {
            return new ResponseEntity<>("La URL no es válida", HttpStatus.FORBIDDEN);
        }
        personajeService.CrearPersonaje(personaje);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPersonaje/{id}")
    public ResponseEntity<?> eliminarPersonaje(@PathVariable Long id) {
        personajeService.EliminarPersonaje(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}