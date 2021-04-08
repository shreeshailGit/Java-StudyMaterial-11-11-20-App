package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};//will be used superclass onStartup(-) method to get Configuration class name for parent IOC container
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebMVCAppConfig.class};//will be used superclass onStartup(-) method to get Configuration class name for child IOC container
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};
	}

}
