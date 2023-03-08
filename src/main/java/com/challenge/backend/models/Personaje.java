package com.challenge.backend.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String image;

    private String nombre;

    private Double edad;

    private Double peso;

    private String historia;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<PeliculaSerie> peliculas = new ArrayList<>();

    public Personaje(){}

    public Personaje(String image, String nombre, Double edad, Double peso, String historia) {
        this.image = image;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getEdad() {
        return edad;
    }

    public Double getPeso() {
        return peso;
    }

    public String getHistoria() {
        return historia;
    }

    public List<PeliculaSerie> getPeliculas() {
        return peliculas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Double edad) {
        this.edad = edad;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setPeliculas(List<PeliculaSerie> peliculas) {
        this.peliculas = peliculas;
    }
}