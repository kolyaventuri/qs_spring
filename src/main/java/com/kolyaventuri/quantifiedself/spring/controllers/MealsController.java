package com.kolyaventuri.quantifiedself.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kolyaventuri.quantifiedself.spring.model.Meal;
import com.kolyaventuri.quantifiedself.spring.repository.MealRepository;

@RestController
@RequestMapping("/api/v1/meals")
public class MealsController {

	@Autowired
	private MealRepository mealRepository;
	
	@RequestMapping("")
	public List<Meal> index() {
		return mealRepository.findAll();
	}
}
