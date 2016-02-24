<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All COURSES</title>
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
                                <th>TL_EL</th>
                                <th>TL_PO</th>
                                <th>TL_AS</th>
                                <th>TL_AD</th>
                                <th>TM_EL</th>
                                <th>TM_PO</th>
                                <th>TM_AD</th>
                                <th>TM_AS</th>
                
				<th>CREATED DATE</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${course}" var="course">
                <tr>
                    <td><c:out value="${course.CID}" /></td>
                    <td><c:out value="${course.CNAME}" /></td>
				    <td><c:out value="${course.COURSEFILENAME}" /></td>
				    <td><c:out value="${course.CAUTHOR}" /></td>
                    <td><c:out value="${course.TL_ENTRY_LEVEL}" /></td>
                    <td><c:out value="${course.TL_PO}" /></td>
                    <td><c:out value="${course.TL_AD}" /></td>
                    <td><c:out value="${course.TL_AS}" /></td>
                    <td><c:out value="${course.TM_EL}" /></td>
                    <td><c:out value="${course.TM_PO}" /></td>
                    <td><c:out value="${course.TM_AD}" /></td>
                    <td><c:out value="${course.TM_AS}" /></td>
                    
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${course.COURSEDATE}" /></td>
                    <td><a href="CourseController?action=edit&userId=<c:out value="${course.CID}"/>">Update</a></td>
                    <td><a href="CourseController?action=delete&userId=<c:out value="${course.CID}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UserController?action=insert">Add User</a></p>
        <jsp:include page="footer.html" />
    </body>
</html>