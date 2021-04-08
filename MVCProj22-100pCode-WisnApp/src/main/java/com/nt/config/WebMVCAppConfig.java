package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nt.controller")
public class WebMVCAppConfig {
	
	//configuration of IRVR
	@Bean
	public ViewResolver createIRVR() {
		InternalResourceViewResolver irvr =
		           new InternalResourceViewResolver();
	     irvr.setPrefix("/WEB-INF/pages/");	
	     irvr.setSuffix(".jsp");
        return irvr;
	} 

}
