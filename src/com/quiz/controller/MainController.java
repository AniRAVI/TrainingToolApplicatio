package com.quiz.controller;

import java.io.IOException;

import javax.lang.model.element.Element;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.quiz.CreateDOM;

@WebServlet("/takeExam")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Take Exam");
		System.out.println(request.getContextPath());
		String applicationContextPath = request.getContextPath();
		if (request.getRequestURI().equals(
				applicationContextPath + "/takeExam")) {
			request.getSession().setAttribute("currentExam", null);
			request.getSession().setAttribute("totalNumberOfQuizQuestions",null);
			request.getSession().setAttribute("quizDuration",null);
			request.getSession().setAttribute("min",null);
			request.getSession().setAttribute("sec",null);

			String exam = request.getParameter("test");
			System.out.println("****** EXAM ******"+exam);
			request.getSession().setAttribute("exam", exam);
			RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsps/quizDetails.jsp");
				Document document=null;
				try{
					document=CreateDOM.getDOM(exam);

					//request.getSession().setAttribute("totalNumberOfQuizQuestions",document.getElementsByTagName("totalQuizQuestions").item(0).getTextContent());
					//request.getSession().setAttribute("quizDuration",document.getElementsByTagName("quizDuration").item(0).getTextContent());
					//request.getSession().setAttribute("min",document.getElementsByTagName("quizDuration").item(0).getTextContent());
					request.getSession().setAttribute("totalNumberOfQuizQuestions",document.getElementsByTagName("totalQuizQuestions").item(0).getTextContent());
					request.getSession().setAttribute("quizDuration",document.getElementsByTagName("quizDuration").item(0).getTextContent());
					request.getSession().setAttribute("min",document.getElementsByTagName("quizDuration").item(0).getTextContent());
					
					
					request.getSession().setAttribute("sec",0);

					System.out.println("Minutes "+request.getSession().getAttribute("min")+"---------------- sec   "+request.getSession().getAttribute("sec"));
				}				
				catch(Exception e){e.printStackTrace();}
				dispatcher.forward(request, response);
			}
		} 

	}


