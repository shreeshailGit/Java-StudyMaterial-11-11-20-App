package com.nt.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};//used by super class to get Configuration of parent container
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCAppConfig.class} ;//used by super class to get Configuration of child container
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};
		//return new String[] {"*.htm"};
	}

}
