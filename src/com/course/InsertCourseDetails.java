package com.course;

import com.course.CourseDaoSecond;
import com.course.PpttoPNG;
import com.course.dao.CourseDao;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.FilenameUtils;

@WebServlet(value={"/InsertCourseDetails"})
@MultipartConfig(fileSizeThreshold=10485760, maxFileSize=1000000000, maxRequestSize=104857600)
public class InsertCourseDetails
extends HttpServlet {
    int status;
    String fileName;
    String location = "C://Users//IBM_ADMIN//Desktop//Upload";
    private static final long serialVersionUID = 1;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File fileSaveDir;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String cname = request.getParameter("cname");
        String cauthor = request.getParameter("cauthor");
        String minDuration = request.getParameter("minDuration");
        String tlEntrylevel = request.getParameter("atlel");//minDuration
        String tlpo = request.getParameter("atlpo");
        String tlad = request.getParameter("atl_ad");
        String tlas = request.getParameter("atlas");
        String tmel = request.getParameter("atmel");
        String tmpo = request.getParameter("atmpo");
        String tmad = request.getParameter("atm_ad");
        String tmas = request.getParameter("atmas");
        String mtlEntrylevel = request.getParameter("mEntrylevel");
        String mtlpo = request.getParameter("mtlpo");
        String mtlad = request.getParameter("mtl_ad");
        String mtlas = request.getParameter("mtlas");
        String mtmel = request.getParameter("mtmel");
        String mtmpo = request.getParameter("mtmpo");
        String mtmad = request.getParameter("mtm_ad");
        String mtmas = request.getParameter("mtmas");
        String dm = request.getParameter("dm");
        String fileName2 = null;
        String fileExtension = null;
        for (Part part : request.getParts()) {
            this.fileName = this.getFileName(part);
            if (this.fileName == null || this.fileName.isEmpty()) continue;
            fileName2 = this.fileName;
            part.write(String.valueOf(this.location) + File.separator + fileName2);
        }
        fileExtension = FilenameUtils.getExtension((String)(String.valueOf(this.location) + fileName2));
        System.out.println("*********************************************");
        System.out.println("________" + cname + "__________");
        System.out.println("________" + cauthor + "__________");
        System.out.println("________" + tlEntrylevel + "__________");
        System.out.println("________" + tlpo + "__________");
        System.out.println("________" + tlad + "__________");
        System.out.println("________" + tlas + "__________");
        System.out.println("________" + tmel + "__________");
        System.out.println("________" + tmpo + "__________");
        System.out.println("________" + tmad + "__________");
        System.out.println("________" + tmas + "__________");
        System.out.println("________" + dm + "__________");
        System.out.println("________" + fileName2 + "__________");
        System.out.println("________" + mtlEntrylevel + "__________");
        System.out.println("________" + mtlpo + "__________");
        System.out.println("________" + mtlad + "__________");
        System.out.println("________" + mtlas + "__________");
        System.out.println("________" + mtmel + "__________");
        System.out.println("________" + mtmpo + "__________");
        System.out.println("________" + mtmad + "__________");
        System.out.println("________" + mtmas + "__________");
        System.out.println("________" + dm + "__________");
        System.out.println("________" + minDuration + "__________");
        System.out.println("________" + fileExtension + "__________");

        System.out.println("*********************************************");
        if(mtlEntrylevel!=null||mtlpo!=null||mtlad!=null||mtlas!=null||mtmel!=null||mtmpo!=null||mtmad!=null||mtmas!=null){
        	System.out.println("Mandantory Field is Not empty");
        	
            if (fileExtension.equals("pptx")) {
                fileSaveDir = new File(this.location);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                this.status =CourseDaoSecond.insertCourseDetails(cname, cauthor, minDuration, fileName2, tlEntrylevel, tlpo, tlad, tlas, tmel, tmpo, tmad, tmas, mtlEntrylevel, mtlpo, mtlad, mtlas, mtmel, mtmpo, mtmad, mtmas, fileExtension, dm)  ;
                PpttoPNG.insertPicture(fileName2);
            } else if (fileExtension.equals("mp4")) {
                System.out.println("FILE EXTENSION IS NOT FOUND" + fileExtension);
                //fileSaveDir = new File("C://Tomcat 7.0//webapps//video");
                fileSaveDir = new File("C://Tomcat//webapps//video");

                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdirs();
                }
                for (Part part2 : request.getParts()) {
                    this.fileName = this.getFileName(part2);
                    if (this.fileName == null || this.fileName.isEmpty()) continue;
                  //  part2.write("C://Tomcat 7.0//webapps//video" + File.separator + this.fileName);
                    part2.write("C://Tomcat//webapps//video" + File.separator + this.fileName);

                }
               this.status =CourseDaoSecond.insertCourseDetails(cname, cauthor, minDuration, fileName2, tlEntrylevel, tlpo, tlad, tlas, tmel, tmpo, tmad, tmas, mtlEntrylevel, mtlpo, mtlad, mtlas, mtmel, mtmpo, mtmad, mtmas, fileExtension, dm)  ;
                System.out.println("STATUS OF INSERTION"+status);
              
            }
            if (this.status > 0) {
            	CourseDao dao = new CourseDao();
            	request.setAttribute("courses", dao.getAllCourses());
            	out.println("<script type=\"text/javascript\">");
                out.println("alert('FIle Uploaded Sycessfully');");
                out.println("</script>");
                request.getRequestDispatcher("launchCourse.jsp").include(request, response);
            }
          
        	
        }
        else{
        	System.out.println("Else Block of Maindatory Check");
        	out.println("<script type=\"text/javascript\">");
            out.println("alert('Please Select Mandantory Field');");
            out.println("</script>");
            request.getRequestDispatcher("UploadCourse").include(request, response);
        }
        
 
    }

    private String getFileName(Part part) {
        String[] tokens;
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        for (String token : tokens = contentDisp.split(";")) {
            if (!token.trim().startsWith("filename")) continue;
            return token.substring(token.indexOf("=") + 2, token.length() - 1);
        }
        return "";
    }
    
   
}