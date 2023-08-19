package com.chrisloarryn.demospringboot.interfaces;

import com.chrisloarryn.demospringboot.domain.model.Author;
import com.chrisloarryn.demospringboot.usecases.AuthorUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    private final AuthorUseCase authorUseCase;

    public AuthorController(AuthorUseCase authorUseCase) {
        this.authorUseCase = authorUseCase;
    }

    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable Long id) {
        // Llamar al caso de uso para obtener el autor por ID y mapearlo a AuthorDTO
        return null;
    }
}