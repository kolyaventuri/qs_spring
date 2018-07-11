package com.kolyaventuri.quantifiedself.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4307755261951326293L;

	@Id
	@GeneratedValue(generator = "food_generator", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "food_generator",
            sequenceName = "food_sequence"
    )
    private Long id;
	
    @Column(name="name")
	private String name;
	
	@Column(name="calories")
	private int calories;
	
	public Food(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}
	
	public Food() { }
	
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
