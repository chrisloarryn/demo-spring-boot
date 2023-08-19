package com.chrisloarryn.demospringboot.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Store> stores;

    // Otros atributos, constructor, getters y setters
}