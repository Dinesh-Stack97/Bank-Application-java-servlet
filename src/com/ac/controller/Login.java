package com.ac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.Model.Model;


public class Login extends HttpServlet {
	private HttpSession session;
	
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid =	request.getParameter("custid");
		
		String pwd =	request.getParameter("pwd");
		
		
	HttpSession	session =request.getSession(true);
		
		try {
			Model m = new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b =m.login();
			
			if(b==true) {
				
				Integer accno = new Integer(m.getAccno());
				String bacno = accno.toString();
				
				session.setAttribute("acno", bacno);
				response.sendRedirect("Home.html");
			}
			else {
				response.sendRedirect("Error.html");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
