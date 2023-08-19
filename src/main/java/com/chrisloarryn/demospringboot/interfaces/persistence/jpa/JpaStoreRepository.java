package com.chrisloarryn.demospringboot.interfaces.persistence.jpa;

import com.chrisloarryn.demospringboot.domain.model.Store;
import com.chrisloarryn.demospringboot.domain.repository.StoreRepository;
import org.springframework.data.jpa.repository.*;
public interface JpaStoreRepository extends JpaRepository<Store, Long> {
    // Métodos de consulta adicionales si es necesario
}