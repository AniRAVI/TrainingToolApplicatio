package com.test;

import java.io.*;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;

import java.util.*;
import java.sql.*; 
public class ExcelFromTable {  
	public static void main(String[] args) throws Exception{                
		Connection conn =ConProvider.getConnection();
		System.out.println("REACHED PREPARE STATEMENT");
		PreparedStatement sql_statement = null;
		String jdbc_insert_sql = "INSERT INTO XLS_POI"
				+ "(KEYWORD, TOTAL_COUNT) VALUES"
				+ "(?,?)";
		String question = "insert into Assesments"
						  +"(Ass_Id,questionNumber,question,answerOne,answerTwo,answerThree,answerFour,correctAnswer)"
						  +"(?,?,?,?,?,?,?)";
		sql_statement = conn.prepareStatement(jdbc_insert_sql);
		FileInputStream input_document = new FileInputStream(new File("C:\\Users\\IBM_ADMIN\\Desktop\\xls_to_oracle.xls"));
		HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document);
		HSSFSheet my_worksheet = my_xls_workbook.getSheetAt(0);
		Iterator<Row> rowIterator = my_worksheet.iterator(); 
		while(rowIterator.hasNext()) {
			Row row = rowIterator.next(); 
			Iterator<Cell> cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				switch(cell.getCellType()) { 
				case Cell.CELL_TYPE_STRING: //handle string columns
				sql_statement.setString(1, cell.getStringCellValue());                                                                                     
				break;
				case Cell.CELL_TYPE_NUMERIC: //handle double data
					sql_statement.setDouble(2,cell.getNumericCellValue() );
					break;
				}
			}
			sql_statement.executeUpdate();
		}
		input_document.close();	
		ConProvider.cleanUp(sql_statement, conn);
		
	}
}
