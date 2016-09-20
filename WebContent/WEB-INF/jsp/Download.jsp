<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download</title>
</head>
<body>
${Msg}
<c:choose>
<c:when test="${not empty ls}">
<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1">
    <TR>
        <TH>PNR</TH>
        <TH>Seats Booked</TH>
        <TH>Status</TH>
        <TH>Download</TH>
    </TR>
		<c:forEach var="Booking" items="${ls}"
			varStatus="status">
			<div class="col-md-4 col-sm-6">
			<TR>
					<TD>${Booking.uniqueId}</TD>
				<TD>	${Booking.seatBooked}</TD>
				<TD>	${Booking.status}</TD>
				<TD><a href="DownloadWithID?id=${Booking.uniqueId}" style="text-decoration:none;">
								Download</a></TD>
					</TR>
			</div>
			
		</c:forEach>
</TABLE>
</c:when>
<c:otherwise>
      <h1>U have no bookings.</h1>
    </c:otherwise>
</c:choose>

</body>
</html>