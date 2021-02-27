package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
	    String ss = null;
		//get Writer
		pw = res.getWriter();
		res.setContentType("text/html");
		//read form data
		ss = req.getParameter("ss");
		  //generate web page having hyperlink
		  pw.println("<br><br><br>");
		pw.println("<h1 style='color:red;text-align:center'><a href='https://www.google.com/search?q="+ss+"'>go to Google</a></h1>");
	  //close stream
        pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}//class
