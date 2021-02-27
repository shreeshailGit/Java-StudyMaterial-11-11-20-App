package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cgsturl")
public class ITCentralGSTServlet extends HttpServlet {

	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ptype=null;
		float cost=0.0f;
		float cgst=0.0f;
		//getwriter
		pw=res.getWriter();
		res.setContentType("text/html");
		//read i/p
		ptype=req.getParameter("ptype");
		cost=Float.parseFloat(req.getParameter("cost"));
		
		//b.logic
		if(ptype.equalsIgnoreCase("product")) {
			cgst=cost*0.18f;
		}
		else if (ptype.equalsIgnoreCase("service")) {
			cgst=cost*0.15f;
		}
		else if (ptype.equals("startup")) {
			cgst=cost*0.1f;
		}
		
		pw.println("<br><b><i>Central GST::"+cgst+"<i><b>");
	}//doGet
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req,res);
	}


	

}
