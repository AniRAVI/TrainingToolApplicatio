package com.course;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.point.ConProvider;

@WebServlet(name = "DisplayPhotoServlet", urlPatterns = {"/displayphoto"})
public class DisplayPhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement ps = null;
	ResultSet rs =null;
	Connection con = null;
	int count ;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	HttpSession session=request.getSession();  
            String courseId = (String) session.getAttribute("cid"); 
        	 con=ConProvider.getConnection();
        	if(request.getParameter("name").toString().equals("undefined"))
        	{
               count=0;
        	}
        	else{
        		  count = Integer.parseInt(request.getParameter("name"));
        	}
           
            if(count>=1){
             ps = con.prepareStatement("select PICTURE  from CoursePicture_RECORD where picture_count = ? AND CourseID  = ?");
             ps.setInt(1,count );
             ps.setString(2, courseId);
            }
            rs = ps.executeQuery();
            System.out.println(count+1);
            rs.next();
            Blob b = rs.getBlob("PICTURE");
            response.setContentType("image/jpeg");
            response.setContentLength((int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = response.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
			ConProvider.cleanUp(rs, ps, con);
		}
    }

}
