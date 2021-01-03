package com.ac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.Model.Model;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pwd  =	request.getParameter("npwd");
	HttpSession session = request.getSession();
	
	int bacno = Integer.parseInt((String)session.getAttribute("acno"));
	
	try {
		Model m = new Model();
		m.setAccno(bacno);
		m.setPwd(pwd);
	boolean b =	m.changePwd();
	if(b== true) {
		response.sendRedirect("ChangepwdSuccess.html");
	}
	else {
		response.sendRedirect("ChangepwdFail.html");
	}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}

	}

}
