package com.assesment.dom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.course.model.CourseSecond;
import com.point.Formatter;
import com.test.ConProvider;
public class AssesmentDao {
	static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement statement = null;
	//static PreparedStatement psms;
	public static List<AssesmentDO> getAllQuestion(String assesmentId) {
		ArrayList<AssesmentDO> courses;
		courses = new ArrayList<AssesmentDO>();
		try {
		try {
			connection = ConProvider.getConnection();

			String query = "select * from Assesments where Ass_id = ?";
			ps = connection.prepareStatement(query);
			ps.setString(1, assesmentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				AssesmentDO assesment = new AssesmentDO();
		//assesment.setQuestionNumber(this.rs.getInt("questionNumber"));
		assesment.setQuestion(rs.getString("question"));
		assesment.setOptOne(rs.getString("answerOne"));
		assesment.setOptTwo(rs.getString("answerTwo"));
		assesment.setOptThree(rs.getString("answerThree"));
		assesment.setOptFour(rs.getString("answerFour"));
		assesment.setCorrAnswer(rs.getString("correctAnswer"));
		courses.add(assesment);
		}
		}
		catch (SQLException e) {
		e.printStackTrace();
		ConProvider.cleanUp((ResultSet)rs, (Statement)statement, (Connection)AssesmentDao.connection);
			}
		}
		finally {
			ConProvider.cleanUp((ResultSet)rs, (Statement)statement, (Connection)AssesmentDao.connection);
		}
		return courses;
	}
	public List<String>  getAllCourseID() {
		List<String> coursesFromCourseDetail = new ArrayList<String>();
		try {
			try {
				connection = ConProvider.getConnection();
				statement = AssesmentDao.connection.createStatement();
				rs = statement.executeQuery("select CID,CNAME from COURSE_DETAILS_RECORD");
				while (rs.next()) {
					//AssesmentDO assesment = new AssesmentDO();
					coursesFromCourseDetail.add(rs.getString("CID")+"-"+rs.getString("CNAME"));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ConProvider.cleanUp(rs,statement,connection);
			}
		}
		finally {
			ConProvider.cleanUp(rs,statement,connection);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+coursesFromCourseDetail);
		return coursesFromCourseDetail;
	}
	
	public static int insertAssesmenDetails(String Assesments_Name, String Exam_Duration,String Course_Id, String fileNFile_name) {
		int status;
		status = 0;
		try {
			try {
				connection = ConProvider.getConnection();
				String query = "insert into Assesment_Details(Assesment_Id,Assesments_Name,Exam_Duration,Course_Id,File_name,Asse_Date) values(Ass_Id.NEXTVAL,?,?,?,?,?)";
				ps = connection.prepareStatement(query);
				ps.setString(1, Assesments_Name);
				ps.setString(2, Exam_Duration);
				ps.setString(3, Course_Id);
				ps.setString(4, fileNFile_name);
				ps.setDate(5, Formatter.getCurrentDate());
				status = ps.executeUpdate();
			}
			catch (Exception e) {
				System.out.println(e);
				ConProvider.cleanUp((Statement)ps, (Connection)connection);
			}
		}
		finally {
			ConProvider.cleanUp((Statement)ps, (Connection)connection);
		}
		return status;
	}
	public static AssesmentsDetailsDao assesmentSDetails (String aaId,String cou_id) throws SQLException{
		AssesmentsDetailsDao assesmentsDao = new AssesmentsDetailsDao();
		try {
			connection = ConProvider.getConnection();
			@SuppressWarnings("unused")
			String query = "Select * from Assesment_Details where Assesment_Id =? and Course_Id = ?";
			ps.setString(1, aaId);
			ps.setString(1, cou_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				assesmentsDao.setAssTitle(rs.getString("Assesments_Name"));
				assesmentsDao.setAssDuration(rs.getString("Exam_Duration"));
			}
		} finally {
			ConProvider.cleanUp(rs,ps,connection);
		}
		return assesmentsDao;
	}
	
	public static List  getAssid(String fileName) {
		List<String> courseId = new ArrayList<String>();
		try {
			
			try {
				connection = ConProvider.getConnection();
				ps=null;
				rs=null;
				//statement = ReteriveQuestion.connection.createStatement();
				ps = connection.prepareStatement("select *  from Assesment_Details where FILE_NAME = ? and Rownum =1");
				ps.setString(1, fileName);
				rs=ps.executeQuery();
				while (rs.next()) {
					//AssesmentDO assesment = new AssesmentDO();
					courseId.add(rs.getString("ASSESMENT_ID"));
					courseId.add(rs.getString("COURSE_ID"));
					courseId.add(rs.getString("EXAM_DURATION"));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ConProvider.cleanUp((ResultSet)rs, (Statement)statement, (Connection)AssesmentDao.connection);
			}
		}
		finally {
			ConProvider.cleanUp(rs,ps,connection);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+courseId );
		return courseId;
	}
	
	public static List  getAssesmentDetailsById(String id) {
		List<String> courseBetailsById = new ArrayList<String>();
		try {
			
			try {
				rs =null;
				connection = ConProvider.getConnection();
				ps = connection.prepareStatement("select a.assesment_id as Ass_Id,a.assesments_name as Ass_Name,a.exam_duration as Ass_Duration,b.questionnumber as Max_Qno from assesment_details a left outer join assesments b on (a.assesment_id=b.ass_id) where a.assesment_id= ? and b.questionnumber=(select max(questionnumber) from assesments)");
				ps.setString(1, id);
				rs=ps.executeQuery();
				if (rs.next()) {
					//AssesmentDO assesment = new AssesmentDO();
					courseBetailsById.add(rs.getString("Ass_Id"));
					courseBetailsById.add(rs.getString("Ass_Name"));
					courseBetailsById.add(rs.getString("Ass_Duration"));
					courseBetailsById.add(rs.getString("Max_Qno"));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				ConProvider.cleanUp((ResultSet)rs, (Statement)statement, (Connection)AssesmentDao.connection);
			}
		}
		finally {
			ConProvider.cleanUp((ResultSet)rs, (Statement)statement, (Connection)AssesmentDao.connection);
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+courseBetailsById );
		return courseBetailsById;
	}
	   public ArrayList<AssesmentsDetailsDao> getAllAssesments() throws SQLException {
	        ArrayList<AssesmentsDetailsDao> assesmentsDetails = new ArrayList<AssesmentsDetailsDao>();
	        
	            try {
	                connection = ConProvider.getConnection();
	                statement = AssesmentDao.connection.createStatement();
	                rs = statement.executeQuery("select ass_id,ass_name,ass_duration,ass_courseId,max(max_qno) as max_qno from (SELECT a.assesment_id AS Ass_Id,a.assesments_name   AS Ass_Name,a.exam_duration     AS Ass_Duration,a.course_id     AS ass_courseId,b.questionnumber    AS max_qno  FROM assesment_details a LEFT OUTER JOIN assesments b ON (a.assesment_id  =b.ass_id)) group by ass_id,ass_name,ass_duration,ass_courseId order by ass_id");
	                while (AssesmentDao.rs.next()) {
	                	AssesmentsDetailsDao assesmentsDetailsDao = new AssesmentsDetailsDao();
	                	assesmentsDetailsDao.setAssesmentsId(AssesmentDao.rs.getString("ass_id"));
	                	assesmentsDetailsDao.setAssTitle(AssesmentDao.rs.getString("ass_name"));
	                	assesmentsDetailsDao.setAssDuration(AssesmentDao.rs.getString("ass_duration"));
	                	assesmentsDetailsDao.setCourseId(AssesmentDao.rs.getString("ass_courseId"));
	                	assesmentsDetailsDao.setTotalQue(AssesmentDao.rs.getString("max_qno"));
	                    assesmentsDetails.add(assesmentsDetailsDao);
	                }
	            
	          
	        }
	        finally {
	            ConProvider.cleanUp((ResultSet)AssesmentDao.rs, (Statement)AssesmentDao.statement, (Connection)AssesmentDao.connection);
	        }
	        return assesmentsDetails;
	    }
}


