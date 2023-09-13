package com.em.grapes.main.products.averageboys.Entity;

import lombok.Value;

@Value
public class CourseEntity {
	
	String title;
	String shortDescription;
	String description;
	String category;
	int levelInYears;
	int durationInMonths;

}
