package com.nt.initializer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

@Configuration
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};//will be used by super class onStartup(-) to get Configuration class name Parent container
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCAppConfig.class};//will be used by super class onStartup(-) to get Configuration class name child container
		
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"}; //will be used by super class onStartup(-) to get DS url pattern
	}

	
}//class
