package com.point;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class LoginDao {

	public static String validate(String email,String password){
	//	boolean status=false;
		String userRole = "false" ;
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from company_mailer_user where email=? and password=? and authorized=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ps.setString(3,"yes");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				userRole = rs.getString("USER_ROLE");
			}
		}catch(Exception e){System.out.println(e);}
		
		return userRole;
	}
	
	public static List<String> validateLogin(String email,String password){
	//	boolean status=false;
		System.out.println("Email : "+email+" Password "+password);
		List<String> userRole  = new ArrayList<String>() ;
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from training_tool_users where email=? and password=? and authorized=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ps.setString(3,"ACTIVE");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				//userRole = rs.getString("USER_ROLE") ;
				userRole.add(rs.getString("USER_ROLE"));
				userRole.add(rs.getString("USER_SUB_ROLE"));
				userRole.add(rs.getString("NAME"));

			}
		}catch(Exception e){System.out.println(e);}
		System.out.println("USER DETAILS FROM LOGIN DAO"+userRole);
		return userRole;
	}
	public static void main (String args[]){
		LoginDao.validateLogin("as714d","welcome");
	}
}
