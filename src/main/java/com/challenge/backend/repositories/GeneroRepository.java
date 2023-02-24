package com.challenge.backend.repositories;

import com.challenge.backend.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByNombre(String name);
}