package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}//main
	

	/*@Bean
	   public ResourceBundleMessageSource messageSource() {
	
	       var source = new ResourceBundleMessageSource();
	       source.setBasenames("messages/label");
	       source.setUseCodeAsDefaultMessage(true);
	
	       return source;
	   }*/

}//class
