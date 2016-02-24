<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <style type="text/css">
body {
	background: url("${pageContext.request.contextPath}/images/background.jpg");
}
h4{
	color: red;
    margin-left: 32px;
    margin-top: 0;
    position: relative;
}
#abcd{
	position:absolute;
	top:8px;
	left:512px;
	font-size: 37px;
}
.button {
	padding: 10px 15px;
	font-size: 14px;
	line-height: 100%;
	text-shadow: 0 1px rgba(0, 0, 0, 0.4);
	color: #fff;
	
	vertical-align: middle;
	text-align: center;
	cursor: pointer;
	font-weight: bold;
	transition: background 0.1s ease-in-out;
	-webkit-transition: background 0.1s ease-in-out;
	-moz-transition: background 0.1s ease-in-out;
	-ms-transition: background 0.1s ease-in-out;
	-o-transition: background 0.1s ease-in-out;
	text-shadow: 0 1px rgba(0, 0, 0, 0.3);
	color: #fff;
	-webkit-border-radius: 40px;
	-moz-border-radius: 40px;
	border-radius: 40px;
	font-family: 'Helvetica Neue', Helvetica, sans-serif;
}

.button, .button:hover, .button:active {
	outline: 0 none;
	text-decoration: none;
        color: #fff;
}

.username {
	background-color: #2ecc71;
	box-shadow: 0px 3px 0px 0px #239a55;
}

</style>
  
   <title>AT & T  TUTORIALS</title>
     <script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('txt').innerHTML =
    h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}
</script>
</head>
<body onload="startTime()">
<table>
<tr>
<td>Date:</td>
<td id="demo"></td>
</tr>
<tr>
<td>Time:</td>
<td id="txt"></td>
</tr>
<!-- <tr><h1 id="abc" >AT & T Tutorials</h1> </tr>-->
</table>
<script>
var d = new Date();
document.getElementById("demo").innerHTML = d.toDateString();
</script>
<div id='cssmenu'>
<ul>
   <li class=''><a href='${pageContext.request.contextPath}'><span>Home</span></a></li>
   <li><a href='${pageContext.request.contextPath}/login'><span>Login</span></a></li>
   <li><a href='#'><span>Register</span></a></li>
      <li><a href='AssesmentController?action=statusOfResult'><span>Status</span></a></li>
      <li class='#'><a href='#'><span>Submit a Question</span></a></li>
   <li class='#'><a href='#'><span>Feedback</span></a></li>
   <li><a href='#'><span>Contact us</span></a></li>
</ul>
</div>

<c:if test='${not empty sessionScope.name}'>
<div id ="abcd">Tower G Training</div>
<div style="position:absolute;top:20px;left:1070px">
<span><u>${sessionScope.userRole}</u> </span><a href="#" class="button username">${sessionScope.name}</a>
</div>

<div style="position:absolute;top:22px;left:1300px">
<a href='LogoutServlet'>Logout</a>
</div>

</c:if>
<div style="position:absolute;left:120px;top:106px">
<table cellpadding="0" cellspacing="50">