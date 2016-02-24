
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="ISO-8859-1">
<style type="text/css">
.inputform {
	float: left;
	margin-left: 0%;
	margin-top: -.5%;
	width: 500px !important;
	border: 1px solid pink;
	border-radius: 10px;
	padding: 10px;
}

.inputform table tr td input,textarea,select {
	width: 200px;
}

#register {
	margin-left: 100px;
	width: 100px;
	margin-top: 10%;
}

#login {
	margin-left: 100px;
	width: 100px;
	margin-top: 10%;
}

.design {
	background-color: red;
	color: white;
	padding-left: 38%;
}

#password {
	background-color: yellow;
	width: 120%;
	margin-top: 10%
}

#email {
	background-color: yellow;
	width: 120%;
	margin-top: 10%
}
</style>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
	<jsp:include page="rightMenu.jsp" />
	<div class="inputform" style="float: left;">
		<h2 class="design">EDIT COURSE DETAILS</h2>
		<form method="POST" action='CourseController'>
			<%
				String action = request.getParameter("action");
				System.out.println(action);
			%>
			<%
				if (action.equalsIgnoreCase("edit")) {
			%>
			<table>
				<tr>
					<td>Course ID:</td>
					<td><input type="text" id="email" name="cid"
						value="<c:out value="${course.cid}" />" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Course Name:</td>
					<td><input type="text" id="email" name="cname"
						value="<c:out value="${course.cname}" />" /></td>
				</tr>
				<tr>
					<td>Course Min Duration:</td>
					<td><input id="password" type="text" name="cminDuration"
						value="<c:out value="${course.cmin}" />" /></td>
				</tr>
				<tr>
					<td>Course Max Duration:</td>
					<td><input id="password" type="text" name="cmaxDuration"
						value="<c:out value="${course.cmax}" />" /></td>
				</tr>
				<tr>
					<td>Course Author:</td>
					<td><input id="password" type="text" name="cauthor"
						value="<c:out value="${course.cfileName}" />" /></td>
				</tr>
				<tr>
					<td>USER:</td>
					<td><select name="userRole">
							<option>Test Analyst</option>
							<option>Manager</option>
							<option>Team Lead</option>
					</select></td>
					<td>${course.courseRoleId}</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td><input id="login" type="submit" value="UPDATE" /></td>
					<td><input id="register" type="reset" value="Reset" /></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.html" />
</body>
</html>
