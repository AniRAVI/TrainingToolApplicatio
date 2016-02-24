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
#abc{
	color: black;
    position: absolute;
    left:565px;
    bottom:596px;
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
#statusReport{
position:relative;
top:18px;
left:190px;

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
   <title>AT & T TUTORIALS</title>
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
</table>
<h1 id="abc" >AT & T Tutorials</h1>
<script>
var d = new Date();
document.getElementById("demo").innerHTML = d.toDateString();
</script>
<div id='cssmenu'>
<ul>
   <li class=''><a href='NormalUsers'><span>Home</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Login</span></a></li>
   <li><a href='#'><span>Register</span></a></li>
      <li><a href='AssesmentController?action=statusOfResult'><span>Status</span></a></li>
      <li class='#'><a href='#'><span>Submit a Question</span></a></li>
   <li class='#'><a href='#'><span>Feedback</span></a></li>
   <li><a href='#'><span>Contact us</span></a></li>
</ul>
</div>

<c:if test='${not empty sessionScope.name}'>
<div style="position:absolute;top:20px;left:1070px">
<span><u>${sessionScope.userRole}</u> </span><a href="#" class="button username">${sessionScope.name}</a>
</div>
<div style="position:absolute;top:22px;left:1300px">
<a href='LogoutServlet'>Logout</a>
</div>
</c:if>

<div style="position:absolute;left:120px;top:106px">
<table id ="statusReport" border = 1 >

		<thead>
		<th>Progress Course</th>
			<tr>
				<th>SL.NO</th>
				<th>COURSE ID</th>
				<th>COURSES NAME</th>
				<th>STATUS</th>
				<th>ATTEMPT</th>
     			<th>MARKS</th>
				<th>DATE</th>
			</tr>
		</thead>
		<%int count = 0; %>
			<c:forEach items="${statusOfResult}" var="statusOfResult">
			<%count++; %>
				<tr>			
				    <td><%=count%></td>
					<td><c:out value="${statusOfResult.cid}" /></td>
					<td><c:out value="${statusOfResult.cname}" /></td>
					<td><c:out value="${statusOfResult.status}" /></td>
					<td><c:out value="${statusOfResult.noOfAttempts}" /></td>				
					<td><c:out value="${statusOfResult.marks}" /></td>
					<td><c:out value="${statusOfResult.date}" /></td>
				</tr>
			</c:forEach>
			<thead>
		<th>Avilable Course</th>
			<tr>
				<th>SL.NO</th>
				<th>COURSE ID</th>
				<th>COURSES NAME</th>
				<th>COURSES AUTHOR</th>
				<th>MIN DUR</th>
				<th>FILE EXTENSION</th>
				<th>DATE</th>
			</tr>
		</thead>
		<tbody>
		<%int countAv = 0; %>
			<c:forEach items="${aviCourse}" var="aviCourse">
			<%countAv++; %>
				<tr>			
				    <td><%=countAv%></td>
					<td><c:out value="${aviCourse.acid}" /></td>
					<td><c:out value="${aviCourse.acname}" /></td>
					<td><c:out value="${aviCourse.acauthor}" /></td>
					<td><c:out value="${aviCourse.aminDuration}" /></td>				
					<td><c:out value="${aviCourse.afileExt}" /></td>
					<td><c:out value="${aviCourse.adate}" /></td>
				</tr>
			</c:forEach>
			
			<thead>
		<th>Mandatory Course</th>
			<tr>
				<th>SL.NO</th>
				<th>COURSE ID</th>
				<th>COURSES NAME</th>
				<th>COURSES AUTHOR</th>
				<th>MIN DUR</th>
				<th>FILE EXTENSION</th>
				<th>DATE</th>
			</tr>
		</thead>
		<tbody>
		<%int countMc = 0; %>
			<c:forEach items="${manCourse}" var="manCourse">
			<%countMc++; %>
				<tr>			
				    <td><%=countMc%></td>
					<td><c:out value="${manCourse.mcid}" /></td>
					<td><c:out value="${manCourse.mcname}" /></td>
					<td><c:out value="${manCourse.mcauthor}" /></td>
					<td><c:out value="${manCourse.mminDuration}" /></td>				
					<td><c:out value="${manCourse.mfileExt}" /></td>
					<td><c:out value="${manCourse.mdate}" /></td>
				</tr>
			</c:forEach>
			
		</tbody>
</table>
</div>
</body>
</html>
