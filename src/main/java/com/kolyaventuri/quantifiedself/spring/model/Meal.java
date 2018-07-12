package com.kolyaventuri.quantifiedself.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


@Entity
@Table(name = "meals")
public class Meal extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "meal_generator", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(
			name = "meal_generator",
			sequenceName = "meal_sequence"
	)
	
	@JsonInclude
	private Long id;
	
	@Column(name="name")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
