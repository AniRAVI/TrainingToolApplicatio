package com.quiz.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.course.dao.ResultRecordDao;
import com.course.dao.ResultRecordDo;
import com.quiz.Exam;
import com.quiz.QuizQuestion;

@WebServlet("/exam")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean finish=false;
		String started = null;
		HttpSession session=request.getSession();		
		try
		{
			if(session.getAttribute("currentExam")==null)
			{  session=request.getSession(); 	
			String selectedExam=(String)request.getSession().getAttribute("exam"); 
			System.out.println("Setting Exam "+selectedExam);	
			Exam newExam=new Exam(selectedExam);
			session.setAttribute("currentExam",newExam);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a");
			Date date = new Date();
			 started=dateFormat.format(date);
			session.setAttribute("started",started);
			}

		}catch(Exception e){e.printStackTrace();}

		Exam exam=(Exam)request.getSession().getAttribute("currentExam");		

		if(exam.currentQuestion==0){	
			exam.setQuestion(exam.currentQuestion);
			QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			session.setAttribute("quest",q);
		}

		String action=request.getParameter("action");

		System.out.println("Value of Action "+action+"   "+request.getParameter("minute"));
		int minute=-1;
		int second=-1;
		if(request.getParameter("minute")!=null)
		{			
			minute=Integer.parseInt(request.getParameter("minute"));
			second=Integer.parseInt(request.getParameter("second"));
			request.getSession().setAttribute("min",request.getParameter("minute") );
			request.getSession().setAttribute("sec",request.getParameter("second") );
		}
		String radio=request.getParameter("answer");
		int selectedRadio=-1;
		exam.selections.put(exam.currentQuestion, selectedRadio);
		if("1".equals(radio))
		{
			selectedRadio=1;
			exam.selections.put(exam.currentQuestion, selectedRadio);
			System.out.println("You selected "+selectedRadio);
		}
		else if("2".equals(radio))
		{
			selectedRadio=2;
			exam.selections.put(exam.currentQuestion, selectedRadio);
			System.out.println("You selected "+selectedRadio);
		}
		else if("3".equals(radio))
		{
			selectedRadio=3;
			exam.selections.put(exam.currentQuestion, selectedRadio);
			System.out.println("You selected "+selectedRadio);
		}
		else if("4".equals(radio))
		{
			selectedRadio=4;
			exam.selections.put(exam.currentQuestion, selectedRadio);
			System.out.println("You selected "+selectedRadio);
		}


		if("Next".equals(action)){
			exam.currentQuestion++;
			exam.setQuestion(exam.currentQuestion);
			QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
			session.setAttribute("quest",q);
		}
		else if("Previous".equals(action))
		{   System.out.println("You clicked Previous Button");
		exam.currentQuestion--;
		exam.setQuestion(exam.currentQuestion);
		QuizQuestion q=exam.questionList.get(exam.currentQuestion);	
		session.setAttribute("quest",q);

		}
		else if("Finish Exam".equals(action)||( minute==0 && second==0))
		{  
			finish=true;
		int result=exam.calculateResult(exam);	
		System.out.println("User Role "+session.getAttribute("userRole"));
		System.out.println("User Id "+session.getAttribute("email"));
		System.out.println("User Name"+session.getAttribute("name"));
		System.out.println("Course Id"+session.getAttribute("cid"));
		System.out.println("Marks  "+result);
		request.setAttribute("result",result);
		
		List<Integer> attemptStatus = ResultRecordDao.checkNoOfAttemts(session.getAttribute("email").toString(), session.getAttribute("cid").toString());
		if(attemptStatus.size()==0){
			ResultRecordDo resultRecordDo = new ResultRecordDo();
			resultRecordDo.setUserRole(session.getAttribute("userRole").toString());
			if(result>5)
			resultRecordDo.setStatus("Pass");
			else resultRecordDo.setStatus("Fail");
			resultRecordDo.setUserId(session.getAttribute("email").toString());
			resultRecordDo.setUserName(session.getAttribute("name").toString());
			resultRecordDo.setMarks(result);
			resultRecordDo.setNoOfAttempts(1);
			resultRecordDo.setCourseId(session.getAttribute("cid").toString());
			resultRecordDo.setCname(session.getAttribute("cname").toString());
			resultRecordDo.setSubUserRole(session.getAttribute("userSubRole").toString());
			ResultRecordDao.insertResultRecord(resultRecordDo);
			System.out.println("******* Attempt Size  Is Zero  ***** ");
		}else {
			ResultRecordDo resultRecordDo = new ResultRecordDo();
			resultRecordDo.setUserRole(session.getAttribute("userRole").toString());
			if(attemptStatus.get(1)>result){
				if(result>5)
					resultRecordDo.setStatus("Pass");
					else resultRecordDo.setStatus("Fail");
					resultRecordDo.setUserId(session.getAttribute("email").toString());
					resultRecordDo.setUserName(session.getAttribute("name").toString());
					resultRecordDo.setMarks(attemptStatus.get(1));
					resultRecordDo.setNoOfAttempts(attemptStatus.get(0)+1);
					resultRecordDo.setCourseId(session.getAttribute("cid").toString());
					resultRecordDo.setCname(session.getAttribute("cname").toString());
					ResultRecordDao.updateResultRecords(resultRecordDo);
					System.out.println("******* Attempt Size  Is Greate Then Zero   ***** ");

					
			}else{
				if(result>5)
					resultRecordDo.setStatus("Pass");
					else resultRecordDo.setStatus("Fail");
					resultRecordDo.setUserId(session.getAttribute("email").toString());
					resultRecordDo.setUserName(session.getAttribute("name").toString());
					resultRecordDo.setMarks(result);
					resultRecordDo.setNoOfAttempts(attemptStatus.get(0)+1);
					resultRecordDo.setCourseId(session.getAttribute("cid").toString());
					resultRecordDo.setCname(session.getAttribute("cname").toString());
					ResultRecordDao.updateResultRecords(resultRecordDo);
					
					System.out.println("******* Attempt Size  Is Greate Then Five   ***** ");

			}
		}

		request.getSession().setAttribute("currentExam",null);
		request.getRequestDispatcher("/WEB-INF/jsps/result.jsp").forward(request,response);
		}
		if(finish!=true){
			request.getRequestDispatcher("/WEB-INF/jsps/exam.jsp").forward(request,response);
		}

	}

}
