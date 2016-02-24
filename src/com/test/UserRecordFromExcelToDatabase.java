package com.test;

import java.io.*;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.point.Formatter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.*;
import java.sql.*; 
public class UserRecordFromExcelToDatabase {  
	
	
	//Method for insert data into database from Excel 
	
	public static int insertUsers(String fileName) throws Exception{ 
		int status=0;
		String location = "C://Users//IBM_ADMIN//Desktop//Upload//";
		Connection con =ConProvider.getConnection();
		PreparedStatement pstm = null;
		String sql ="insert into TRAINING_TOOL_USERS(userid,name,email,password,User_Role,registereddate,authorized,User_Sub_Role) values(USERS_ID.NEXTVAL,?,?,?,?,?,?,?)";
		FileInputStream input = new FileInputStream(location+fileName);
		POIFSFileSystem fs = new POIFSFileSystem (input);
		@SuppressWarnings("resource")
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		@SuppressWarnings("unused")
		Iterator<?> rows = sheet.rowIterator(); 
		try {
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			HSSFRow row = sheet.getRow(i);
			String name =  row.getCell(0).getStringCellValue();
			String attid = row.getCell(1).getStringCellValue();
			String password =  row.getCell(2).getStringCellValue();
			
				pstm = con.prepareStatement(sql);
				pstm.setString(1,name);
				pstm.setString(2, attid);
				pstm.setString(3, password);
				pstm.setString(4,"New User");
				pstm.setDate(5, Formatter.getCurrentDate());
				pstm.setString(6, "DEACTIVE");
				pstm.setString(7, "Sub Role");
				status= pstm.executeUpdate();
		 
			System.out.println("Import rows "+i);
		}
		System.out.println("Success import excel to mysql table");
		} finally {
			ConProvider.cleanUp(pstm, con);		
			input.close();
		}
		return status;
	}
}
