package com.course.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.course.model.Users;
import com.point.ConProvider;
public class UsersDao {
	private Connection connection = null;
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
	ResultSet rs=null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	public void checkUser(Users users) {
		try {
			connection = ConProvider.getConnection();
			PreparedStatement ps = connection.prepareStatement("Select * from COMPANY_MAILER_USER where USERID =?");
			ps.setInt(1, users.getUserid());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				if(users.getUserAction().equalsIgnoreCase("updateUsersRecords")){
					{
						updateUsersRecords(users);
					}

				}else if (users.getUserAction().equalsIgnoreCase("updateUsersProfile")){
					updateUser(users);
				}
			} 
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		} finally{
			ConProvider.cleanUp(rs, statement, connection);
		}
	}
	public void checkRegisterUsers(Users users) {
		try {
			connection = ConProvider.getConnection();
			PreparedStatement ps = connection.prepareStatement("Select * from training_tool_users where USERID =?");
			ps.setInt(1, users.getUserid());
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				if(users.getUserAction().equalsIgnoreCase("updateUsersRecords")){
					{
						//updateUsersRecords(users);
						updateUsersRecord(users);

					}

				}else if (users.getUserAction().equalsIgnoreCase("updateUsersProfile")){
					updateUser(users);
				}
			} 
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		} finally{
			ConProvider.cleanUp(rs, statement, connection);
		}
	}
	public void deleteUser(int  userId) {
		try {
			connection = ConProvider.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("delete from TRAINING_TOOL_USERS where USERID=?");
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateUsersRecords(Users user) {
		try {
			connection = ConProvider.getConnection();
            System.out.println("QUERY UPDATE USERS RECORDS"+user.getUserRole()+"\t"+user.getUserAccess());
			PreparedStatement preparedStatement = connection.prepareStatement("update COMPANY_MAILER_USER SET USER_ROLE =?, AUTHORIZED = ?"
					+ "where USERID=?");
			preparedStatement.setString(1, user.getUserRole());
			preparedStatement.setString(2, user.getUserAccess());
			preparedStatement.setInt(3, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(preparedStatement, connection);
		}
	}
	public void updateUsersRecord(Users user) {
		try {
			connection = ConProvider.getConnection();
            System.out.println("QUERY UPDATE USERS RECORDS"+user.getUserRole()+"\t"+user.getUserAccess());
			PreparedStatement preparedStatement = connection.prepareStatement("update training_tool_users SET USER_ROLE =?, AUTHORIZED = ? ,User_Sub_Role =?"
					+ "where USERID=?");
			preparedStatement.setString(1, user.getUserRole());
			preparedStatement.setString(2, user.getUserAccess());
			preparedStatement.setString(3, user.getUserSubRole());
			preparedStatement.setInt(4, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(preparedStatement, connection);
		}
	}
	public void updateUser(Users user) throws ParseException {
		try {
			connection = ConProvider.getConnection();
			System.out.println("UPDATE USER PROFILE");
			PreparedStatement preparedStatement = connection.prepareStatement("update TRAINING_TOOL_USERS set NAME=?, EMAIL=?, PASSWORD=?, GENDER=?,DOB=?, ADDRESSLINE=?, CITY =?, STATE =?, CONTACT =?"
					+ "where USERID=?");
			System.out.println("Update Users Records");
			preparedStatement.setString(1,user.getUsername());
			preparedStatement.setString(2, user.getUserEmail());   
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5,  user.getDob());
			preparedStatement.setString(6, user.getAddressLine());
			preparedStatement.setString(7, user.getCity());
			preparedStatement.setString(8, user.getState());
			preparedStatement.setDouble(9, user.getContactNumber());
			preparedStatement.setInt(10, user.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(preparedStatement, connection);
		}
	}
	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<Users>();
		try {
			connection = ConProvider.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from TRAINING_TOOL_USERS");
			while (rs.next()) {
				Users user = new Users();
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("name"));
				user.setUserEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserRole(rs.getString("USER_ROLE"));
				user.setUserSubRole(rs.getString("User_Sub_Role"));
				user.setRegisterDate(rs.getDate("REGISTEREDDATE"));
				user.setUserAccess(rs.getString("AUTHORIZED"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, statement, connection);
		}
		return users;
	}
	
	public List<Users> getAllUserRecord() {
		List<Users> users = new ArrayList<Users>();
		try {
			connection = ConProvider.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from training_tool_users");
			while (rs.next()) {
				Users user = new Users();
				user.setUserid(rs.getInt("USERID"));
				user.setUsername(rs.getString("NAME"));
				user.setUserEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserRole(rs.getString("USER_ROLE"));
				user.setUserSubRole(rs.getString("User_Sub_Role"));
				user.setRegisterDate(rs.getDate("REGISTEREDDATE"));
				user.setUserAccess(rs.getString("AUTHORIZED"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, statement, connection);
		}
		System.out.println("**********************"+users);

		return users;
	}

	public Users getByUsersId(int usersId) {
		Users user = new Users();
		try {
			connection = ConProvider.getConnection();
			preparedStatement = connection.prepareStatement("select * from COMPANY_MAILER_USER where USERID=?");
			preparedStatement.setInt(1, usersId);
			System.out.println("*******"+usersId+"*****");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("USERID"));
				user.setUsername(rs.getString("NAME"));
				user.setUserEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setGender(rs.getString("GENDER"));
				user.setDob(rs.getString("DOB"));
				user.setAddressLine(rs.getString("ADDRESSLINE"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setUserRole(rs.getString("USER_ROLE"));
				user.setContactNumber(rs.getInt("CONTACT"));
				user.setRegisterDate(rs.getDate("REGISTEREDDATE"));
				user.setUserAccess(rs.getString("AUTHORIZED"));
				System.out.println("UserName****************"+user.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, preparedStatement, connection);
		}

		return user;
	}
	
	public Users getByUserId(int usersId) {
		Users user = new Users();
		try {
			connection = ConProvider.getConnection();
			preparedStatement = connection.prepareStatement("select * from training_tool_users where USERID=?");
			preparedStatement.setInt(1, usersId);
			System.out.println("*******"+usersId+"*****");
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUserid(rs.getInt("USERID"));
				user.setUsername(rs.getString("NAME"));
				user.setUserEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setUserRole(rs.getString("USER_ROLE"));
				user.setUserSubRole(rs.getString("User_Sub_Role"));
				user.setUserAccess(rs.getString("AUTHORIZED"));
				System.out.println("UserName****************"+user.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(rs, preparedStatement, connection);
		}

		return user;
	}

	public Users manageByUsersId(int usersId) {
		Users user = new Users();
		try {
			connection = ConProvider.getConnection();
			preparedStatement = connection.prepareStatement("select * from COMPANY_MAILER_USER where USERID=?");
			preparedStatement.setInt(1, usersId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setUserid(rs.getInt("USERID"));
				user.setUsername(rs.getString("NAME"));
				user.setUserEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setGender(rs.getString("GENDER"));
				user.setDob(rs.getString("DOB"));
				user.setAddressLine(rs.getString("ADDRESSLINE"));
				user.setCity(rs.getString("CITY"));
				user.setState(rs.getString("STATE"));
				user.setUserRole(rs.getString("USER_ROLE"));
				user.setContactNumber(rs.getInt("CONTACT"));
				user.setRegisterDate(rs.getDate("REGISTEREDDATE"));
				user.setUserAccess(rs.getString("AUTHORIZED"));
				System.out.println("UserName****************"+user.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConProvider.cleanUp(preparedStatement, connection);
		}
		return user;
	}
}
