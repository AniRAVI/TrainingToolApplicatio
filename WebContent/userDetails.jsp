<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<style type="text/css">
th {
	background-color:#0099CC;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
	<jsp:include page="rightMenu.jsp" />
	<table border=1>
		<thead>
			<tr bgcolor="yellow">
				<th >USER ID</th>
				<th>NAME</th>
				<th>ATT ID </th>
				<th>USER ROLE</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.userid}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.userEmail}" /></td>
					<td><c:out value="${user.userRole}" /></td>
					<td><a
						href="UserController?action=editUser&userId=<c:out value="${user.userid}"/>">Update</a>
					</td>
					<%--  <td><a href="UserController?action=deleteUser&userId=<c:out value="${user.userid}"/>">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="footer.html" />
</body>
</html>
