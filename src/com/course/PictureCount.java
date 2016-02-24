package com.course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.point.ConProvider;

public class PictureCount {


	public static String getPictureCount(String courseId) throws SQLException{
		Connection con=ConProvider.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pictureCount =null;
		try {
			ps = con.prepareStatement("select max(PICTURE_COUNT) as picture_count  from CoursePicture_RECORD where  CourseID  = ?");
			ps.setString(1, courseId);
			rs = ps.executeQuery();
			rs.next();
			pictureCount = rs.getString("PICTURE_COUNT");
			System.out.println("******PICTURE COUNT CLASS******"+pictureCount);

		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		} finally{
			ConProvider.cleanUp(rs, ps, con);
		}

		return pictureCount;
	}
	
	
	public static int updatePictureCount(String courseId,String email) throws SQLException{
		Connection con=ConProvider.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pictureCount =null;
		try {
			ps = con.prepareStatement("Select  CoursePicture_RECORD  where  CourseID  = ? and UserName = ");
			ps.setString(1, courseId);
			rs = ps.executeQuery();
			rs.next();
			pictureCount = rs.getString("PICTURE_COUNT");
			System.out.println("******PICTURE COUNT CLASS******"+pictureCount);

		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		} finally{
			ConProvider.cleanUp(rs, ps, con);
		}
		return 0;
	}
}
