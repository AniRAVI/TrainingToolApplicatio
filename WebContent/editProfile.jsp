<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.inputform{float:left;margin-left:35%;margin-top:1%;
	height:500px !important;width:450px;border:1px solid pink;border-radius:10px;padding:10px;
}
.inputform table tr td input,textarea,select{width:200px;margin-top:2%;}
#gender1,#gender2{width:10px;}
#submit{margin-left:100px;width:100px;}
#reset{width:100px;}
.design{background-color:red;color:white;padding-left:100px;}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
<jsp:include page="rightMenu.jsp" />
<div class="inputform">
<h2 class="design">Edit Profile</h2>
<form action="UserController?action=updateUsersProfile" method="post">
<% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <% if (action.equalsIgnoreCase("editUser")) {%>
<table>
<tr><td>User Id:</td><td><input type="text" name="userId" value="<c:out value="${user.userid}" />"readonly="readonly" /></td></tr>
<tr><td>Name:</td><td><input type="text" name="name" value="<c:out value="${user.username}" />"readonly="readonly" /></td></tr>
<tr><td>Email:</td><td><input type="text" name="email"  value="<c:out value="${user.userEmail}" />" />@cmailer.com</td></tr>
<tr><td>Gender:</td><td><input id="gender1" type="radio" name="gender" value="male"/>Male 
<input type="radio" id="gender2" name="gender" value="female"/>Female</td></tr>
<tr><td>Password:</td><td><input type="password" name="password" value="<c:out value="${user.password}" />" /></td></tr>
<tr><td>Date Of Birth:</td><td><input type="date" name="dob" value="<c:out value="${user.dob}" />"/>(YYYY-MM-DD)</td></tr>
<tr><td>AddressLine:</td><td><textarea name="addressLine" rows="5" cols="10" ><c:out value="${user.addressLine}" /></textarea></td></tr>
<tr><td>City:</td><td><input type="text" name="city" value="<c:out value="${user.city}" />" /></td></tr>
<tr><td>State:</td><td><input type="text" name="state" value="<c:out value="${user.state}" />" /></td></tr>
<tr><td>Contact:</td><td><input type="text" name="contact" value="<c:out value="${user.contactNumber}" />"/></td></tr>
<%}%>
<tr><td colspan="2"><input id="submit" type="submit" value="Update"/>
<input id="reset" type="reset" value="Clear"/>
</td></tr>
</table>
</form>
</div>
<jsp:include page="footer.html" />
</body>
</html>