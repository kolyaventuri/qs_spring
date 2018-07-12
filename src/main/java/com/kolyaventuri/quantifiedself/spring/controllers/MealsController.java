package com.kolyaventuri.quantifiedself.spring.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kolyaventuri.quantifiedself.spring.model.Food;
import com.kolyaventuri.quantifiedself.spring.model.Meal;
import com.kolyaventuri.quantifiedself.spring.repository.FoodRepository;
import com.kolyaventuri.quantifiedself.spring.repository.MealRepository;

@RestController
@RequestMapping("/api/v1/meals")
public class MealsController {

	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private FoodRepository foodRepository;
	
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
	
	@RequestMapping(value="/{meal_id}/foods/{id}", method=RequestMethod.POST)
	public HashMap<String, String> create(@PathVariable long meal_id, @PathVariable long id, HttpServletResponse response) throws IOException {
		Optional<Meal> foundMeal = mealRepository.findById(meal_id);
		Optional<Food> foundFood = foodRepository.findById(id);
		
		if(!foundMeal.isPresent() || !foundFood.isPresent()) {
			response.sendError(404);
			return null;
		}
		
		Meal meal = (Meal) foundMeal.get();
		Food food = (Food) foundFood.get();
		
		meal.addFood(food);
		
		mealRepository.save(meal);
		
		HashMap<String, String> message = new HashMap<String, String>();
		message.put("message", "Successfully added " + food.getName() + " to " + meal.getName());
		
		return message;
	}
	
	@RequestMapping(value="/{meal_id}/foods/{id}", method=RequestMethod.DELETE)
	public HashMap<String, String> destroy(@PathVariable long meal_id, @PathVariable long id, HttpServletResponse response) throws IOException {
		Optional<Meal> foundMeal = mealRepository.findById(meal_id);
		Optional<Food> foundFood = foodRepository.findById(id);
		
		if(!foundMeal.isPresent() || !foundFood.isPresent()) {
			response.sendError(404);
			return null;
		}
		
		Meal meal = (Meal) foundMeal.get();
		Food food = (Food) foundFood.get();
		
		meal.removeFood(food);
		
		mealRepository.save(meal);
		
		HashMap<String, String> message = new HashMap<String, String>();
		message.put("message", "Successfully removed " + food.getName() + " from " + meal.getName());
		
		return message;
	}
}
