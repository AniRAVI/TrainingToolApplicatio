package com.course.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.course.dao.ResultRecordDao;
import com.course.dao.ResultRecordDo;
import com.course.dao.UsersDao;
import com.course.model.Users;


public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static String INSERT_OR_EDIT = "/user.jsp";
    private static String EDIT_USERS = "/editProfile.jsp";
    private static String ManageUsersRecords = "/editManagableUsersRecord.jsp";
  //  private static String LIST_USERS = "/userDetails.jsp";
    private static String LIST_USERS = "/manageUserRecord.jsp";
    private static String DELETE_USERS ="/deleteUserDetails.jsp";
    private static String MANAGE_USERS_RECORD ="/manageUserRecord.jsp";
    private static String RESULT_DETAILS ="/resultStatus.jsp";

    private UsersDao dao;
    public UserController() {
        super();
        dao = new UsersDao();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equalsIgnoreCase("deleteUser")){
            int userId = Integer.parseInt(request.getParameter("userId"));
            dao.deleteUser(userId);
            forward = DELETE_USERS;
            request.setAttribute("users", dao.getAllUsers()); 
        } else if (action.equalsIgnoreCase("editUser")){
            forward = EDIT_USERS;
            int userId = Integer.parseInt(request.getParameter("userId"));
            System.out.println("User Id from Edit Users Block"+userId);
            Users user = dao.getByUsersId(userId);
            request.setAttribute("user", user);//manageUsersRecords
        }  else if (action.equalsIgnoreCase("manageUsersRecords")){
            forward = ManageUsersRecords;
            int userId = Integer.parseInt(request.getParameter("userId"));
            System.out.println("User Id from Edit Users Block"+userId);
           // Users user = dao.getByUsersId(userId);
            Users user = dao.getByUserId(userId);
            request.setAttribute("user", user);//manageUsersRecords
        } else if (action.equalsIgnoreCase("listUser")){
        	System.out.println("LIST BLOCK");
            forward = LIST_USERS;
            request.setAttribute("users", dao.getAllUsers());
            System.out.println(dao.getAllUsers());
        } else if (action.equalsIgnoreCase("deleteUserRecord")){
            forward = DELETE_USERS;
            request.setAttribute("users", dao.getAllUsers());
            System.out.println(dao.getAllUsers());
        }else if (action.equalsIgnoreCase("manageUserRecord")){
            forward = MANAGE_USERS_RECORD;
            request.setAttribute("users", dao.getAllUserRecord());
            System.out.println(dao.getAllUsers());
        } else if (action.equalsIgnoreCase("resultStatus")){
            forward = RESULT_DETAILS;//
            request.setAttribute("resultStatus", ResultRecordDao.statusOfResult());
        }else if (action.equalsIgnoreCase("report")){
        	//TestJasperProject.generateReport(); 
        	//System.out.println("Generate Report");
        }else {
            forward = EDIT_USERS;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users users = new Users();
        String action = request.getParameter("action");
        int userId = Integer.parseInt(request.getParameter("userId"));
		users.setUserAction(action);
        if(action.equalsIgnoreCase("updateUsersRecords")){
    		users.setUsername(request.getParameter("name"));
    		users.setUserRole(request.getParameter("userRole"));
    		users.setUserSubRole(request.getParameter("userSubRole"));
    		users.setUserAccess(request.getParameter("userAccess"));
               if(userId != 0)
               {
            	   users.setUserid(userId);
                   //dao.checkUser(users);
                   dao.checkRegisterUsers(users);

               }
        }else if(action.equalsIgnoreCase("updateUsersProfile")){
        	users.setUsername(request.getParameter("name"));
    		users.setPassword(request.getParameter("password"));
    		users.setUserEmail(request.getParameter("email"));
    		users.setDob(request.getParameter("dob"));
    		System.out.println("FROM USER CONTROLLER"+request.getParameter("dob"));
    		users.setGender(request.getParameter("gender"));
    		users.setAddressLine(request.getParameter("addressLine"));
    		users.setCity(request.getParameter("city"));
    		users.setState(request.getParameter("state"));
    		users.setUserRole(request.getParameter("userRole"));
    		 if(userId != 0)
             {
          	     users.setUserid(userId);
                 dao.checkUser(users);
             }
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_USERS);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
}
