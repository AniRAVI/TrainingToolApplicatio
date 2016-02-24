<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
h4{
	color: red;
    margin-left: 32px;
    margin-top: 0;
    position: relative;
}
#abcd{
	position:absolute;
	top:8px;
	left:512px;
	font-size: 37px;
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
  
   <title>AT & T  TUTORIALS</title>
 
     <script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
</script>

<script language="javaScript">
function verify()
{
	  alert('Kindly comlete progress courses');
		return false;
}
</script>
</head>
<body onload="startTime()">
<table>
<tr>
<td>Date:</td>
<td id="demo"></td>
</tr>
<tr>
<td>Time:</td>
<td id="txt"></td>
</tr>
<!-- <tr><h1 id="abc" >AT & T Tutorials</h1> </tr>-->
</table>
<script>
var d = new Date();
document.getElementById("demo").innerHTML = d.toDateString();
</script>
<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}'><span>Home</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Login</span></a></li>
   <li><a href='#'><span>Register</span></a></li>
      <li><a href='AssesmentController?action=statusOfResult'><span>Status</span></a></li>
      <li class='#'><a href='#'><span>Submit a Question</span></a></li>
   <li class='#'><a href='#'><span>Feedback</span></a></li>
   <li><a href='#'><span>Contact us</span></a></li>
</ul>
</div>

<c:if test='${not empty sessionScope.name}'>
<div id ="abcd">Tower G Training</div>
<div style="position:absolute;top:20px;left:1070px">
<span><u>${sessionScope.userRole}</u> </span><a href="#" class="button username">${sessionScope.name}</a>
</div>

<div style="position:absolute;top:22px;left:1300px">
<a href='LogoutServlet'>Logout</a>
</div>

</c:if>

<div style="position:absolute;left:120px;top:106px">
<table cellpadding="0" cellspacing="50">
 
<%
String  countManNumber = session.getAttribute("courseMan").toString();
int i = Integer.parseInt(countManNumber);
System.out.println("********"+i);
int j = i/5+1;
int count = 0;
%>
<%out.print("<tr>"); %>
<c:forEach items="${manCourse}" var="manCourse">
 <%count++; %>
 <%String countStatus = session.getAttribute("countStatus").toString() ;%>
  <%int countNmber = Integer.parseInt(countStatus);%>
  <%System.out.println("++++++++++++++++++++++"+countNmber); %>
 <%if(count<countNmber+2){%>
<c:choose>
		     <c:when test="${manCourse.mfileExt=='pptx'}">
		     <td ><a href="CourseController?action=launch&cid=<c:out value="${manCourse.mcid} &cname= ${manCourse.mcname}"/>"><img height="120" width="120" style="border: 2px solid green;"src="${pageContext.request.contextPath}/images/Assesment_PPt.png"/></a><h4><c:out value="${manCourse.mcname}" />*</h4></td>
		     </c:when>
			<c:otherwise>
			 <td ><a href="CourseController?action=launchVideo&fileName=<c:out value="${manCourse.mfileName} &cid=${manCourse.mcid} &cname=${manCourse.mcname}"/>"><img height="120" width="120" style="border: 2px solid green;" src="${pageContext.request.contextPath}/images/Asses_Video.png" /></a><h4><c:out value="${manCourse.mcname}" />*</h4></td>
			</c:otherwise>
			</c:choose>
 <%} else {%>
    <c:choose>
     <c:when test="${manCourse.mfileExt=='pptx'}">
<%-- <td id = "t1"  onClick="verify()" ><a href="CourseController?action=launch&cid=<c:out value="${manCourse.mcid} &cname= ${manCourse.mcname}"/>"><img height="120" width="120" src="${pageContext.request.contextPath}/images/Assesment_PPt.png"/></a><h4><c:out value="${manCourse.mcname} " />*</h4></td> --%>
      <td id = "t1"  onClick="verify()" ><a href="#"><img height="120" width="120" style="border: 1px solid red;" src="${pageContext.request.contextPath}/images/Assesment_PPt.png"/></a><h4><c:out value="${manCourse.mcname} " />*</h4></td>
       </c:when>
	<c:otherwise>
<%-- 	 <td id="t2" onClick="verify()"><a href="CourseController?action=launchVideo&fileName=<c:out value="${manCourse.mfileName} &cid=${manCourse.mcid} &cname=${manCourse.mcname}"/>"><img height="120" width="120" src="${pageContext.request.contextPath}/images/Asses_Video.png" /></a><h4><c:out value="${manCourse.mcname}" />*</h4></td> --%>	
 	 <td id="t2" onClick="verify()"><a href="#"><img height="120" width="120" style="border: 1px solid red;" src="${pageContext.request.contextPath}/images/Asses_Video.png" /></a><h4><c:out value="${manCourse.mcname}" />*</h4></td>
 </c:otherwise>
	</c:choose>
	<%} %>
<%if(count == 6){
	System.out.println("Count In If Block"+count);
	count=0;
	%>
	<%out.print("</tr>"); %>
	<%}%>
<%System.out.println(" Count  For Loop"+count); %>
 </c:forEach>
 <%
String  countAviNumber = session.getAttribute("courseAvi").toString();
int k = Integer.parseInt(countAviNumber);
System.out.println("********"+i);
int l = k/5+1;
int countA = 0;
%>
 <%out.print("<tr>"); %>
<c:forEach items="${aviCourse}" var="aviCourse">
 <%countA++; %>
    <c:choose>
     <c:when test="${aviCourse.afileExt=='pptx'}">
     <td><a href="CourseController?action=launch&cid=<c:out value="${aviCourse.acid} &cname= ${aviCourse.acname}"/>"><img height="120" width="120" src="${pageContext.request.contextPath}/images/Assesment_PPt.png"/></a><h4><c:out value="${aviCourse.acname}" /></h4></td>
     </c:when>
	<c:otherwise>
	 <td><a href="CourseController?action=launchVideo&fileName=<c:out value="${aviCourse.afileName} &cid=${aviCourse.acid} &cname=${aviCourse.acname}"/>"><img height="120" width="120" src="${pageContext.request.contextPath}/images/Asses_Video.png" /></a><h4><c:out value="${aviCourse.acname}" /></h4></td>
	</c:otherwise>
	</c:choose>
<%if(countA == 6){
	System.out.println("Count In If Block"+countA);
	countA=0;
	%>
	<%out.print("</tr>"); %>
	<%}%>
<%System.out.println(" Count  For Loop"+countA); %>
 </c:forEach>
</table>
</div>
</body>
</html>
