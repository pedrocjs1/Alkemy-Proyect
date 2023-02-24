package com.challenge.backend.repositories;

import com.challenge.backend.models.PeliculaSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
}
