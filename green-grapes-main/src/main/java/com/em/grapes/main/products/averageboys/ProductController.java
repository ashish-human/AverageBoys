package com.em.grapes.main.products.averageboys;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.em.grapes.main.products.averageboys.Entity.CourseAuthor;
import com.em.grapes.main.products.averageboys.Entity.CourseChapter;
import com.em.grapes.main.products.averageboys.Entity.CourseChapterLecture;
import com.em.grapes.main.products.averageboys.Entity.CourseContent;
import com.em.grapes.main.products.averageboys.Entity.CourseEntity;
import com.em.grapes.main.products.averageboys.Entity.Review;
import com.em.grapes.main.security.db.UserEntity;
import com.em.grapes.main.utils.ConstantPaths;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ProductController {

	@GetMapping("products/averageboys")
	public String averageboys(@RequestParam(name = "logout", required = false, defaultValue = "true") boolean logout,
			Model model) {
		log.info("get / products/averageboys");
		model.addAttribute("listClasses", service());

		return ConstantPaths.average_boys_home;
	}
	
	record EnrollForm(CourseEntity enrolledCourse) {
		
	}
	
	@GetMapping("products/averageboys/{courseCode}")
	public String averageboysCoursePage(@RequestParam(name = "code", required = true, defaultValue = "jfs") Long courseid,
			Model model) {
		log.info("get / products/averageboys/{courseid}");
		
		
		var filter = service().stream().filter(e -> e.getId().equals(courseid));
		model.addAttribute("activeClass", filter.findFirst().get());

		return ConstantPaths.average_boys_deatils_page;
	}	

	private List<CourseEntity> service() {
		CourseAuthor author = new CourseAuthor("Grapes");
		
		List<CourseChapter> chapters = new ArrayList<>();
		List<CourseChapterLecture> lectures = new ArrayList<>();
		CourseChapterLecture lecture1 = new CourseChapterLecture("Get Java Install", "This lecture explains what programming is good for, even if you don't intend to become a software engineer. At the end of this lecture, you'll be able to download and install Java", Duration.ofSeconds(5000));
		CourseChapterLecture lecture2 = new CourseChapterLecture("Basic Terminology and Using IDE", "The student will learn how to put values and operators together to form expressions, the most basic instruction type in Java", Duration.ofSeconds(30000));
		CourseChapterLecture lecture3 = new CourseChapterLecture("Writing Our First Program", "Now that you've done some basic instructions in the interactive shell, let's use the file editor to write a complete program", Duration.ofSeconds(50000));
		lectures.add(lecture1);
		lectures.add(lecture2);
		lectures.add(lecture3);
		lectures.add(lecture2);		
		CourseChapter chapter1 = new CourseChapter("Java Basics", lectures);
		CourseChapter chapter2 = new CourseChapter("Flow Control", lectures);
		CourseChapter chapter3 = new CourseChapter("Functions", lectures);
		CourseChapter chapter4 = new CourseChapter("Handling Errors with try/catch", lectures);
		CourseChapter chapter5 = new CourseChapter("Writing a Complete Program: Guess the Number", lectures);
		chapters.add(chapter1);
		chapters.add(chapter2);
		chapters.add(chapter3);
		chapters.add(chapter4);
		chapters.add(chapter5);
		
		
		
		CourseContent content = new CourseContent(chapters);
		List<Review> reviews = new ArrayList<>();
		Review review1 = new Review("This is a very interacting and gives a lot of learning. Best for beginners.", "Ashish Kumar");
		Review review2 = new Review("This is a very interacting and gives a lot of learning. Best for beginners.", "Mukesh Kumar");
		reviews.add(review1);
		reviews.add(review2);
		CourseEntity e1 = new CourseEntity(1121l,"jfs", "Java Full Stack", "java full stack", "java full stack", "full stack", 3,5, author, content, reviews);
		CourseEntity e2 = new CourseEntity(1232l,"jfs-b","Java Full Stack Backed Heavy", "java full stack", "java full stack", "full stack",
				2,4, author, content, reviews);
		CourseEntity e3 = new CourseEntity(131313l,"jfs-f","Java Full Stack Frontend Heavy", "java full stack", "java full stack", "full stack",
				2,4,author, content, reviews);
		CourseEntity e4 = new CourseEntity(232313l,"j-sb","Java Springboot", "java full stack", "java full stack", "full stack",
				2,4,author, content, reviews);
		CourseEntity e5 = new CourseEntity(2341l,"j-sbmvc","Java Springboot MVC", "java full stack", "java full stack", "spring mvc",
				2,4,author, content, reviews);
		CourseEntity e6 = new CourseEntity(13423l,"j-sbm","Java Springboot Microservices", "java full stack", "java full stack", "Spring microservices",
				3,4,author, content, reviews);
		CourseEntity e7 = new CourseEntity(68656l,"dsa","Data structures & Algorithms", "java full stack", "java full stack", "DSA",
				0,4,author, content, reviews);
		CourseEntity e8 = new CourseEntity(98127l,"j-cc","Java Clean code", "java full stack", "java full stack", "Cleancode",
				1,4,author, content, reviews);
		CourseEntity e9 = new CourseEntity(45678l,"jb","Java basics", "java full stack", "java full stack", "full stack",
				0,4,author, content, reviews);
		CourseEntity e10 = new CourseEntity(36563l,"jsb","JavaScript basics", "java full stack", "java full stack", "full stack",
				0,4,author, content, reviews);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}

}