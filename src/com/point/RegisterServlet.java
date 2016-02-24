package com.point;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		/*String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		System.out.println("*******"+dob+"*********");
		String addressLine=request.getParameter("addressLine");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String userRole=request.getParameter("userRole");
		Double contact= Double.parseDouble(request.getParameter("contact"));
		System.out.println("Contact "+userRole);
		 *///int status=RegisterDao.save(name, email, password, gender, dob, addressLine, city, state, userRole, contact);
		int status = RegisterDao.register(name, email, password);
		if(status>0){
			String sub ="USER REGISTRATION IN ATT TUTORIAL TOOL";
			String data = "<font color = 'green' size = '5' > THANK YOU"+name +" FOR REIGISTERING IN ATT TRAINING TOOL.  </font>";
			MailService.sendMail(email, sub, data);
			request.getRequestDispatcher("index.html").include(request, response);
			out.print("<p>You are successfully registered!</p>");
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
