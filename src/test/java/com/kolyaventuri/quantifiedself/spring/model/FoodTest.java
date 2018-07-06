package com.kolyaventuri.quantifiedself.spring.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class FoodTest {
	private Food food;
	
	private final String  name = "Name";
	private final int calories = 30;
	
	@BeforeEach
	public void setup() {
		food = new Food(name, calories);
	}
	
	@Test
	public void FoodHasName_Test() {
		assertEquals(food.getName(), name);
	}
	
	@Test
	public void FoodHasCalories_Test() {
		assertEquals(food.getCalories(), name);
	}
}
