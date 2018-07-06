package com.kolyaventuri.quantifiedself.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4307755261951326293L;

	@Id
	
    @Column(columnDefinition = "name")
	private String name;
	
	@Column(columnDefinition = "calories")
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
