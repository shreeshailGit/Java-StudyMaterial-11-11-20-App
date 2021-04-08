package com.nt.interceptors;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class BrowserCheckingInteceptors implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		PrintWriter pw =null;
		pw=res.getWriter();		
		res.setContentType("html/text");
		
		String browser = null;
		RequestDispatcher rd =null;
		
		
		browser = req.getHeader("user-agent");
		if(browser.indexOf("Chrome")==-1) {
		//	pw.println(" <h1 style='color:red;text-align:center'>Use Chrome browser to visit this website</h1>");
			rd = req.getRequestDispatcher("browser.jsp"); 
			rd.forward(req, res);
			return false;
		}else
			return true;
		
	}
	
}//class
