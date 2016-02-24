<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="cssfile/global.css" rel="stylesheet" type="text/css"/>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.js" ></script>
<script src="http://malsup.github.com/jquery.form.js" ></script>
<script src="js/fileUploadScript.js" ></script>
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="javascript/utill.js"></script>
</head>
<body>
	<div class="inputform" style="float: left;">
		<h2 class="design">Upload Course</h2>
		<form id="InsertCourseDetails" action="InsertCourseDetails" method="post" enctype="multipart/form-data">
			<table>
				<tr id =coursename>
					<td >Course Name:</td>
					<td id="coursenametestBox"><input type="text" id="email" name="cname"
						 /></td>
				</tr>
				<tr id = courseauthor>
					<td>Course Author:</td>
					<td id ="courseauthorTextBox"><input id="password" type="text" name="cauthor"
				 /></td>
				</tr>
				<tr id = minduration>
					<td>Min Duration:</td>
					<td id ="minDUrationTextBox"><input id="password" type="text" name="minDuration"
						 /></td>
				</tr>
				<tr id= courseFIle>
					<td>File:</td>
					<td id =courseFIlebox><input id="password" type="file" name="file" /></td>
				</tr>
				
				<!-- --***********************************Avilable ************************************** -->
				<div id ="available">Available For</div>
				
				<tr id="userRole">
					<td id="firsttd">
						<div>
							<input type="checkbox" id="entryLevelCb" value="Entry Level"
								onclick="showHide();"><label
								for="teamLead">TEST LEAD</label>
						<div id='entryLevel' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="atlel"
								value="1"><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='po' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="atlpo"
								value="1"><label for="teamLead">PO</label>
						</div>
						<div id='ad' style="visibility: hidden;">
							<input type="checkbox" name="atl_ad" id="entryLevelCb"
								value="1"><label for="teamLead">AD</label>
						</div>
						<div id='ds' style="visibility: hidden;">
							<input type="checkbox" name="atlas" id="entryLevelCb"
								value="1"><label for="teamLead">AS</label>
						</div>
						</div>
						
						
						
					</td>
					<td id="secondtd1">
						<div>
							<input type="checkbox" id="testManger" name="testMangerq"
								value="Entry Level" onclick="showManger();"><label
								for="teamLead">TEST MANAGER</label>
						<div id='tmentryLevel' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="atmel"
								value="1"><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='tmpo' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="atmpo"
								value="1"><label for="teamLead">PO</label>
						</div>
						<div id='tmad' style="visibility: hidden;">
							<input type="checkbox" name="atm_ad" id="entryLevelCb"
								value="1"><label for="teamLead">AD</label>
						</div>
						<div id='tmds' style="visibility: hidden;">
							<input type="checkbox" name="atmas" id="entryLevelCb"
								value="1"><label for="teamLead">AS</label>
						</div>
						</div>
					</td>
		<!-- --***********************************Mandantory ************************************** -->
					<div id ="mandantory">Mandantory For</div>
					<td id="firsttd">
						<div>
							<input type="checkbox" id="mentryLevelCb" value="Entry Level"
								onclick="mshowHide();"><label
								for="teamLead">TEST LEAD</label>
						<div id='mentryLevel' style="visibility: hidden;">
							<input type="checkbox" id="mentryLevelCb" name="mEntrylevel"
								value="1"><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='mpo' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="mtlpo"
								value="1"><label for="teamLead">PO</label>
						</div>
						<div id='mad' style="visibility: hidden;">
							<input type="checkbox" name="mtl_ad" id="entryLevelCb"
								value="1"><label for="teamLead">AD</label>
						</div>
						<div id='mds' style="visibility: hidden;">
							<input type="checkbox" name="mtlas" id="entryLevelCb"
								value="1"><label for="teamLead">AS</label>
						</div>
						</div>
						
						
						
					</td>
					<td id="secondtd1">
						<div>
							<input type="checkbox" id="mtestManger" name="testMangerq"
								value="Entry Level" onclick="mshowManger();"><label
								for="teamLead">TEST MANAGER</label>
						<div id='mtmentryLevel' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="mtmel"
								value="1"><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='mtmpo' style="visibility: hidden;">
							<input type="checkbox" id="entryLevelCb" name="mtmpo"
								value="1"><label for="teamLead">PO</label>
						</div>
						<div id='mtmad' style="visibility: hidden;">
							<input type="checkbox" name="mtm_ad" id="entryLevelCb"
								value="1"><label for="teamLead">AD</label>
						</div>
						<div id='mtmds' style="visibility: hidden;">
							<input type="checkbox" name="mtmas" id="entryLevelCb"
								value="1"><label for="teamLead">AS</label>
						</div>
						</div>
					</td>
					<td id="secondtd1"
						style="position: relative; bottom: 40px !important"><input
						type="checkbox" id="entryLevelCb" name="dm" value="1"><label
						for="teamLead">DM</label></td>
				</tr>
				<tr id=button>
					<td><input id="register" type="reset" value="Reset" />
					</td>
					<td><input id="login" type="submit" value="Submit" />
					</td>
					</tr>
			</table>
		<!-- 		<div id="progressbox">
			<div id="progressbar"></div>
			<div id="percent">0%</div>
		</div>
		<br />

		<div id="message"></div> -->
		</form>
	</div>
</body>
</html>
