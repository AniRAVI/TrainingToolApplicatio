package com.point;

import java.sql.*;
public class RegisterDao {

	public static int save(String name,String email,String password,String gender,String dob,String addressLine,String city,String state,String country,Double contact){
		int status=0;
		System.out.println("+++++++++++"+dob);
		try{
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into company_mailer_user(userid,name,email,password,gender,dob,addressLine,city,state,User_Role,contact,registereddate,authorized) values(Reg_Id.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,gender);
			ps.setString(5,dob);
			ps.setString(6,addressLine);
			ps.setString(7,city);
			ps.setString(8,state);
			ps.setString(9,country);
			ps.setDouble(10,contact);
			ps.setDate(11,Formatter.getCurrentDate());
			ps.setString(12,"yes");
			
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		
		
		return status;
	}
	


	public static int register(String name,String email,String password){
		int status=0;
		try{
			System.out.println("NAME"+name+"EMAIL"+email+"PASSWORD"+password);
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into TRAINING_TOOL_USERS(userid,name,email,password,User_Role,registereddate,authorized) values(USERS_ID.NEXTVAL,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,"NEW USER");
			ps.setDate(5,Formatter.getCurrentDate());
			ps.setString(6,"DEACTIVE");
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println(e);}
		
		
		
		return status;
	}

}
