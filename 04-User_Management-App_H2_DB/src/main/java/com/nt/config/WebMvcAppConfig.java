package com.nt.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class WebMvcAppConfig {

	@Bean("messageSource")
	public MessageSource createSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("com/nt/commons/validation");
		return messageSource;
	}
	
	
	@Bean
	public TilesConfigurer createTileConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		return configurer;
	}
	
	@Bean
	public TilesViewResolver createTVR() {
		return new TilesViewResolver();
	}
	
	
}//class
