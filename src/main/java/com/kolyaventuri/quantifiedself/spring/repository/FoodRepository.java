package com.kolyaventuri.quantifiedself.spring.repository;

import com.kolyaventuri.quantifiedself.spring.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
