package com.chrisloarryn.demospringboot.interfaces;

import com.chrisloarryn.demospringboot.domain.model.Store;
import com.chrisloarryn.demospringboot.usecases.StoreUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    private final StoreUseCase storeUseCase;

    public StoreController(StoreUseCase storeUseCase) {
        this.storeUseCase = storeUseCase;
    }

    @GetMapping("/stores/{id}")
    public Store getStore(@PathVariable Long id) {
        // Llamar al caso de uso para obtener la tienda por ID y mapearla a StoreDTO
        return null;
    }
}