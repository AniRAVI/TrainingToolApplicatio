
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="cssfile/editCourseDetails.css" rel="stylesheet" type="text/css"/>
<head>
</head>
<body>
	<jsp:include page="header.jsp" />
	<jsp:include page="link.jsp" />
	<jsp:include page="rightMenu.jsp" />
	<div class="inputform">
		<h2 class="design">Edit Course</h2>
		<form method="POST" action='CourseController'>
		
			<table>
					<tr id =coursename>
					<td >Course Name:</td>
					<td id="coursenametestBox"><input type="text" id="email" name="cname"
						value="<c:out value="${course.cname}" />" /></td>
				</tr>
				<tr id = courseauthor>
					<td>Course Author:</td>
					<td id ="courseauthorTextBox"><input id="password" type="text" name="cauthor"
						value="<c:out value="${course.cauthor}" />" /></td>
				</tr>
				<tr id = minduration>
					<td>Min Duration:</td>
					<td id ="minDUrationTextBox"><input id="password" type="text" name="minDuration"
						value="<c:out value="${course.cmin}" />" /></td>
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
							<label id = testLeadlbl>TEST LEAD</label>
						<div id='entryLevel' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="atlel"
								value="1" ${course.tlEntrylevel == '1' ? 'checked' : ''}><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='po' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="atlpo"
								value="1" ${course.tlpo == '1' ? 'checked' : ''} ><label for="teamLead">PO</label>
						</div>
						<div id='ad' style="visibility: visible;">
							<input type="checkbox" name="atl_ad" id="entryLevelCb"
								value="1" ${course.tlad == '1' ? 'checked' : ''} ><label for="teamLead">AD</label>
						</div>
						<div id='ds' style="visibility: visible;">
							<input type="checkbox" name="atlas" id="entryLevelCb"
								value="1" ${course.tlas == '1' ? 'checked' : ''}><label for="teamLead">AS</label>
						</div>
						</div>
						
						
						
					</td>
					<td id="secondtd1">
						<div>
							<label id = testMangerlbl>TEST MANAGER</label>
						<div id='tmentryLevel' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="atmel"
								value="1" ${course.tmel == '1' ? 'checked' : ''}><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='tmpo' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="atmpo"
								value="1" ${course.tmpo == '1' ? 'checked' : ''} ><label for="teamLead">PO</label>
						</div>
						<div id='tmad' style="visibility: visible;">
							<input type="checkbox" name="atm_ad" id="entryLevelCb"
								value="1" ${course.tmad == '1' ? 'checked' : ''} ><label for="teamLead">AD</label>
						</div>
						<div id='tmds' style="visibility: visible;">
							<input type="checkbox" name="atmas" id="entryLevelCb"
								value="1" ${course.tmas == '1' ? 'checked' : ''} ><label for="teamLead">AS</label>
						</div>
						</div>
					</td>
		<!-- --***********************************Mandantory ************************************** -->
					<div id ="mandantory">Mandantory For</div>
					<td id="firsttd">
						<div>
							<label id = testLeadlbl2>TEST LEAD</label>
						<div id='mentryLevel' style="visibility: visible;">
							<input type="checkbox" id="mentryLevelCb" name="mEntrylevel"
								value="1" ${course.mtlEntrylevel == '1' ? 'checked' : ''}><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='mpo' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="mtlpo"
								value="1" ${course.mtlpo == '1' ? 'checked' : ''}><label for="teamLead">PO</label>
						</div>
						<div id='mad' style="visibility: visible;">
							<input type="checkbox" name="mtl_ad" id="entryLevelCb"
								value="1" ${course.mtlad == '1' ? 'checked' : ''}><label for="teamLead">AD</label>
						</div>
						<div id='mds' style="visibility: visible;">
							<input type="checkbox" name="mtlas" id="entryLevelCb"
								value="1" ${course.mtlas == '1' ? 'checked' : ''}><label for="teamLead">AS</label>
						</div>
						</div>
						
						
						
					</td>
					<td id="secondtd1">
						<div>
					<label id ="testMangerlbl2">TEST MANAGER</label>
						<div id='mtmentryLevel' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="mtmel"
								value="1" ${course.mtmel == '1' ? 'checked' : ''}><label for="teamLead">ENTRY
								LEVEL</label>
						</div>
						<div id='mtmpo' style="visibility: visible;">
							<input type="checkbox" id="entryLevelCb" name="mtmpo"
								value="1" ${course.mtmpo == '1' ? 'checked' : ''}><label for="teamLead">PO</label>
						</div>
						<div id='mtmad' style="visibility: visible;">
							<input type="checkbox" name="mtm_ad" id="entryLevelCb"
								value="1" ${course.mtmad == '1' ? 'checked' : ''}><label for="teamLead">AD</label>
						</div>
						<div id='mtmds' style="visibility: visible;">
							<input type="checkbox" name="mtmas" id="entryLevelCb"
								value="1" ${course.mtmas == '1' ? 'checked' : ''}><label for="teamLead">AS</label>
						</div>
						</div>
					</td>
					<td id="secondtd1"
						style="position: relative; bottom: 22px  !important"><input
						type="checkbox" id="entryLevelCb" name="dm" value="1" ${course.dm == '1' ? 'checked' : ''}><label
						for="teamLead">DM</label></td>
				</tr>
				<tr id=button>
					<td><input id="register" type="reset" value="Reset" />
					</td>
					<td><input id="login" type="submit" value="Submit" />
					</td>
					</tr>
					<tr>
					<td><input type="hidden" id="email" name="cid"
						value="<c:out value="${course.cid}" />" readonly="readonly" /></td>
				</tr>
			</table>
		</form>
	</div>
		<jsp:include page="footer.html" />
	
</body>
</html>
