package com.example.testspring.Service;

import com.example.testspring.model.Promotion;

import java.util.Optional;

public interface IPromotionService {
    Iterable<Promotion> findAll();

    Optional<Promotion> findById(Long id);

    void save(Promotion promotion);

    void remove(Long id);
}
