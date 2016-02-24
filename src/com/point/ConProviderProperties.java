package com.point;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConProviderProperties {

	public static Connection getConnection() throws IOException{
		GetPropertyValue getPropertyValue = new GetPropertyValue();
		List<String> propertyValue = new ArrayList<String>();
		propertyValue = getPropertyValue.getPropertyValue();
	Connection con=null;
	try{
		Class.forName(propertyValue.get(0));
		con=DriverManager.getConnection(propertyValue.get(1),propertyValue.get(2),propertyValue.get(3));
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
