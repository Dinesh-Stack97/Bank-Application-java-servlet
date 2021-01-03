<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan success</title>
</head>
<body>
<%
session = request.getSession();
out.println("Dear, "+session.getAttribute("name")+" thank you for showing your Interest on the loan from abcbank");
out.println("<br>");
		out.println("Our Executive will Contact you soon  on Your Email mentioned below:");
		out.println("<br>");
		out.println(session.getAttribute("email"));

%>
</body>
</html>