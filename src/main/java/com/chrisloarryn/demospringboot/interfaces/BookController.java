package com.chrisloarryn.demospringboot.interfaces;

import com.chrisloarryn.demospringboot.domain.model.Book;
import com.chrisloarryn.demospringboot.usecases.BookUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookUseCase bookUseCase;

    public BookController(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        // Llamar al caso de uso para obtener el libro por ID y mapearlo a BookDTO
        return null;
    }
}