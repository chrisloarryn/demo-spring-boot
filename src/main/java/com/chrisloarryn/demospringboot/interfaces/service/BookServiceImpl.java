package com.chrisloarryn.demospringboot.interfaces.service;

import com.chrisloarryn.demospringboot.domain.model.Book;
import com.chrisloarryn.demospringboot.domain.repository.BookRepository;
import com.chrisloarryn.demospringboot.usecases.BookUseCase;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookUseCase {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}