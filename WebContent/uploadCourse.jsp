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
<style type="text/css">
#prereq{
	bottom: 147px;
    left: 153px;
    position: relative;
	}
#avTester{
border:1;
}
</style>
<script type="text/javascript" src="javascript/utill.js"></script>
</head>
<body>
	<div class="inputform" style="float: left;">
		<h2 class="design">Upload Course</h2>
		<form action="InsertCourseDetails" method="post" enctype="multipart/form-data">
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
				<tr id= prereq>
					<td>Pre-requisite:</td>
					<td id =prereqs>		<select  id="courseId" name ="courseId">
											<option >Select Course Id</option>
				<c:forEach var="x" items="${requestScope.courseId}">
							<option >${x}</option>
				</c:forEach>
		</select></td>
				</tr>
				<!-- --***********************************Avilable ************************************** -->
				<div id ="available">Available For</div>
				
				<tr id="userRole">
					<td id="firsttd">
						<div id ="avTester">
							<input type="checkbox" id="entryLevelCb" value="Entry Level"
								onclick="showHide();"><label
								for="teamLead">TESTER</label>
					<div id ="avifortester">
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
					</div>	
				</td>
					<td id="secondtd1">
						<div>
							<input type="checkbox" id="testManger" name="testMangerq"
								value="Entry Level" onclick="showManger();"><label
								for="teamLead">TEST MANAGER</label>
								<div id ="mandRole">
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
						</div>
					</td>
		<!-- --***********************************Mandantory ************************************** -->
					<div id ="mandantory">Mandantory For</div>
					<td id="firsttd">
						<div>
							<input type="checkbox" id="mentryLevelCb" value="Entry Level"
								onclick="mshowHide();"><label
								for="teamLead">TESTER</label>
						<div id ="manTester">
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
						</div>
					</td>
					<td id="secondtd1">
						<div>
							<input type="checkbox" id="mtestManger" name="testMangerq"
								value="Entry Level" onclick="mshowManger();"><label
								for="teamLead">TEST MANAGER</label>
					
					<div id ="manTm">
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
		</form>
	</div>
</body>
</html>
