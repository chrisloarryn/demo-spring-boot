package com.chrisloarryn.demospringboot.usecases;


import com.chrisloarryn.demospringboot.domain.model.Author;

import java.util.Optional;

public interface AuthorUseCase {
    Optional<Author> getAuthorById(Long id);
    // Otros casos de uso relacionados con autores
}