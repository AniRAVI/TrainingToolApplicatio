<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
<style type="text/css">
th {
	background-color: #0099CC;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
	<jsp:include page="rightMenu.jsp" />
	<table border=1>
		<thead>
			<tr>
				<th>COURSE ID</th>
				<th>COURSES NAME</th>
				<th>FILE NAME</th>
				<th>AUTHOR</th>
				<th>DATE</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courses}" var="course">
				<tr>
					<td><c:out value="${course.cid}" /></td>
					<td><c:out value="${course.cname}" /></td>
					<td><c:out value="${course.cfileName}" /></td>
					<td><c:out value="${course.cauthor}" /></td>
					<td><c:out value="20-NOV-2015" /></td>
					
					<td><a
						href="CourseController?action=edit&cid=<c:out value="${course.cid}"/>">Update</a>
					</td>
					<td><a
						href="CourseController?action=delete&cid=<c:out value="${course.cid}"/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="footer.html" />
</body>
</html>
