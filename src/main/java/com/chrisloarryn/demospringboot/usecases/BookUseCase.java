package com.chrisloarryn.demospringboot.usecases;

import com.chrisloarryn.demospringboot.domain.model.Book;

public interface BookUseCase {
    Book getBookById(Long id);
    // Otros casos de uso relacionados con libros
}