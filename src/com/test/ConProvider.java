package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	}catch(Exception e){System.out.println(e);}
	return con;
    }
	
	public static void cleanUp(Statement st, Connection con){
		try {
			if(st!=null)st.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void cleanUp(ResultSet rs,Statement st, Connection con){
		try {
			if(rs!=null)rs.close();
			if(st!=null)st.close();
			if(con!=null) con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
