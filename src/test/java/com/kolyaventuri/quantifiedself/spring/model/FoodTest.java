package com.kolyaventuri.quantifiedself.spring.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FoodTest {
	private Food food;
	
	private final String  name = "Name";
	private final int calories = 30;
	
	@Before
	public void setup() {
		food = new Food(name, calories);
	}
	
	@Test
	public void FoodHasName_Test() {
		assertEquals(name, food.getName());
	}
	
	@Test
	public void FoodHasCalories_Test() {
		assertEquals(calories, food.getCalories());
	}
	
	@Test
	public void CanSetFoodName_Test() {
		String newName = "New Name";
		
		food.setName(newName);
		
		assertEquals(newName, food.getName());
	}
	
	@Test
	public void CanSetFoodCalories_Test() {
		int newCalories = 50;
		
		food.setCalories(newCalories);
		
		assertEquals(newCalories, food.getName());
	}
}
