<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="ISO-8859-1">
<title>Upload Assesment</title>
<link href="cssfile/assesments.css" rel="stylesheet" type="text/css"/>
<head>
<script type="text/javascript" src="javascript/utill.js"></script>
</head>
<body>
	<div class="inputform" style="float: left;">
		<h2 class="design">Edit Assesment</h2>
		<form action="InsertAssesmentDetail" method="post" enctype="multipart/form-data">
		<table>
		<tr id =coursename>
		<td >Assesments Name:</td>
		<td id="coursenametestBox"><input type="text" id="email" name="assesmentName"/>
		</td>
		</tr>
		<tr id = courseauthor>
		<td>Time Limit</td>
		<td id ="courseauthorTextBox"><input id="password" type="text" name="timeLimit"
		/></td>
		</tr>
		<tr id= courseFIle>
		<td>File:</td>
		<td id =courseFIlebox><input id="password" type="file" name="file" /></td>
		</tr>
		<tr id =courseIdLabel>
		<td>Course Id :</td>
		<td>
		<select  id="courseId" name ="courseId">
				<option >Select Course Id</option>
				<c:forEach var="x" items="${requestScope.courseId}">
							<option >${x}</option>
				</c:forEach>
		</select>
		</td>
		</tr>
		<tr id=button>
		<td><input id="register" type="reset" value="Reset" />
		</td>
		<td><input id="login" type="submit" value="Submit" />
		</td>
		</tr>
		</table>
		</form>
	</div>
</body>
</html>
