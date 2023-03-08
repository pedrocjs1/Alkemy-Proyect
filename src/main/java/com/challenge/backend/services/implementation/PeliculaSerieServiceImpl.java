package com.challenge.backend.services.implementation;

import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.repositories.PeliculaSerieRepository;
import com.challenge.backend.services.PeliculaSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaSerieServiceImpl implements PeliculaSerieService {

    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;


    @Override
    public PeliculaSerie ObtenerPeliculaNombre(String nombre) {
        return peliculaSerieRepository.findByTitulo(nombre);
    }
}
