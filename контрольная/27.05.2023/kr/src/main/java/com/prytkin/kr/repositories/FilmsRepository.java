package com.prytkin.kr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prytkin.kr.models.Films;

public interface FilmsRepository extends JpaRepository<Films, Long> {
}