package com.chrisloarryn.demospringboot.interfaces.persistence.jpa;

import com.chrisloarryn.demospringboot.domain.model.Author;
import com.chrisloarryn.demospringboot.domain.repository.AuthorRepository;
import org.springframework.data.jpa.repository.*;

public interface JpaAuthorRepository extends JpaRepository<Author, Long> {
    // Métodos de consulta adicionales si es necesario
}