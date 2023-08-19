package com.chrisloarryn.demospringboot.domain.model;

import lombok.*;

import java.util.List;
import jakarta.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "store_book",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    // Otros atributos, constructor, getters y setters
}