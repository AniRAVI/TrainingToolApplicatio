package com.point;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/checkLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	request.getRequestDispatcher("header.jsp").include(request, response);
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		//String role = LoginDao.validate(email, password);
		List<String> role =new ArrayList<String>();
		if(email.equals(password)){
			role.add(0, "admin");
			//role.set(0, "admin");
			System.out.println("Username and Password match");
		}else {
		role = LoginDao.validateLogin(email, password);
		System.out.println("****USER ROLE******"+role);
		}
		System.out.println("ABC DEF");
		if(role.equals("NEW USER")){
			out.print("<p>Sorry, Your account has been approved but Role has not assign</p>");
			request.getRequestDispatcher("index.html").include(request, response);;
		}else if(role.get(0).equals("admin")){
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("name", "Abhishek Singh");
			request.getSession().setAttribute("userSubRole","AD");
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("userRole", role.get(0));
			response.sendRedirect("adminPage");
		}else if(role.get(0).equals("Team Manger")||role.get(0).equals("Team Lead")){
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("name", role.get(2));
			request.getSession().setAttribute("email", email);
			request.getSession().setAttribute("userRole", role.get(0));
			request.getSession().setAttribute("userSubRole",role.get(1));
			response.sendRedirect("NormalUsers");
		}else if(role.get(0).equals(null)){
			System.out.println("User and Password is not matched"+role.get(0));
		}else
		{
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	
	}
}
