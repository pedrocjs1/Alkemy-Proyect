package com.challenge.backend.controllers;

import com.challenge.backend.models.Genero;
import com.challenge.backend.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @PostMapping("/crearGenero")
    public ResponseEntity<?> crearGenero(@RequestBody Genero genero) {
        Genero genero1 = generoService.findByNombre(genero.getNombre());
        if(genero1 != null) {
            return new ResponseEntity<>("El nombre del genero no puede ser el mismo", HttpStatus.FORBIDDEN);
        }
        if(genero.getImagen() == null || genero.getImagen().equals("")) {
            return new ResponseEntity<>("La URL de la imagen es inválida", HttpStatus.FORBIDDEN);
        }
        if((genero.getNombre() == null || genero.getNombre().equals(""))) {
            return new ResponseEntity<>("El nombre no puede estar vacion", HttpStatus.FORBIDDEN);
        }
        generoService.crearGenero(genero);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}