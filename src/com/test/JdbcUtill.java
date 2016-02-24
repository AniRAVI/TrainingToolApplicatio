package com.test;
import java.sql.*;  

public class JdbcUtill {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
	        Class.forName("oracle.jdbc.OracleDriver");
			  
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
		
	}
	
	public static Connection getMySqlConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/Course";
		Connection con=(Connection)DriverManager.getConnection(url,"root","root");  
		return con;
	}
	
	public static Connection getOracleCOnnection() throws SQLException{
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		Connection con=DriverManager.getConnection(url,"system","root");  
		return con;
	}
	
	public static void cleanUp(Statement stmt, Connection con){
		try {
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public static void cleanUp(ResultSet rs,Statement stmt, Connection con){
		try {
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
			if(rs!=null)stmt.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
