package com.test;

import java.io.*;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import java.util.*;
import java.sql.*; 
public class Reader {  
	public static void main(String[] args) throws Exception{                
		Connection con =ConProvider.getConnection();
        PreparedStatement pstm = null;
        String sql = "INSERT INTO XLS_POI"
                        + "(ID, Name, Salary) VALUES"
                        + "(?,?,?)";
        FileInputStream input = new FileInputStream  
         ("C:\\Users\\IBM_ADMIN\\Desktop\\xls_to_oracle1.xls");
        POIFSFileSystem fs = new POIFSFileSystem (input);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        Iterator<?> rows = sheet.rowIterator(); 
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            HSSFRow row = sheet.getRow(i);
           // HSSFRow row=null;
            int id = (int) row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            int salary = (int) row.getCell(2).getNumericCellValue();
            pstm = (PreparedStatement)con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setString(2, name);
            pstm.setLong(3,salary);
            pstm.executeUpdate(); 
            System.out.println("Import rows "+i);
        }
        input.close();
        System.out.println("Success import excel to mysql table");
		ConProvider.cleanUp(pstm, con);
		
	}
}
