<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
background: url("${pageContext.request.contextPath}/images/background.jpg");
}
</style>
<title>Video </title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
--><style type="text/css">
<!--
.style4 {
color: #003333;
font-weight: bold;
}
#startAssesment{
left: 650px;
position: relative;
top: 10px;
}
</style>
</head>
<body>
<table width="100%" border="0">
<tr >
<td rowspan="3"></td>
<td bgcolor="#CCCC33"></td>
<td rowspan="3" width="300"><div align="center">
</div></td>
</tr>
<tr>
<td width="710" bgcolor="#CCCC33" align="center" ><span class="style4">Video Player Version 1.0</span> <strong>
<%-- <embed src=" <%= "http://9.182.95.143:2222/video/"+session.getAttribute("videoFile")%>" type="application/x-mplayer2" pluginspage="http://www.microsoft.com/Windows/MediaPlayer/" name="mediaplayer1" ShowStatusBar="true" EnableContextMenu="false" width="700" height="500" autostart="true" loop="false" align="middle" volume="60" ></embed> --%>
 <embed src=" <%= "http://localhost:2222/video/"+session.getAttribute("videoFile")%>" type="application/x-mplayer2" pluginspage="http://www.microsoft.com/Windows/MediaPlayer/" name="mediaplayer1" ShowStatusBar="true" EnableContextMenu="false" width="700" height="500" autostart="true" loop="false" align="middle" volume="60" ></embed>

</strong></td>
<%-- <%System.out.println("Sesssion Id "+session.getAttribute("videoFile")); %>
--%> </tr>
<tr>
<!-- <td bgcolor="#CCCC33"></td>
--> </tr>
</table>
<a id="startAssesment" href="takeExam?test=<%=session.getAttribute("cid").toString()%>">Assesment</a>
</body>
</html>