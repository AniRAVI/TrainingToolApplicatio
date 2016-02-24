package com.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.assesment.dom.AssesmentDao;
import com.course.PictureCount;
import com.course.dao.CourseDao;
import com.course.dao.ResultRecordDao;
import com.course.dao.ResultRecordDo;
import com.course.dao.UsersDao;
import com.course.model.CourseSecond;
import com.course.model.Users;

public class AssesmentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/user.jsp";
    private static String STATUS_OF_ASSESEMNTS = "/StatusOfAssesment.jsp";
    private static String PASS_COURSE = "/indexToPass.jsp";
    //private static String Play_Video = "/video.jsp";
    private static String Play_Video = "/VideoBack.jsp";

    private static String LIST_OF_ASSESMENTS = "/assesmentsDetails.jsp";
    private static String LAUNCH_COURSE = "/launchCourse.jsp";
    private static String LAUNCH_COURSE_NORMAL_USER = "/launchCourseNormalUser.jsp";
    private static String HOME_PAGE ="/WEB-INF/jsps/home.jsp";
    private AssesmentDao dao;

    public AssesmentController() {
        super();
        dao = new AssesmentDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        HttpSession session = request.getSession(true);
        String userRole = session.getAttribute("userRole").toString();
        String action = request.getParameter("action");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(action);
        if (action.equalsIgnoreCase("delete")&&userRole.equals("admin")){
            int cid = Integer.parseInt(request.getParameter("cid"));
           // dao.deleteCourse(cid);
            forward = LIST_OF_ASSESMENTS;
            try {
				request.setAttribute("assesments", dao.getAllAssesments());
			} catch (SQLException e) {
				System.err.println("Get All Assesments");
			} 
        } else if (action.equalsIgnoreCase("edit")&&userRole.equals("admin")){
            forward = STATUS_OF_ASSESEMNTS;
        } else if (action.equalsIgnoreCase("listOfAssesments")&&(userRole.equals("admin"))){
            forward = LIST_OF_ASSESMENTS;
            try {
				request.setAttribute("assesments", dao.getAllAssesments());
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }else if (action.equalsIgnoreCase("launchCourse")&&(userRole.equals("admin"))){
            forward = LAUNCH_COURSE;
        }else if (action.equalsIgnoreCase("launchCourse")&&(userRole.equals("Test Manager")||userRole.equals("Test Analyst")||userRole.equals("Team Lead"))){
            forward = LAUNCH_COURSE_NORMAL_USER;
        }else if (action.equalsIgnoreCase("launch")){
            String cid = request.getParameter("cid");
            String email = (String) session.getAttribute("email");
            try {
				int status = PictureCount.updatePictureCount(cid,email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            session.setAttribute("cid",cid);  
            forward = PASS_COURSE+"?ver="+cid;
        }else if (action.equalsIgnoreCase("launchVideo")){
            String fileName = request.getParameter("fileName");
            System.out.println("**********"+action);
            forward = Play_Video;
            session.setAttribute("videoFile",fileName);  
        }else if (action.equalsIgnoreCase("statusOfResult")){
        //		HttpSession session = request.getSession(true);
        		String userSubRole = session.getAttribute("userSubRole").toString();
        		String userId = session.getAttribute("email").toString();
        		request.setAttribute("manCourse", ResultRecordDao.manCourse(userRole, userSubRole));
        		request.setAttribute("aviCourse", ResultRecordDao.aviCourse(userRole, userSubRole));
        		//request.setAttribute("mandCourse", "");
  				request.setAttribute("statusOfResult", ResultRecordDao.statusOfParticularRole(userId));
  				forward = STATUS_OF_ASSESEMNTS;
        } else if (action.equalsIgnoreCase("home")){
        	System.out.println("HOME >>>>>>>>");
              forward = HOME_PAGE;
          }     else {
          //  String userId = session.getAttribute("email").toString();
			//request.setAttribute("statusOfResult", ResultRecordDao.statusOfParticularRole(userId));
            forward = STATUS_OF_ASSESEMNTS;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    
}
