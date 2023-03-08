package com.challenge.backend.services.implementation;

import com.challenge.backend.models.PeliculaSerie;
import com.challenge.backend.models.Personaje;
import com.challenge.backend.repositories.PeliculaSerieRepository;
import com.challenge.backend.repositories.PersonajeRepository;
import com.challenge.backend.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {
    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private PeliculaSerieRepository peliculaSerieRepository;
    
    @Override
    public void CrearPersonaje(Personaje personaje) {
        personajeRepository.save(personaje);
    }

    @Override
    public List<Personaje> ObtenerPersonajes() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje ObtenerPersonaje(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

    @Override
    public void ActualizarPersonaje(Personaje personaje, Long id) {
        Personaje personaje1 = personajeRepository.findById(id).orElse(null);
        personaje1.setImage(personaje.getImage());
        personaje1.setEdad(personaje.getEdad());
        personaje1.setHistoria(personaje.getHistoria());
        personaje1.setNombre(personaje.getNombre());
        personaje1.setPeso(personaje.getPeso());
        personajeRepository.save(personaje1);
    }

    @Override
    public void EliminarPersonaje(Long id) {
        personajeRepository.deleteById(id);
    }
    @Override
    public List<Personaje> ObtenerCarecteristicasPersonaje(String nombre, Double edad, Long idPelicula) {
        if(nombre != null && nombre.isEmpty()) {
            return personajeRepository.findAllByNombre(nombre);
        } else if (edad != null && edad.isNaN()) {
            return personajeRepository.findByEdad(edad);
        } else if (idPelicula != null) {
            return personajeRepository.findByPeliculas(idPelicula);
        }
        return personajeRepository.findAll();
    }
}