<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page language="java" import="com.course.dao.*"%>
  <%@page language="java" import="com.course.model.*"%>
 <%@page import="java.util.ArrayList" %>   
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/images/background.jpg");
}
.button {
	padding: 10px 15px;
	font-size: 14px;
	line-height: 100%;
	text-shadow: 0 1px rgba(0, 0, 0, 0.4);
	color: #fff;
	
	vertical-align: middle;
	text-align: center;
	cursor: pointer;
	font-weight: bold;
	transition: background 0.1s ease-in-out;
	-webkit-transition: background 0.1s ease-in-out;
	-moz-transition: background 0.1s ease-in-out;
	-ms-transition: background 0.1s ease-in-out;
	-o-transition: background 0.1s ease-in-out;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	color: #fff;
	-webkit-border-radius: 40px;
	-moz-border-radius: 40px;
	border-radius: 40px;
	font-family: 'Helvetica Neue', Helvetica, sans-serif;
}

.button, .button:hover, .button:active {
	outline: 0 none;
	text-decoration: none;
        color: #fff;
}

.username {
	background-color: #2ecc71;
	box-shadow: 0px 3px 0px 0px #239a55;
}

</style>
  
   <title>TechQ Online Quiz</title>
</head>
<body>

<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}'><span>Home</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Login</span></a></li>
   <li><a href='${pageContext.request.contextPath}/register'><span>Register</span></a></li>
   <li class='#'><a href='#'><span>Submit a Question</span></a></li>
   <li class='#'><a href='#'><span>Feedback</span></a></li>
   <li><a href='#'><span>Contribute</span></a></li>
   <li><a href='#'><span>Contact us</span></a></li>
</ul>
</div>

<c:if test='${not empty sessionScope.name}'>

<div style="position:absolute;top:70px;left:1089px">
Logged as <a href="#" class="button username">${sessionScope.name}</a>
</div>

<div style="position:absolute;top:70px;left:1300px">
<a href='${pageContext.request.contextPath}/logout'>Logout</a>
</div>

</c:if>

<div style="position:absolute;left:120px;top:60px">
<table cellpadding="0" cellspacing="50">
 <c:forEach items="${courses}" var="course">
<%/* 
String userRole = session.getAttribute("userRole").toString();
String userSubRole = session.getAttribute("userSubRole").toString();
CourseDao dao = new CourseDao();
ArrayList<CourseSecond> courses = new ArrayList<CourseSecond>();
courses = (ArrayList<CourseSecond>)dao.getAllCorsesforNormalUser(userRole, userSubRole);
int i = courses.size(); */

String  countNumber = session.getAttribute("countOfCOurse").toString();
int i = Integer.parseInt(countNumber);
System.out.println("********"+i);
int j = i/5+1;
int count = 0;
%>
<%
for(int k=1;k<=j;k++)
{
	out.print("<tr>");
	for(int l =1;l<=5;l++){
		count++;
		%>
		<td><a href="CourseController?action=launch&cid=<c:out value="${course.cid}"/>"><img height="150" width="150" src="${pageContext.request.contextPath}/images/java.png"/></a></td>
		
		
		<%
	if(count==i)
		{
		break;
		}
	}
	out.println( "</tr> ");

}%>
 </c:forEach>

<%--  <tr>
<td><a href="takeExam?test=java"><img height="200" width="200" src="${pageContext.request.contextPath}/images/java.png"/></a></td>
<td><a href="takeExam?test=javascript"><img height="200" width="200" src="${pageContext.request.contextPath}/images/javascript.png"/></a></td>
<td><a href="takeExam?test=sql"><img height="200" width="200" src="${pageContext.request.contextPath}/images/sql-logo.png"/></a></td>
<td><a href="takeExam?test=python"><img height="200" width="200" src="${pageContext.request.contextPath}/images/python.jpg"/></a></td>
</tr> --%>

<%--  <tr>
<td><a href="takeExam?test=css"><img height="200" width="200" src="${pageContext.request.contextPath}/images/css.jpg"/></a></td>
<td><a href="takeExam?test=php"><img height="200" width="200" src="${pageContext.request.contextPath}/images/php-logo.jpg"/></a></td>
<td><a href="takeExam?test=linux"><img height="200" width="200" src="${pageContext.request.contextPath}/images/logo-linux.png"/></a></td>
<td><a href="takeExam?test=mongodb"><img height="200" width="200" src="${pageContext.request.contextPath}/images/mongodb_logo.png"/></a></td>
</tr>  --%>

</table>
</div>


</body>
</html>
