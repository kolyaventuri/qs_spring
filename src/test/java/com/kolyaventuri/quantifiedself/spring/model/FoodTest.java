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
}
