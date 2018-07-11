package com.kolyaventuri.quantifiedself.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kolyaventuri.quantifiedself.spring.model.Food;
import com.kolyaventuri.quantifiedself.spring.repository.FoodRepository;

@RestController
@RequestMapping("/api/v1/foods")
public class FoodsController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@RequestMapping("")
	public List<Food> index() {
		return foodRepository.findAll();
	}
}
