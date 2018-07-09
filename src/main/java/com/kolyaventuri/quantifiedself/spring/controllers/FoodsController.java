package com.kolyaventuri.quantifiedself.spring.controllers;

import com.kolyaventuri.quantifiedself.spring.repository.FoodRepository;

import com.kolyaventuri.quantifiedself.spring.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public class FoodsController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@GetMapping("/api/v1/foods")
	public Page<Food> getQuestions(Pageable pageable) {
	    return foodRepository.findAll(pageable);
	}
	
}
