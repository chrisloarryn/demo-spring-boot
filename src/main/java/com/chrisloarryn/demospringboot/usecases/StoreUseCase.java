package com.chrisloarryn.demospringboot.usecases;

import com.chrisloarryn.demospringboot.domain.model.Store;

import java.util.Optional;

public interface StoreUseCase {
    Optional<Store> getStoreById(Long id);
    // Otros casos de uso relacionados con tiendas
}