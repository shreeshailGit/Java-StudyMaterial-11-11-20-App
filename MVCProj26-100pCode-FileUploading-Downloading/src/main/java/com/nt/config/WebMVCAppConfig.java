package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCAppConfig {

	@Bean
	public CommonsMultipartResolver createCMR() {
		CommonsMultipartResolver commonMultipartResolver = new CommonsMultipartResolver();
	           commonMultipartResolver.setMaxUploadSize(-1);
		return commonMultipartResolver;
	}
	
	@Bean
	public ViewResolver createVR() {
	InternalResourceViewResolver irvr = new InternalResourceViewResolver();
	    irvr.setPrefix("/WEB-INF/pages/");
	    irvr.setSuffix(".jsp");
	    return irvr;
		
	}
}
