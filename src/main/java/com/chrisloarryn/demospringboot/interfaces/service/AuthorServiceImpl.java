package com.chrisloarryn.demospringboot.interfaces.service;

import com.chrisloarryn.demospringboot.domain.model.Author;
import com.chrisloarryn.demospringboot.domain.repository.AuthorRepository;
import com.chrisloarryn.demospringboot.usecases.AuthorUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorUseCase {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
}