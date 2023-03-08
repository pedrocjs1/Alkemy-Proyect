package com.challenge.backend.repositories;

import com.challenge.backend.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    List<Personaje> findAllByNombre(String nombre);
    List<Personaje> findByEdad(Double edad);
    List<Personaje> findByPeliculas(Long idPelicula);
    Personaje findByNombre(String nombre);
}