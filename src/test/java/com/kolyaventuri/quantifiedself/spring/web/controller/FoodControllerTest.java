package com.kolyaventuri.quantifiedself.spring.web.controller;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Array;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kolyaventuri.quantifiedself.spring.controllers.FoodsController;
import com.kolyaventuri.quantifiedself.spring.model.Food;
import com.kolyaventuri.quantifiedself.spring.repository.FoodRepository;

public class FoodControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new FoodsController()).build();
	}
	
	@Test 
	public void CanListFoods_Test() throws Exception {
		Food food = new Food("Food", 30);
		foodRepository.save(food);
		
		this.mockMvc.perform(get("/api/v1/foods"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", instanceOf(Array.class)));
	}
}
