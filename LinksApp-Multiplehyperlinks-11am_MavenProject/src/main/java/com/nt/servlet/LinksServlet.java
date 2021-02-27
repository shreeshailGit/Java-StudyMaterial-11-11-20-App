package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String pval = null;
		Locale locales[] = null;
		//get writer obj
		pw = res.getWriter();
		//set Contet type
		res.setContentType("text/html");
		//read addtional req param value (s1)
		pval = req.getParameter("s1");
		//get All available locales
		locales = Locale.getAvailableLocales();
		
		if(pval.equalsIgnoreCase("link1")) { //for languages
			pw.println("<h2>All Languages</h2>");
			for(Locale l : locales) {
				pw.print("<b>"+l.getDisplayLanguage()+"</b><br>");
			}
		}else if(pval.equalsIgnoreCase("link2")) { //for countries
			pw.println("<h2>All Conutries</h2>");
			for(Locale l: locales) {
				pw.print("<b>"+l.getDisplayCountry()+", </b>");
			}
		}else if(pval.equalsIgnoreCase("link3")) {
			pw.println("<h1>System Properties are</h1>");
			pw.print("<br>"+System.getProperties());
		}
				
		//add hyperlinks
		pw.println("<a href='links.html'><img src='images/home.png' width='50' height='50'></a>");
	    //close strem
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LinksServlet.doPost(-,-)");
		doGet(req, res);
	}//doPost(-,-)
	
}//class
