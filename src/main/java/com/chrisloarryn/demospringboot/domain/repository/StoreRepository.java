package com.chrisloarryn.demospringboot.domain.repository;

import com.chrisloarryn.demospringboot.domain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    // Métodos de consulta adicional si es necesario
}