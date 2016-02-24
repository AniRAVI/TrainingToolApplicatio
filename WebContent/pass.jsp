<%@ page import="java.io.*,java.sql.*" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
		String count = request.getParameter("ver");
		out.println(count);
		out.println("<img style='border:5px solid black;position:absolute;bottom:41px!important; left:141px' width='1028px' height='550px'  src=displayphoto?name=" +count+ "></img> <p/>");
%>