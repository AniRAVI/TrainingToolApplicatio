package com.course.dao;

import com.course.model.CourseSecond;
import com.point.ConProvider;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CourseDao {
    private Connection connection;
    private PreparedStatement ps = null;
    ResultSet rs = null;
    Statement statement = null;

    public void checkCourse(CourseSecond course) {
        try {
            try {
                this.connection = ConProvider.getConnection();
                PreparedStatement ps = this.connection.prepareStatement("select cname from COURSE_DETAILS_RECORD  where cid = ?");
                ps.setString(1, course.getCid());
                this.rs = ps.executeQuery();
                if (this.rs.next()) {
                    this.updateCourse(course);
                }
            }
            catch (Exception ex) {
                System.out.println("Error in check() -->" + ex.getMessage());
                ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.ps, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.ps, (Connection)this.connection);
        }
    }

    public void deleteCourse(int cid) {
        try {
            try {
                this.connection = ConProvider.getConnection();
                this.ps = this.connection.prepareStatement("delete from COURSE_DETAILS_RECORD where cid=?");
                this.ps.setInt(1, cid);
                this.ps.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((Statement)this.ps, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((Statement)this.ps, (Connection)this.connection);
        }
    }

    public void updateCourse(CourseSecond course) {
        try {
            try {
                this.connection = ConProvider.getConnection();
                String sqlQuery = "update COURSE_DETAILS_RECORD set CNAME=?, CAUTHOR=?, MIN_DURATION=?, A_TL_EL=?, A_TL_PO =?,A_TL_AD=?,A_TL_AS=?,A_TM_EL=?,A_TM_PO=?,A_TM_AD=?,A_TM_AS=?,M_TL_EL=?,M_TL_PO=?,M_TL_AD=?,M_TL_AS=?,M_TM_EL=?,M_TM_PO=?,M_TM_AD=?,M_TM_AS=?,DM=? where cid=?";
                this.ps = this.connection.prepareStatement(sqlQuery);
                System.out.println("UPDATE COURSE" + course.getCname());
                System.out.println("Sql Query " + sqlQuery);
                this.ps.setString(1,course.getCname());
                this.ps.setString(2,course.getCauthor());
                this.ps.setString(3,course.getCmin());
                this.ps.setString(4,course.getTlEntrylevel());
                this.ps.setString(5,course.getTlpo());
                this.ps.setString(6,course.getTlad());
                this.ps.setString(7,course.getTlas());
                this.ps.setString(8,course.getTmel());
                this.ps.setString(9,course.getTmpo());
                this.ps.setString(10,course.getTmad());
                this.ps.setString(11,course.getTmas());
                this.ps.setString(12,course.getMtlEntrylevel());
                this.ps.setString(13,course.getMtlpo());
                this.ps.setString(14,course.getMtlad());
                this.ps.setString(15,course.getMtlas());
                this.ps.setString(16,course.getMtmel());
                this.ps.setString(17,course.getMtmpo());
                this.ps.setString(18,course.getMtmad());
                this.ps.setString(19,course.getMtmas());
                this.ps.setString(20,course.getDm());
                this.ps.setString(21,course.getCid());
                this.ps.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((Statement)this.ps, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((Statement)this.ps, (Connection)this.connection);
        }
    }

    public List<CourseSecond> getAllCourses() {
        ArrayList<CourseSecond> courses;
        courses = new ArrayList<CourseSecond>();
        try {
            try {
                this.connection = ConProvider.getConnection();
                this.statement = this.connection.createStatement();
                this.rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD");
                while (this.rs.next()) {
                    CourseSecond course = new CourseSecond();
                    course.setCid(this.rs.getString("CID"));
                    course.setCname(this.rs.getString("CNAME"));
                    course.setCauthor(this.rs.getString("CAUTHOR"));
                    course.setCfileName(this.rs.getString("COURSEFILENAME"));
                    course.setCmin(this.rs.getString("MIN_DURATION"));
                    course.setFileExtension(this.rs.getString("FILE_EXTENSION"));
                    courses.add(course);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.statement, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.statement, (Connection)this.connection);
        }
        return courses;
    }

    public List<CourseSecond> getAllCorsesforNormalUser(String userRole,String userSubRole) {
        ArrayList<CourseSecond> courses;
        courses = new ArrayList<CourseSecond>();
        ResultSet rs = null;
        try {
            try {
                this.connection = ConProvider.getConnection();
                this.statement = this.connection.createStatement();
                if (userRole.equals("Team Lead")&& userSubRole.equals("PO")) {
                    rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_PO = 1 or M_TL_PO = 1");
                } else  if (userRole.equals("Team Lead")&& userSubRole.equals("AD")) {
                    rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_AD = 1 or M_TL_AD = 1");
                }else  if (userRole.equals("Team Lead")&& userSubRole.equals("AS")) {
                    rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_AS = 1 or M_TL_AS = 1");
                }else  if (userRole.equals("Team Lead")&& userSubRole.equals("Entry Level")) {
                    rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_EL = 1 or M_TL_EL = 1");
                } else   if (userRole.equals("Team Manger")&& userSubRole.equals("PO")) {
                           rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_PO = 1 or M_TM_PO = 1");
                       } else  if (userRole.equals("Team Manger")&& userSubRole.equals("AD")) {
                           rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_AD = 1 or M_TM_AD = 1");
                       }else  if (userRole.equals("Team Manger")&& userSubRole.equals("AS")) {
                           rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_AS = 1 or M_TM_AS = 1");
                       }else  if (userRole.equals("Team Manger")&& userSubRole.equals("Entry Level")) {
                           rs = this.statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_EL = 1 or M_TM_EL = 1");
                       }
                while (rs.next()) {
                    CourseSecond course = new CourseSecond();
                    course.setCid(rs.getString("CID"));
                    course.setCname(rs.getString("CNAME"));
                    course.setCauthor(rs.getString("CAUTHOR"));
                    course.setCfileName(rs.getString("COURSEFILENAME"));
                    course.setCmin(rs.getString("MIN_DURATION"));
                    course.setFileExtension(rs.getString("FILE_EXTENSION"));
                    courses.add(course);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((ResultSet)rs, (Statement)this.statement, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)rs, (Statement)this.statement, (Connection)this.connection);
        }
        System.out.println("Courses "+courses);
        return courses;
    }

    public CourseSecond getCourseById(int cid) {
        CourseSecond course = new CourseSecond();
        try {
            try {
                this.connection = ConProvider.getConnection();
                PreparedStatement preparedStatement = this.connection.prepareStatement("select * from COURSE_DETAILS_RECORD where cid=?");
                preparedStatement.setInt(1, cid);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    course.setCid(rs.getString("CID"));
                    course.setCname(rs.getString("CNAME"));
                    course.setCauthor(rs.getString("CAUTHOR"));
                    course.setCmin(rs.getString("MIN_DURATION"));
                    course.setTlEntrylevel(rs.getString("A_TL_EL"));
                    course.setTlpo(rs.getString("A_TL_PO"));
                    course.setTlad(rs.getString("A_TL_AD"));
                    course.setTlas(rs.getString("A_TL_AS"));
                    course.setTmel(rs.getString("A_TM_EL"));
                    course.setTmpo(rs.getString("A_TM_PO"));
                    course.setTmad(rs.getString("A_TM_AD"));
                    course.setTmas(rs.getString("A_TM_AS"));
                    course.setMtlEntrylevel(rs.getString("M_TL_EL"));
                    course.setMtlpo(rs.getString("M_TL_PO"));
                    course.setMtlad(rs.getString("M_TL_AD"));
                    course.setMtlas(rs.getString("M_TL_AS"));
                    course.setMtmel(rs.getString("M_TM_EL"));
                    course.setMtmpo(rs.getString("M_TM_PO"));
                    course.setMtmad(rs.getString("M_TM_AD"));
                    course.setMtmas(rs.getString("M_TM_AS"));
                    course.setDm(rs.getString("DM"));



                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.statement, (Connection)this.connection);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)this.rs, (Statement)this.statement, (Connection)this.connection);
        }
        return course;
    }
    public  String countStatus(String userId){
    	String countStatus =null;
    	String sql = "Select count(username) as countPass  from RESULTRECORD where UserId = ? and Status ='Pass'";
    	try{
            this.connection = ConProvider.getConnection();
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                countStatus=rs.getString("countPass");

            }
		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return countStatus;
    }
}