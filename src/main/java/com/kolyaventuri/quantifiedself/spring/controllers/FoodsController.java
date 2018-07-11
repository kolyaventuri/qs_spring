package com.kolyaventuri.quantifiedself.spring.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
}
