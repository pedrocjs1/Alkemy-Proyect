package com.challenge.backend.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private String image;

    private String nombre;

    private Integer edad;

    private Integer peso;

    private String historia;

    @ManyToMany(mappedBy="personaje", fetch = FetchType.EAGER)
    private List<PeliculaSerie> peliculas = new ArrayList<>();

    public Personaje(){}

    public Personaje(Long id, String image, String nombre, Integer edad, Integer peso, String historia, List<PeliculaSerie> peliculas) {
        this.id = id;
        this.image = image;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculas = peliculas;
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

    public Integer getEdad() {
        return edad;
    }

    public Integer getPeso() {
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

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setPeliculas(List<PeliculaSerie> peliculas) {
        this.peliculas = peliculas;
    }
}
