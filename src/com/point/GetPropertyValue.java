package com.point;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class GetPropertyValue {
	
	
	public  List<String> getPropertyValue() throws IOException{
		InputStream inputStream;
		List<String>	oracle_Details = null;
		try {
			oracle_Details = new ArrayList<String>();
			Properties prop = new Properties();
		String propertyFileName = "config.properties"; 
		//	String propertyFileName = "config.properties"; 

			inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);	
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propertyFileName + "' not found in the classpath");
			}
			 
			// get the property value and print it out
			String className = prop.getProperty("oracle_class");
			String user = prop.getProperty("oracle_userName");
			String password = prop.getProperty("oracle_password");
			String url = prop.getProperty("oracle_url");
			oracle_Details.add(className);
			oracle_Details.add(user);
			oracle_Details.add(password);
			oracle_Details.add(url);
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		System.out.println("******************"+oracle_Details);
		return oracle_Details;
	}

}
