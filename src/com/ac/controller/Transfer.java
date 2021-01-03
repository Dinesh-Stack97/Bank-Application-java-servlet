package com.ac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.Model.Model;


public class Transfer extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session =	request.getSession();
	
	int bacno = Integer.parseInt((String)session.getAttribute("acno"));
	String samt = request.getParameter("amt");
	
	int amt = Integer.parseInt(samt);
	
    String sraccno = request.getParameter("raccno");
	
	 int raccno = Integer.parseInt(sraccno);
	
	try {
		Model m = new Model();
		m.setAccno(bacno);
		m.setRaccno(raccno);
		m.setBal(amt);
		boolean b = m.transfer();
		if(b==true) {
			response.sendRedirect("TransferSuccess.html");
		}
		else {
			response.sendRedirect("TransferFail.html");
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	
	}

}
}