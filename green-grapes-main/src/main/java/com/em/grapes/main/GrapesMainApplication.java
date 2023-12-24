package com.em.grapes.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
//(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
//        )
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

public class GrapesMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrapesMainApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void configurePathMatch(PathMatchConfigurer configurer) {
	            UrlPathHelper urlPathHelper = new UrlPathHelper();
	            urlPathHelper.setRemoveSemicolonContent(false); // Keep matrix variables
//	            urlPathHelper.setRemoveTrailingSlash(false);    // Keep trailing slashes
	            configurer.setUrlPathHelper(urlPathHelper);
	        }
	    };
	}

}
