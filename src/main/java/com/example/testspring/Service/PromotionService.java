package com.example.testspring.Service;

import com.example.testspring.model.Promotion;
import com.example.testspring.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PromotionService implements IPromotionService {
    @Autowired
    private PromotionRepo promotionRepo;
    @Override
    public Iterable<Promotion> findAll() {
        return promotionRepo.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return promotionRepo.findById(id);
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepo.save(promotion);

    }
    @Override
    public void remove(Long id) {
        promotionRepo.deleteById(id);

    }
}
