package com.challenge.backend.services.implementation;

import com.challenge.backend.models.Genero;
import com.challenge.backend.repositories.GeneroRepository;
import com.challenge.backend.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    public void crearGenero(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    public Genero findByNombre(String name) {
        return generoRepository.findByNombre(name);
    }
}