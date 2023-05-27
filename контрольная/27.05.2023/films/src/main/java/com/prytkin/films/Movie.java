package com.prytkin.films;

public class Movie {

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
}
