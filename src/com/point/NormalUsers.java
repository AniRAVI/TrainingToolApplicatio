package com.point;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assesment.dom.AvilCourseDo;
import com.assesment.dom.ManCourseDo;
import com.course.dao.CourseDao;
import com.course.dao.ResultRecordDao;
import com.course.model.CourseSecond;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/NormalUsers")
public class NormalUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {/*
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("link.jsp").include(request, response);
		request.getRequestDispatcher("rightMenuNormalUsers.jsp").include(request, response);

		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
		//	String email=(String)session.getAttribute("email");
			//out.print("<span style='float:right'>Hi, "+email+"</span>");
		//	out.print("<h1 style='margin-top:-8px;'>Inbox</h1>");
			
		//	String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				out.print("<p>"+msg+"</p>");
			}
			
			try{
				Connection con=ConProvider.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from company_mailer_message where receiver=? and trash='no' order by id desc");
			//	ps.setString(1,email);
			//	ResultSet rs=ps.executeQuery();
				out.print("<table border='1' style='width:500px;margin-top:-20px;'>");
				out.print("<tr style='background-color:grey;color:white'><td>Sender</td><td>Subject</td></tr>");
				//while(rs.next()){
				//out.print("<tr><td>"+rs.getString("sender")+"</td><td><a href='ViewMailServlet?id="+rs.getString(1)+"'>"+rs.getString("subject")+"</a></td></tr>");
				}
			//	out.print("</table>");
				
			//	con.close();
			}catch(Exception e){out.print(e);}
		}
		
		
		
	request.getRequestDispatcher("footer.html").include(request, response);
	//	out.close();
	*/
		HttpSession session = request.getSession(true);
		String userRole = session.getAttribute("userRole").toString();
		String userSubRole = session.getAttribute("userSubRole").toString();
	//	CourseDao dao = new CourseDao();
		List<ManCourseDo> courseMan = new ArrayList<ManCourseDo>();
		List<AvilCourseDo> courseAvi = new ArrayList<AvilCourseDo>();
		courseMan=ResultRecordDao.manCourse(userRole, userSubRole);
		courseAvi=ResultRecordDao.aviCourse(userRole, userSubRole);
		//course = dao.getAllCorsesforNormalUser(userRole, userSubRole);
		//System.out.println("********"+course.size());
		session.setAttribute("courseMan", courseMan.size());
		session.setAttribute("courseAvi", courseAvi.size());

		request.setAttribute("manCourse", ResultRecordDao.manCourse(userRole, userSubRole));
		request.setAttribute("aviCourse", ResultRecordDao.aviCourse(userRole, userSubRole));
		String email = session.getAttribute("email").toString();
		CourseDao courseDao = new CourseDao();
		System.out.println("*************"+email+"****************");
		String countStatus =  courseDao.countStatus(email);
		session.setAttribute("countStatus",countStatus );
	//	request.setAttribute("courses", dao.getAllCorsesforNormalUser(userRole,userSubRole));		
		request.getRequestDispatcher("/WEB-INF/jsps/home.jsp").include(request, response);;

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
