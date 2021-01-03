package com.ac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.Model.Model;


public class Checkbalance extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		int bacno = Integer.parseInt((String)session.getAttribute("acno"));
		
		
		try {
			Model m = new Model();
			m.setAccno(bacno);
			
			boolean b = m.checkbalance();
			
			if(b==true) {
				Integer bal = new Integer(m.getBal());
				String balance = bal.toString();
				
				session.setAttribute("bal",balance);
				
				response.sendRedirect("BalanceView.jsp");
			}
			else {
				response.sendRedirect("BalanceFail.html");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	
       

}
