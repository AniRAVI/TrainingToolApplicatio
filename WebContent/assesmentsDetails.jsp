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
				<th>Assesment ID</th>
				<th>Assesment NAME</th>
				<th>Time Duration</th>
				<th>Course Id</th>
				<th>Total Question</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${assesments}" var="assesment">
				<tr>
					<td><c:out value="${assesment.assesmentsId}" /></td>
					<td><c:out value="${assesment.assTitle}" /></td>
					<td><c:out value="${assesment.assDuration}" /></td>
					<td><c:out value="${assesment.courseId}" /></td>
					<td><c:out value="${assesment.totalQue}" /></td>
 					<td><a href="takeExam?test=<c:out value="${assesment.courseId}"/>">View</a>	</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<jsp:include page="footer.html" />
</body>
</html>
