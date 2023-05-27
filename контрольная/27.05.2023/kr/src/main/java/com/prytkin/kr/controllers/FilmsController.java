package com.prytkin.kr.controllers;

import com.prytkin.kr.models.Films;
import com.prytkin.kr.repositories.FilmsRepository;
import com.prytkin.kr.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmsController {

    @Autowired
    private FilmsService filmsService;

    @GetMapping("")
    public List<Films> getAllFilms() {
        return filmsService.getAllFilms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Films> getFilmsById(@PathVariable Long id) {
        try{
            Films films = filmsService.getFilmsById(id);
            return new ResponseEntity<Films>(films, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Films>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void addFilms(@RequestBody Films films){
        filmsService.saveFilms(films);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFilms(@RequestBody Films films, @PathVariable Long id){
        try{
            Films baseFilms = filmsService.getFilmsById(id);
            baseFilms.updateFilms(films);
            filmsService.saveFilms(baseFilms);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public void deleteFilms(@PathVariable Long id){
        filmsService.deleteFilms(id);
    }
}