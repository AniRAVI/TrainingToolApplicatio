<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.inputform {
	float: left;
	margin-left: 10%;
	margin-top: 1%;
	height: 40% !important;
	width: 450px;
	border: 1px solid pink;
	border-radius: 10px;
	padding: 10px;
}

.inputform table tr td input, textarea, select {
	width: 200px;
	margin-top: 2%;
}

#gender1, #gender2 {
	width: 10px;
}

#submit {
	margin-left: 100px;
	width: 100px;
}

#reset {
	width: 100px;
}

.design {
	background-color: red;
	color: white;
	padding-left: 100px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
	<jsp:include page="rightMenu.jsp" />
	<div class="inputform">
		<h2 class="design">Manage User Role</h2>
		<form action="UserController?action=updateUsersRecords" method="post">
			<%
				String action = request.getParameter("action");
				System.out.println(action);
			%>
			<%
				if (action.equalsIgnoreCase("manageUsersRecords")) {
			%>
			<table>
				<tr>
					<td>User Id:</td>
					<td><input type="text" name="userId"
						value="<c:out value="${user.userid}" />" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"
						value="<c:out value="${user.username}" />" readonly="readonly" />
					</td>
				</tr>
					<tr>
					<td>User Role:</td>
					<td><select name="userRole">
							<option>Select User Role</option>
							<option>Team Lead</option>
							<option>Team Manger</option>
							<option>DM</option>
					</select></td>
					<td>${user.userRole}</td>
				</tr>
				<tr>
					<td>User Sub Role:</td>
					<td><select name="userSubRole">
							<option>Select User Sub Role</option>
							<option>Entry Level</option>
							<option>PO</option>
							<option>AD</option>
							<option>AS</option>
					</select></td>
					<td>${user.userSubRole}</td>
				</tr>
				<tr>
					<td>User Access:</td>
					<td><select name="userAccess">
							<option>ACTIVE</option>
							<option>DEACTIVE</option>
					</select></td>
					<td>"${user.userAccess}"</td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="2"><input id="submit" type="submit"
						value="Update" /></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.html" />
</body>
</html>