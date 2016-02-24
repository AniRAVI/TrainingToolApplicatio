<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th {
	background-color:#0099CC;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
<jsp:include page="rightMenu.jsp" />
    <table border=1>
        <thead>
            <tr>
                <th>COURSE ID</th>
                <th>COURSE NAME</th>
                <th>COURSE AUTHOR</th>
                <th>COURSE MIN TIME</th>
                <th>COURSE FILE NAME</th>
                <th>COURSE DATE</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td><c:out value="${course.cid}" /></td>
                    <td><c:out value="${course.cname}" /></td>
                    <td><c:out value="${course.cauthor}" /></td>
                    <td><c:out value="${course.cmin}" /></td>
                    <td><c:out value="${course.cfileName}" /></td>
                  <c:choose>
 				 <c:when test="${course.fileExtension=='pptx'}">
  				 <td><a href="CourseController?action=launch&cid=<c:out value="${course.cid}"/>">LAUNCH</a></td>
  				</c:when>
 				<c:otherwise>
  				 <%System.out.print("TEST FOR VIDEO") ;%>
  				 <td><a href="CourseController?action=launchVideo&fileName=<c:out value="${course.cfileName}"/>">LAUNCH</a></td>
 				</c:otherwise>
				</c:choose>
                    <td><a href="takeExam?test=<c:out value="${course.cid}"/>">ASSESMENT</a></td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <jsp:include page="footer.html" />
    </body>
</html>
