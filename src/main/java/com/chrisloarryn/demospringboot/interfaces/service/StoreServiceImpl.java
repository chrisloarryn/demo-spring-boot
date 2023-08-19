package com.chrisloarryn.demospringboot.interfaces.service;
import com.chrisloarryn.demospringboot.domain.model.Store;
import com.chrisloarryn.demospringboot.domain.repository.StoreRepository;
import com.chrisloarryn.demospringboot.usecases.StoreUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreUseCase {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }
}