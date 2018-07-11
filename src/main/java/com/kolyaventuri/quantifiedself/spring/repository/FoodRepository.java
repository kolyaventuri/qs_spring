package com.kolyaventuri.quantifiedself.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.kolyaventuri.quantifiedself.spring.model.Food;

@RepositoryRestResource
public interface FoodRepository extends CrudRepository<Food, Long> {
}
