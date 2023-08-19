package com.chrisloarryn.demospringboot.domain.repository;

import com.chrisloarryn.demospringboot.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Métodos de consulta adicional si es necesario
}