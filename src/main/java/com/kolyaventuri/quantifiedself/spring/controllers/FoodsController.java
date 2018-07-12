package com.kolyaventuri.quantifiedself.spring.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Food create(@RequestBody Map<String, Object> payload) {
		Map<String, Object> foodObject = (Map<String, Object>) payload.get("food");
		
		String name = (String) foodObject.get("name");
		int calories = (int) foodObject.get("calories");
				
		Food food = new Food(name, calories);
		foodRepository.save(food);
		
		return food;
	}
	
	@RequestMapping("/{id}")
	public Optional<Food> show(@PathVariable long id) {
		return foodRepository.findById(id);
	}
	
	@RequestMapping(value="/{id}", method={RequestMethod.PATCH, RequestMethod.PUT})
	public Food update(@PathVariable long id, @RequestBody Map<String, Object> payload, HttpServletResponse response) throws IOException {
		Optional<Food> foundFood = foodRepository.findById(id);

		if(!foundFood.isPresent()) response.sendError(400);
		
		Food food = (Food) foundFood.get();
		Map<String, Object> foodObject = (Map<String, Object>) payload.get("food");
		
		String name = (String) foodObject.get("name");
		Integer calories = (Integer) foodObject.get("calories");
		
		if(name != null) {
			food.setName(name);
		}
		
		if(calories != null) {
			food.setCalories((int) calories);
		}
		
		foodRepository.save(food);
		
		return food;
	}
}
