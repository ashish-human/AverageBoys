package com.em.grapes.main.products.averageboys.Entity;

import java.util.List;

import lombok.Value;

@Value
public class CourseChapter {
	
	String title;
	List<CourseChapterLecture>  lectures;
	
	
	

}
