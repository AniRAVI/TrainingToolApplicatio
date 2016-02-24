package com.course.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assesment.dom.AssesmentDao;
import com.assesment.dom.AvilCourseDo;
import com.assesment.dom.ManCourseDo;
import com.assesment.dom.StatusDo;
import com.course.model.CourseSecond;
import com.point.Formatter;
import com.test.ConProvider;

public class ResultRecordDao {
	static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement statement = null;

	public static int insertResultRecord(ResultRecordDo resultRecordDo){
		int status =0;
		try {
			System.out.println("****** Result Record Called ********");
			connection = ConProvider.getConnection();
			String query ="insert into ResultRecord (rid,userId,userName,userRole,status,marks,cid,noOfAttempt,resdate,cname,userSubRole) values (Res_Id.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setString(1,resultRecordDo.getUserId() );
			ps.setString(2, resultRecordDo.getUserName());
			ps.setString(3, resultRecordDo.getUserRole());
			ps.setString(4, resultRecordDo.getStatus());
			ps.setInt(5, resultRecordDo.getMarks());
			ps.setString(6, resultRecordDo.getCourseId());
			ps.setInt(7, resultRecordDo.getNoOfAttempts());
			ps.setDate(8, Formatter.getCurrentDate());
			ps.setString(9, resultRecordDo.getCname());
			ps.setString(10, resultRecordDo.getSubUserRole());
			status = ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
			ConProvider.cleanUp((Statement)ps, (Connection)connection);
		}
	finally {
		ConProvider.cleanUp((Statement)ps, (Connection)connection);
	}
		return status;
	}
	
	
	public static List<Integer>  checkNoOfAttemts(String userId,String courseId){
		System.out.println("******* No of Attempts Check    ***** ");

		List<Integer> statusOfResult = new ArrayList<Integer>();
		try {
			connection = ConProvider.getConnection();
			String query ="Select * from ResultRecord where USERID = ? and CID = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1,userId );
			
			ps.setString(2,courseId);
			rs = ps.executeQuery();
			if(rs.next())
				statusOfResult.add(rs.getInt("NOOFATTEMPT"));
				statusOfResult.add(rs.getInt("marks"));

		}
		catch (Exception e) {
			System.out.println(e);
			ConProvider.cleanUp((Statement)ps, (Connection)connection);
		}
	finally {
		ConProvider.cleanUp((Statement)ps, (Connection)connection);
	}
		return statusOfResult;
	}


	public static void updateResultRecords(ResultRecordDo resultRecordDo) {
		
		 try {
	            try {
	                connection = ConProvider.getConnection();
	                String sqlQuery = "Update ResultRecord set STATUS =? ,MARKS = ? ,NOOFATTEMPT = ?, RESDATE =?  where USERID = ? and CID = ?";
	               ps = connection.prepareStatement(sqlQuery);
	                System.out.println("Sql Query " + sqlQuery);
	                ps.setString(1,resultRecordDo.getStatus());
	                ps.setInt(2,resultRecordDo.getMarks());
	                ps.setInt(3,resultRecordDo.getNoOfAttempts());
	                ps.setDate(4, Formatter.getCurrentDate());
	                ps.setString(5,resultRecordDo.getUserId());
	                ps.setString(6,resultRecordDo.getCourseId());
	                ps.executeUpdate();

	            }
	            catch (SQLException e) {
	                e.printStackTrace();
	                ConProvider.cleanUp(ps, connection);
	            }
	        }
	        finally {
	            ConProvider.cleanUp(ps, connection);
	        }
		
	}

	public static List<StatusDo>  statusOfParticularRole(String userRole){
		List<StatusDo> resultStatus = new ArrayList<StatusDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where userId = ? ";
	ps = connection.prepareStatement(query);
	ps.setString(1,userRole);
	rs = ps.executeQuery();
	while(rs.next())
	{
		StatusDo statusDO = new StatusDo();
		statusDO.setCid(rs.getString("CID"));
		statusDO.setCname(rs.getString("cname"));
		statusDO.setStatus(rs.getString("status"));
		statusDO.setMarks(rs.getString("marks"));
		statusDO.setNoOfAttempts(rs.getString("noOfAttempt"));
		statusDO.setDate(rs.getDate("resdate"));
		resultStatus.add(statusDO);
		}
		}
			catch (Exception e) {
			System.out.println(e);
			ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
		finally {
			ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
		return resultStatus;
}
	
	public static List<AvilCourseDo>  aviCourse(String userRole,String userSubRole){
		List<AvilCourseDo>   aviCourse = new ArrayList<AvilCourseDo>();
		ResultSet rs = null;

		try{
            connection = ConProvider.getConnection();
            statement =  connection.createStatement();

		  if (userRole.equals("Team Lead")&& userSubRole.equals("PO")) {
              rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_PO =1");
		  	} else  if (userRole.equals("Team Lead")&& userSubRole.equals("AD")) {
              rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_AD = 1");
          			}else  if (userRole.equals("Team Lead")&& userSubRole.equals("AS")) {
              rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_AS = 1 ");
          		}else  if (userRole.equals("Team Lead")&& userSubRole.equals("Entry Level")) {
              rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TL_EL = 1 ");
          		} else   if (userRole.equals("Team Manger")&& userSubRole.equals("PO")) {
                     rs =statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_PO = 1 ");
                 } else  if (userRole.equals("Team Manger")&& userSubRole.equals("AD")) {
                	 rs =statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_AD = 1");
                 }else  if (userRole.equals("Team Manger")&& userSubRole.equals("AS")) {
                     rs =statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_AS = 1");
                 }else  if (userRole.equals("Team Manger")&& userSubRole.equals("Entry Level")) {
                     rs =statement.executeQuery("select * from COURSE_DETAILS_RECORD where  A_TM_EL = 1 ");
                 }
          while (rs.next()) {
        	  AvilCourseDo aviCouseforUser = new AvilCourseDo();
        	  aviCouseforUser.setAcid(rs.getString("CID"));
        	  aviCouseforUser.setAcname(rs.getString("CNAME"));
        	  aviCouseforUser.setAcauthor(rs.getString("CAUTHOR"));
        	  aviCouseforUser.setAfileExt(rs.getString("FILE_EXTENSION"));
        	  aviCouseforUser.setAminDuration(rs.getString("MIN_DURATION"));
        	  aviCouseforUser.setAdate(rs.getDate("COURSEDATE"));
        	  aviCouseforUser.setAfileName(rs.getString("COURSEFILENAME"));

              aviCourse.add(aviCouseforUser);
          }
      }
      catch (SQLException e) {
          e.printStackTrace();
          ConProvider.cleanUp(rs,statement, connection);
      }
  finally {
      ConProvider.cleanUp(rs,statement,connection);
  }
  System.out.println("Avilable Course "+aviCourse);
  return aviCourse;
}
	
	
	public static List<ManCourseDo>  manCourse(String userRole,String userSubRole){
		List<ManCourseDo>   mviCourse = new ArrayList<ManCourseDo>();
		ResultSet rs = null;

		try{
            connection = ConProvider.getConnection();
            statement =  connection.createStatement();

            if (userRole.equals("Team Lead")&& userSubRole.equals("PO")) {
                rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where M_TL_PO = 1");
            } else  if (userRole.equals("Team Lead")&& userSubRole.equals("AD")) {
                rs =statement.executeQuery("select * from COURSE_DETAILS_RECORD where  M_TL_AD = 1");
            }else  if (userRole.equals("Team Lead")&& userSubRole.equals("AS")) {
                rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where   M_TL_AS = 1");
            }else  if (userRole.equals("Team Lead")&& userSubRole.equals("Entry Level")) {
                rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where  M_TL_EL = 1");
            } else   if (userRole.equals("Team Manger")&& userSubRole.equals("PO")) {
                       rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where   M_TM_PO = 1");
                   } else  if (userRole.equals("Team Manger")&& userSubRole.equals("AD")) {
                       rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where   M_TM_AD = 1");
                   }else  if (userRole.equals("Team Manger")&& userSubRole.equals("AS")) {
                       rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where   M_TM_AS = 1");
                   }else  if (userRole.equals("Team Manger")&& userSubRole.equals("Entry Level")) {
                       rs = statement.executeQuery("select * from COURSE_DETAILS_RECORD where   M_TM_EL = 1");
                   }
          while (rs.next()) {
        	  ManCourseDo mviCouseforUser = new ManCourseDo();
        	  mviCouseforUser.setMcid(rs.getString("CID"));
        	  mviCouseforUser.setMcname(rs.getString("CNAME"));
        	  mviCouseforUser.setMcauthor(rs.getString("CAUTHOR"));
        	  mviCouseforUser.setMfileExt(rs.getString("FILE_EXTENSION"));
        	  mviCouseforUser.setMminDuration(rs.getString("MIN_DURATION"));
        	  mviCouseforUser.setMdate(rs.getDate("COURSEDATE"));
        	  mviCouseforUser.setMfileName(rs.getString("COURSEFILENAME"));
        	  mviCourse.add(mviCouseforUser);
          }
      }
      catch (SQLException e) {
          e.printStackTrace();
          ConProvider.cleanUp(rs,statement, connection);
      }
  finally {
      ConProvider.cleanUp(rs,statement,connection);
  }
  System.out.println("Avilable Course "+mviCourse);
  return mviCourse;
}
	
	
	public static List<ResultRecordDo>  statusOfResult(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}

	
	// User Role - Team Lead --- User Sub Role -- Entry Level
	
	public static List<ResultRecordDo>  statusOfResultTLEL(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Lead' and usersubrole = 'Entry Level' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	public static List<ResultRecordDo>  statusOfResultTLAD(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Lead' and usersubrole = 'AD' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	public static List<ResultRecordDo>  statusOfResultTLAS(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Lead' and usersubrole = 'AS' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	public static List<ResultRecordDo>  statusOfResultTLPO(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Lead' and usersubrole = 'PO' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	
	public static List<ResultRecordDo>  statusOfResultTMEL(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Manger' and usersubrole = 'Entry Level' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	
	public static List<ResultRecordDo>  statusOfResultTMAD(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Manger' and usersubrole = 'AD' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	public static List<ResultRecordDo>  statusOfResultTMAS(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Manger' and usersubrole = 'AS' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
	public static List<ResultRecordDo>  statusOfResultTMPO(){
		List<ResultRecordDo> resultStatus = new ArrayList<ResultRecordDo>();
		try {
	connection = ConProvider.getConnection();
	String query ="Select * from ResultRecord where Userrole ='Team Manger' and usersubrole = 'PO' ";
	ps = connection.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next())
	{
		ResultRecordDo resultRecordDo = new ResultRecordDo();
		resultRecordDo.setUserId(rs.getString("userId"));
		resultRecordDo.setUserName(rs.getString("userName"));
		resultRecordDo.setStatus(rs.getString("status"));
		resultRecordDo.setMarks(rs.getInt("marks"));
		resultRecordDo.setNoOfAttempts(rs.getInt("noOfAttempt"));
		resultRecordDo.setCourseId(rs.getString("CID"));
		resultRecordDo.setsDate(rs.getDate("RESDATE"));


		resultStatus.add(resultRecordDo);
		}
	
		
		}
catch (Exception e) {
	System.out.println(e);
	ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
finally {
ConProvider.cleanUp((Statement)ps, (Connection)connection);
}
return resultStatus;
}
	
/*	public static void main(String args[])
	{
		ResultRecordDao.aviCourse("Team Manger", "AD");
	}*/
}
