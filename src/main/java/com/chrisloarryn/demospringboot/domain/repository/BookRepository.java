package com.chrisloarryn.demospringboot.domain.repository;

import com.chrisloarryn.demospringboot.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Métodos de consulta adicional si es necesario
}