<%@page language="java" import="com.course.*"%>

<html>
<head>
<style>
#err {
	left: 3%;
	position: absolute;
	text-align: center;
	bottom: 3px !important;
}

#AddButton {
	left: 1223px;
	position: absolute;
	text-align: center;
	bottom: 301px!important;
    width: 63px;
    height:74px;
   	border:0px;
   		background:url("images/previous.jpg");
   	
}

#MinButton {
left: 117px;
	position: absolute;
	height: 74px;
	text-align: center;
	bottom: 297px!important;
	width: 63px;
	border:0px;
	   	background:url("images/nextButton.jpg");
	
}

#statusValue {
	left: 563px;
	position: absolute;
	text-align: center;
	bottom:7px!important;
	border: solid 3px blue;
	
}
#startAssesment{
position:relative;
left:600px;
visibility: hidden;
}

#abc {
	position: relative;
	left: 50%;
	top: 180px;
	margin-left: -100px;
	margin-top: -50px;
}
#bodyDesign{
/* 	background:url("images/body.jpg");
 */
}
</style>
<script type="text/javascript">

function isProcess()
{
  var answer = confirm ("Are you  want to Assesment ?");
  if (answer){
              document.myForm.answer.value = "true";  
              document.myForm.submit();
              return true;
    }else return false
}

	function loadXMLDoc() {
		

		var xmlhttp;
		var k = document.getElementById("TextBox").value;
		var urls = "pass.jsp?ver=" + k;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				document.getElementById("err").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", urls, true);
		xmlhttp.send();
	}
</script>
</head>
<%
	String courseId = session.getAttribute("cid").toString();
	String pictureCount = PictureCount.getPictureCount(courseId);
	System.out.println(pictureCount);
	session.setAttribute("maxPictureCount", pictureCount);
%>
<body id ='bodyDesign'>
	<script src="http://code.jquery.com/jquery-1.4.3.min.js"></script>
	<script type="text/javascript">
	</script>
	<script>
		var counter = 1;
		$(document).ready(function() {
			$('#AddButton').click(function() {
				counter = $('#TextBox').val();
				counter++;
				 document.getElementById('statusValue').value = counter-1+" of <%=session.getAttribute("maxPictureCount")%>";
				if (counter > 1) {
					document.getElementById("MinButton").disabled = false;
					document.getElementById('abc').style.visibility = 'hidden';
					document.getElementById('startAssesment').style.visibility = 'hidden';

				}
				if(counter-1 == <%=session.getAttribute("maxPictureCount")%>)
			{
				document.getElementById("AddButton").disabled = false;
				document.getElementById('startAssesment').style.visibility = 'visible';

				alert("Course Over Click on Assesment Buton to Statrt Assesment");
			}
				if(counter -2== <%=session.getAttribute("maxPictureCount")%>)
				{
					document.getElementById("AddButton").disabled = true;
					document.getElementById('startAssesment').style.visibility = 'hidden';
					}
				$('#TextBox').val(counter);
				});
		});
		$(document).ready(function() {
	  		  $('#MinButton').click(function() {
				counter = $('#TextBox').val();
				document.getElementById('statusValue').value = counter- 1+ " of <%=session.getAttribute("maxPictureCount")%>";		counter--;
		if (counter < 1) {
		document.getElementById("MinButton").disabled = true;
		document.getElementById('abc').style.visibility = 'visible';
		//   isProcess();
		
		}
		if (counter - 1 <= <%=session.getAttribute("maxPictureCount")%>) {
	   document.getElementById("AddButton").disabled = false;
		}
		$('#TextBox').val(counter);
		});
		});
	</script>
 		<a id="startAssesment" href="takeExam?test=<%=session.getAttribute("cid").toString()%>">Assesment</a>
		<table id="abc" border=1; align:center>
	     <tr>
			<td>Course</td>
			<td>AVPN</td>
		</tr>
		<tr>
			<td>Course Author</td>
			<td>Srinivas</td>
		</tr>

		<tr>
			<td>Min Duration </td>
			<td>20 Min</td>
		</tr>
		<tr>
			<td>Course Level</td>
			<td>Entry Level</td>
		</tr>
	</table>
	<span id="err"> </span>
	<span id="TextBox"></span>
	<input type="Button" id='MinButton'  onclick="loadXMLDoc()" />
	<input type="text" id='statusValue' readonly="readonly" />
	<input type="Button" id='AddButton' onclick="loadXMLDoc()" />
</body>
</html>