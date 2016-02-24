<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
background: url("${pageContext.request.contextPath}/images/background.jpg");
}
#startAssesment{
left: 5px;
position: relative;
top:35px;
}
#videoTag{
left: 350px;
position: relative;
top: 10px;
}
</style>
</head>
<body>

	<video id ="videoTag" width="700" height="500" controls>
  <source src="<%= "http://9.182.95.177:2222/video/"+session.getAttribute("videoFile")%>" type="video/mp4">
</video>
<a id="startAssesment" href="takeExam?test=<%=session.getAttribute("cid").toString()%>">Assesment</a>
</body>
</html>