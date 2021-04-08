package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

@Configuration
public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
	   //create parent container
		AnnotationConfigWebApplicationContext parentCtx =
				  new AnnotationConfigWebApplicationContext();
		//register with RootAppConfig class
		parentCtx.register(RootAppConfig.class);
		//create ContextLoaderListner obj having parent IOC container
		ContextLoaderListener listner = new ContextLoaderListener(parentCtx);
		//register ContextLoaderlistner object with servlet container
		sc.addListener(listner);
		
		//create childe container
		AnnotationConfigWebApplicationContext childCtx = new
				   AnnotationConfigWebApplicationContext();
		//register with WebMVCAppConfig class
		childCtx.register(WebMVCAppConfig.class);
		//create dispatcher servlet obj having child container
		DispatcherServlet dispatcher = new DispatcherServlet(childCtx);
		
		 ServletRegistration.Dynamic  registration =sc.addServlet("dispatcher", dispatcher);
		  registration.addMapping("/");
		  registration.setLoadOnStartup(2);
		
	}//method

}//class
