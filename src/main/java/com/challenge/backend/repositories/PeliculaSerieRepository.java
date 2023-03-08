package com.challenge.backend.repositories;

import com.challenge.backend.DTO.DetallePersonajeDTO;
import com.challenge.backend.DTO.PeliculaDTO;
import com.challenge.backend.models.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {

    PeliculaSerie findByTitulo(String nombre);

    List<PeliculaSerie> findAllByTitulo(String nombre);




}
