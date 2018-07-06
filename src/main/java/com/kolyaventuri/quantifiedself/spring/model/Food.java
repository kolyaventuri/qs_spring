package com.kolyaventuri.quantifiedself.spring.model;

public class Food extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4307755261951326293L;

	private String name;
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCalories(int calories) {
		this.calories = calories;
	}
}
