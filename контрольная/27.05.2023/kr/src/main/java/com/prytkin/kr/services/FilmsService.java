package com.prytkin.kr.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prytkin.kr.models.Films;
import com.prytkin.kr.repositories.FilmsRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class FilmsService {
    @Autowired
    private FilmsRepository filmsRepository;


    public List<Films> getAllFilms(){
        return filmsRepository.findAll();
    }

    public Films getFilmsById(Long id){
        return filmsRepository.findById(id).get();
    }

    public void saveFilms(Films films){
        filmsRepository.save(films);
    }

    public void deleteFilms(Long id){
        citiesRepository.deleteById(id);
    }
}