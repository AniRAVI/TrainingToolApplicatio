package com.test;

import java.io.*;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.*;
import java.sql.*; 
public class Assesment {  
	public static int insertQuestion(String fileName,String courseId,String assesmentName) throws Exception{ 
		int status=0;
		String location = "C://Users//IBM_ADMIN//Desktop//Upload//";
		Connection con =ConProvider.getConnection();
		PreparedStatement pstm = null;
		String sql = "INSERT INTO Assesments"
				+ "(Ass_Id, questionNumber, question,answerOne,answerTwo,answerThree,answerFour,correctAnswer) VALUES"
				+"((Select Assesment_Id from Assesment_Details where Course_Id = "+courseId+"and FILE_NAME ="+"'"+fileName+"'and  ROWNUM = 1),"
				+ "?,?,?,?,?,?,?)";
		int count = 0;
		FileInputStream input = new FileInputStream  
				(location+fileName);
		POIFSFileSystem fs = new POIFSFileSystem (input);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
	//	Iterator<?> rows = sheet.rowIterator(); 
		try {
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			HSSFRow row = sheet.getRow(i);
			// HSSFRow row=null;
			count = count+1;
			String ques =  row.getCell(0).getStringCellValue();
			String optOne = row.getCell(1).getStringCellValue();
			String optTwo =  row.getCell(2).getStringCellValue();
			String optThree = row.getCell(3).getStringCellValue();
			String optFour =  row.getCell(4).getStringCellValue();
			int corrans = (int) row.getCell(5).getNumericCellValue();

			
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, count);
				pstm.setString(2,ques);
				pstm.setString(3, optOne);
				pstm.setString(4, optTwo);
				pstm.setString(5,optThree);
				pstm.setString(6, optFour);
				pstm.setInt(7, corrans);
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
