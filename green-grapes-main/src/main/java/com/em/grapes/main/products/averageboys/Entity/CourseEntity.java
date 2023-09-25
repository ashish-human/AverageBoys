package com.em.grapes.main.products.averageboys.Entity;

import java.util.List;

import lombok.Value;

@Value
public class CourseEntity {
	
	Long id;
	String courseCode;
	String title;
	String shortDescription;
	String description;
	String category;
	Integer levelInYears;
	Integer durationInMonths;
	CourseAuthor author;
	CourseContent courseContent;
//	Date startDate;
	List<Review> reviews;
//	String CourseStatus;
	
}
