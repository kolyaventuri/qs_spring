package com.kolyaventuri.quantifiedself.spring.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/{id}")
	public Meal show(@PathVariable long id, HttpServletResponse response) throws IOException {
		Optional<Meal> foundMeal = mealRepository.findById(id);
		
		if(!foundMeal.isPresent()) {
			response.sendError(404);
			return null;
		}
		
		Meal meal = foundMeal.get();
		
		return meal;
	}
}
