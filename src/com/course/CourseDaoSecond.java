package com.course;

import com.course.Course;
import com.point.ConProvider;
import com.point.Formatter;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseDaoSecond {
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static Statement st = null;

    public static int insertCourseDetails(String cname, String cauthor,String minDuration, String fileName, String atlEntrylevel, String atlpo, String atlad, String atlas, String atmel, String atmpo, String atmad, String atmas,String mtlEntrylevel, String mtlpo, String mtlad, String mtlas, String mtmel, String mtmpo, String mtmad, String mtmas, String fileExtension, String dm) {
        int status;
        status = 0;
        try {
            try {
                con = ConProvider.getConnection();
                String query = "insert into COURSE_DETAILS_RECORD(CID,CNAME,CAUTHOR,COURSEFILENAME,FILE_EXTENSION,MIN_DURATION,A_TL_EL,A_TL_PO,A_TL_AD,A_TL_AS,A_TM_EL,A_TM_PO,A_TM_AD,A_TM_AS,M_TL_EL,M_TL_PO,M_TL_AD,M_TL_AS,M_TM_EL,M_TM_PO,M_TM_AD,M_TM_AS,DM,COURSEDATE) values(COURSE_ID.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, cname);
                ps.setString(2, cauthor);
                ps.setString(3, fileName);
                ps.setString(4, fileExtension);
                ps.setString(5, minDuration);
                ps.setString(6, atlEntrylevel);
                ps.setString(7, atlpo);
                ps.setString(8, atlad);
                System.out.println("TATATATAT");
                ps.setString(9, atlas);
                ps.setString(10, atmel);
                ps.setString(11, atmpo);
                ps.setString(12,atmad);
                ps.setString(13, atmas);
                ps.setString(14, mtlEntrylevel);
                ps.setString(15, mtlpo);
                ps.setString(16, mtlad);
                System.out.println("TATATATAT");
                ps.setString(17, mtlas);
                ps.setString(18, mtmel);
                ps.setString(19, mtmpo);
                ps.setString(20,mtmad);
                ps.setString(21, mtmas);
                ps.setString(22, dm);
                ps.setDate(23, Formatter.getCurrentDate());
                System.out.println(ps);
                status = ps.executeUpdate();
            }
            catch (Exception e) {
                System.out.println(e);
                ConProvider.cleanUp((Statement)ps, (Connection)con);
            }
        }
        finally {
            ConProvider.cleanUp((Statement)ps, (Connection)con);
        }
        return status;
    }

    public void deleteUser(int CID) {
        try {
            try {
                con = ConProvider.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement("delete from COURSE_DETAILS_RECORD where CID=?");
                preparedStatement.setInt(1, CID);
                preparedStatement.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((Statement)ps, (Connection)con);
            }
        }
        finally {
            ConProvider.cleanUp((Statement)ps, (Connection)con);
        }
    }

    public void updateCourse(Course course) {
        try {
            try {
                con = ConProvider.getConnection();
                ps = con.prepareStatement("update COURSE_DETAILS_RECORD set CNAME=?, CMINDURATION=?, CMAXDURATION=?, COURSEFILENAME=?, CAUTHOR=?, COURSEDATE=?,COURSEROLEID=?where CID=?");
                ps.setString(1, course.getCname());
                ps.setInt(2, course.getCminDuration());
                ps.setInt(3, course.getCmaxDuration());
                ps.setString(4, course.getFileName());
                ps.setString(5, course.getCauthor());
                ps.setDate(6, Formatter.getCurrentDate());
                ps.setInt(5, course.getCid());
                ps.setInt(7, course.getCourseRoleId());
                ps.executeUpdate();
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((Statement)ps, (Connection)con);
            }
        }
        finally {
            ConProvider.cleanUp((Statement)ps, (Connection)con);
        }
    }

    public List<Course> getAllCourses() {
        ArrayList<Course> courses;
        courses = new ArrayList<Course>();
        try {
            try {
                con = ConProvider.getConnection();
                st = con.createStatement();
                rs = st.executeQuery("select * from COURSE_DETAILS_RECORD");
                while (rs.next()) {
                    Course course = new Course();
                    course.setCid(rs.getInt("CID"));
                    course.setCname(rs.getString("CNAME"));
                    course.setCminDuration(rs.getInt("CMINDURATION"));
                    course.setCmaxDuration(rs.getInt("CMAXDURATION"));
                    course.setFileName(rs.getString("COURSEFILENAME"));
                    course.setCauthor(rs.getString("CAUTHOR"));
                    course.setCOURSEDATE(rs.getDate("COURSEDATE"));
                    course.setCourseRoleId(rs.getInt("COURSEROLEID "));
                    courses.add(course);
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((ResultSet)rs, (Statement)st, (Connection)con);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)rs, (Statement)st, (Connection)con);
        }
        return courses;
    }

    public Course getCourseById(int courseId) {
        Course course;
        course = new Course();
        try {
            try {
                con = ConProvider.getConnection();
                ps = con.prepareStatement("select * from COURSE_DETAILS_RECORD where CID=?");
                ps.setInt(1, courseId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    course.setCid(rs.getInt("CID"));
                    course.setCname(rs.getString("CNAME"));
                    course.setFileName(rs.getString("COURSEFILENAME"));
                    course.setTlEntrylevel(rs.getString("TL_ENTRY_LEVEL"));
                    course.setTlpo(rs.getString("TL_PO"));
                    course.setTlad(rs.getString("TL_AD"));
                    course.setTlas(rs.getString("TL_AS"));
                    course.setTmel(rs.getString("TM_EL"));
                    course.setTmpo(rs.getString("TM_PO"));
                    course.setTmad(rs.getString("TM_AD"));
                    course.setTmas(rs.getString("TM_AS"));
                    course.setCOURSEDATE(rs.getDate("COURSEDATE"));
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
                ConProvider.cleanUp((ResultSet)rs, (Statement)st, (Connection)con);
            }
        }
        finally {
            ConProvider.cleanUp((ResultSet)rs, (Statement)st, (Connection)con);
        }
        return course;
    }
}

