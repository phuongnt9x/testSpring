package com.example.testspring.repository;

import com.example.testspring.model.Promotion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepo extends CrudRepository<Promotion,Long> {
}
