<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Train detail</title>
</head>
<body>
<div>
		<h1>Schedule of Train <c:out value="${trainNum}">"${trainNum}"</c:out> </h1>
		<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>Station Name</TH>
        <TH>Start Time</TH>
        <TH>Journey Day</TH>
        <TH>Hault (in Mins)</TH>
    </TR>
		<c:forEach var="trainDetails" items="${train}"
			varStatus="status">
			<div class="col-md-4 col-sm-6"><TR>
					<TD>${trainDetails.stationName}</TD>
				<TD>	${trainDetails.startTime}</TD>
				<TD>	${trainDetails.journeyDay}</TD>
				<TD>	${trainDetails.haultMins}</TD>
					</TR>
			</div>
			
		</c:forEach>
</TABLE>
	</div>
</body>
</html>