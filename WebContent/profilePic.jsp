<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#profilePictures {
    width: 630px;
}

.profilePicture {
    float: left;
    width: 200px;
    margin: 5px;
}
</style>
</head>
<body>
<div id="profilePictures">
    <c:forEach items="${profilePictures}" var="profilePicture">
        <div class="profilePicture">
            <img src="${profilePicture.url}" width="200" height="300" />
            <br /><c:out value="${profilePicture.description}" />
        </div>
    </c:forEach>
</div>
</body>
</html>