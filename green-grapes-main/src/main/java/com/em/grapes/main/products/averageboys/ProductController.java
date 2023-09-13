package com.em.grapes.main.products.averageboys;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.em.grapes.main.products.averageboys.Entity.CourseEntity;
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
	
	

	private List<CourseEntity> service() {
		CourseEntity e1 = new CourseEntity("Java Full Stack", "java full stack", "java full stack", "full stack",
				3,5);
		CourseEntity e2 = new CourseEntity("Java Full Stack Backed Heavy", "java full stack", "java full stack", "full stack",
				2,4);
		CourseEntity e3 = new CourseEntity("Java Full Stack Frontend Heavy", "java full stack", "java full stack", "full stack",
				2,4);
		CourseEntity e4 = new CourseEntity("Java Springboot", "java full stack", "java full stack", "full stack",
				2,4);
		CourseEntity e5 = new CourseEntity("Java Springboot MVC", "java full stack", "java full stack", "spring mvc",
				2,4);
		CourseEntity e6 = new CourseEntity("Java Springboot Microservices", "java full stack", "java full stack", "Spring microservices",
				3,4);
		CourseEntity e7 = new CourseEntity("Data structures & Algorithms", "java full stack", "java full stack", "DSA",
				0,4);
		CourseEntity e8 = new CourseEntity("Java Clean code", "java full stack", "java full stack", "Cleancode",
				1,4);
		CourseEntity e9 = new CourseEntity("Java basics", "java full stack", "java full stack", "full stack",
				0,4);
		CourseEntity e10 = new CourseEntity("JavaScript basics", "java full stack", "java full stack", "full stack",
				0,4);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}

}