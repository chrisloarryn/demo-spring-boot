package com.chrisloarryn.demospringboot.interfaces.persistence.jpa;

import com.chrisloarryn.demospringboot.domain.model.Book;
import com.chrisloarryn.demospringboot.domain.repository.BookRepository;
import org.springframework.data.jpa.repository.*;

public interface JpaBookRepository extends JpaRepository<Book, Long> {
    // Métodos de consulta adicionales si es necesario
}