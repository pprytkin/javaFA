package com.prytkin.kr.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private Long dur;
    private Long release;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
    public void setDur(Long dur){
        this.dur = dur;
    }

    public Long getDur() {
        return dur;
    }
    public void setRelease(Long release){
        this.release = release;
    }

    public Long getRelease() {
        return release;
    }
    public void updateCities(Films films){
        if(films.name != null){
            this.name = films.name;
        }
        if(cities.genre != null){
            this.genre = films.genre;
        }
        if(films.dur != null){
            this.dur = films.dur;
        }
        if(films.release != null){
            this.release = films.release;
        }
    }
}