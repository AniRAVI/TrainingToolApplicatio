package com.assesment.dom;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlConvertor {

	public static void ConvertTOXml(String fileName) {
		try {
			
			@SuppressWarnings("unchecked")
			List<String> assesmentId = AssesmentDao.getAssid(fileName);
			String ass_Id = assesmentId.get(0);
			System.out.println("Programe Start");
			List<?> assDetailsById = AssesmentDao.getAssesmentDetailsById(ass_Id);
			List<AssesmentDO>custlist=AssesmentDao.getAllQuestion(ass_Id);
			Document doc=DOMUtil.createDocument();
			
			Element quizTest=doc.createElement("quiz");
			doc.appendChild(quizTest);
			
			Element title=DOMUtil.createMyElement(doc, "title", assDetailsById.get(1).toString());
			quizTest.appendChild(title);
			
			Element totalQuestions=DOMUtil.createMyElement(doc, "totalQuizQuestions", assDetailsById.get(3).toString());
			quizTest.appendChild(totalQuestions);
			
			Element testDuration=DOMUtil.createMyElement(doc, "quizDuration", assDetailsById.get(2).toString());
			quizTest.appendChild(testDuration);
			
			Element root=doc.createElement("questions");
			quizTest.appendChild(root);


			for (AssesmentDO cto : custlist) {
				Element cust=doc.createElement("question");


				Element quele=DOMUtil.createMyElement(doc, "quizquestion", cto.getQuestion());
				cust.appendChild(quele);

				Element ansOneEle=DOMUtil.createMyElement(doc, "answer", cto.getOptOne());
				cust.appendChild(ansOneEle);

				Element ansTwoEle=DOMUtil.createMyElement(doc, "answer", cto.getOptTwo());
				cust.appendChild(ansTwoEle);

				Element ansThreeEle=DOMUtil.createMyElement(doc, "answer", cto.getOptThree());
				cust.appendChild(ansThreeEle);

				Element ansFourEle=DOMUtil.createMyElement(doc, "answer", cto.getOptFour());
				cust.appendChild(ansFourEle);

				Element correctEle=DOMUtil.createMyElement(doc, "correct", cto.getCorrAnswer());
				cust.appendChild(correctEle);

				root.appendChild(cust);


			}
			System.out.println("XML CREATED ");
//C:\Tomcat\webapps\video
			DOMUtil.printTOFile(doc, "C://Tomcat//webapps//video//"+assesmentId.get(1).toString()+".xml");

			//DOMUtil.printTOFile(doc, "C://Tomcat 7.0//webapps//video//"+assesmentId.get(1).toString()+".xml");
			System.out.println("XML CREATED DONE");



		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Programe END");

	}

}

