<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:18px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
<title>Available Trains</title>
</head>
<body>
	<h1>Success</h1>
	<div>
		<TABLE class="hovertable">
			<TR >
				<TH>Train Number</TH>
				<TH>Boarding Point</TH>
				<TH>Boarding Time</TH>
				<TH>Halt(in Mins)</TH>
				<th>Destination Stop</th>
				<th>Journey days</th>
				<th>Reaching Time</th>
				<th>Halt(in Mins)</th>
				<th>Book Now</th>
			</TR>
			<c:forEach var="TrainDetailsWithStartAndEndStation" items="${ls}"
				varStatus="status">
				<div class="col-md-4 col-sm-6">
					<Tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
						<td><a
							href="trainDetails?id=${TrainDetailsWithStartAndEndStation.trainNum}"
							style="text-decoration:none;" target="_blank">

								${TrainDetailsWithStartAndEndStation.trainNum}</a></td>

						<td>${TrainDetailsWithStartAndEndStation.stationNamStart}</td>
						<td>${TrainDetailsWithStartAndEndStation.startTimeStart}</td>
						<td>${TrainDetailsWithStartAndEndStation.haultMinsStart}</td>
						<td>${TrainDetailsWithStartAndEndStation.stationNameEnd}</td>
						<td>${TrainDetailsWithStartAndEndStation.journeyDayEnd}</td>
						<td>${TrainDetailsWithStartAndEndStation.startTimeEnd}</td>
						<td>${TrainDetailsWithStartAndEndStation.haultMinsEnd}</td>
						<td><a
							href="passengerDetailsWithTrain?id=${TrainDetailsWithStartAndEndStation.trainNum}" style="text-decoration:none;">
								Book</a></td>

					</Tr>
				</div>
			</c:forEach>
			</TABLE>
		
	</div>
</body>
</html>