package com.ac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.Model.Model;


public class Loan extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =	request.getSession();
			int bacno = Integer.parseInt((String)session.getAttribute("acno"));
			
			try {
				Model m = new Model();
				m.setAccno(bacno);
			boolean b=	m.applyLoan();
			if(b==true) {
				session.setAttribute("name", m.getName());
				session.setAttribute("email", m.getEmail());
				response.sendRedirect("Loansuccess.jsp");
			}
			else {
				response.sendRedirect("LoanFailure.html");
			}
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			
	}

}
