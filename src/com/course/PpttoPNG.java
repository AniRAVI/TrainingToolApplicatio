package com.course;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import com.point.ConProvider;
import com.point.Formatter;
public class PpttoPNG {
	static BufferedImage img;
	static FileOutputStream out;
	static String jpege = "C:\\Users\\IBM_ADMIN\\Desktop\\Upload\\";

	static Connection con = null;
	static PreparedStatement ps = null;
	
	public static void insertPicture(String fileName)throws IOException{
		File file=new File("C:\\Users\\IBM_ADMIN\\Desktop\\Upload\\"+fileName);
		@SuppressWarnings("resource")
		XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(file));
		double zoom = 2; // magnify it by 2
		AffineTransform at = new AffineTransform();
		at.setToScale(zoom, zoom);
		Dimension pgsize = ppt.getPageSize();
		XSLFSlide[] slide = ppt.getSlides();
		int count = 0;
		for (int i = 0; i < slide.length; i++) {
			img = new BufferedImage((int)Math.ceil(pgsize.width*zoom), (int)Math.ceil(pgsize.height*zoom), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();
			graphics.setTransform(at);
			System.out.println("I AM IN FOR LOOP"+count++);
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
					RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			graphics.setColor(Color.white);
			graphics.clearRect(0, 0, pgsize.width, pgsize.height);
			graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
			slide[i].draw(graphics);
			out = new FileOutputStream(jpege+fileName+count+".png");
			String imagePath  = jpege+fileName+count+".png";
			ImageIO.write(img, "png", out);
			System.out.println(out);
			System.out.println(img);
			ppt.write(out);
			try{
				con=ConProvider.getConnection();
				System.out.println(">>>>>>>>>>"+fileName);
				ps=con.prepareStatement("insert into CoursePicture_RECORD (CourseID,picture,Picture_Count,Picture_Id,COURSE_PICTURE) values((select CID from COURSE_DETAILS_RECORD where COURSEFILENAME = "+"'"+fileName+"'"+"and  ROWNUM = 1 "+ "),?,?,PICTURE_ID.NEXTVAL,?)");
				FileInputStream fin=new FileInputStream(imagePath);
				System.out.println(imagePath);
				ps.setBinaryStream(1,fin,fin.available());
				ps.setInt(2,count);
				ps.setDate(3,Formatter.getCurrentDate());
				int j=ps.executeUpdate();
				System.out.println(j+" records affected");
				con.close();
			}catch (Exception e) {e.printStackTrace();}
		}
		System.out.println("Image successfully created");
		out.close();	
	}
	
	public static int insertProfilePic(String fileName,String userEmail){
		String imagePath  = jpege+fileName;
		int j = 0;
		try{
			con=ConProvider.getConnection();
			System.out.println(">>>>>>>>>>"+fileName);
			ps=con.prepareStatement("insert into TRAINING_TOOL_USERS (profile_pic) values(?) where email="+userEmail);
			FileInputStream fin=new FileInputStream(imagePath);
			System.out.println(imagePath);
			ps.setBinaryStream(1,fin,fin.available());
			 j=ps.executeUpdate();
			System.out.println(j+" records affected");
			con.close();
		}catch (Exception e) {e.printStackTrace();}
		System.out.println("Profile picture inserted");
		return j ;
	}
}


