package com.kolyaventuri.quantifiedself.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kolyaventuri.quantifiedself.spring.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}
