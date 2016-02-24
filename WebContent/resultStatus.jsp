<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result Status</title>
<style type="text/css">
th {
	background-color:#0099CC;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
<jsp:include page="rightMenu.jsp" />
    <table border=1>
        <thead>
            <tr bgcolor ="yellow">
                <th >USER ID</th>
                <th>NAME</th>
                <th>STATUS</th>
                 <th>MARKS</th>
                 <th>NO OF ATTEMPTS</th>
                 <th>COURSE ID</th>
                  <th>DATE</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${resultStatus}" var="resultStatus">
                <tr>
                    <td><c:out value="${resultStatus.userId}" /></td>
                    <td><c:out value="${resultStatus.userName}" /></td>
                    <td><c:out value="${resultStatus.status}" /></td>
                    <td><c:out value="${resultStatus.marks}" /></td>
                    <td><c:out value="${resultStatus.noOfAttempts}" /></td>
                    <td><c:out value="${resultStatus.courseId}" /></td>
                     <td><c:out value="${resultStatus.sDate}" /></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
    <jsp:include page="footer.html" />
    </body>
</html>
