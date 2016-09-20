<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
	<H1>Train Details</H1>
	<form:form method="GET" action="/RailBookig/PassengerDetails">
		<div>
			<h2>Train Number ${id.trainNum}</h2>

			<h3>Boarding Point => ${id.stationNamStart} Boarding Time =>
				${id.startTimeStart} Halt(in mins) => ${id.haultMinsStart}</h3>
			<h3>Destination Station Name => ${id.stationNameEnd} Journey Day
				End => ${id.journeyDayEnd} Reaching Time => ${id.startTimeEnd}
				Halt(in mins) => ${id.haultMinsEnd}</h3>
		</div>


		<H1>Passenger Details</H1>
		<table>

			<TR>
				<td>Passenger Name</td>
				<td>Age</td>
				<td>Gender</td>

			</TR>
			<tr>

				<td><form:input path="passangerName1" /></td>
				<td><form:input path="age1" /></td>
				<td><form:input path="gender1" /></td>
			</tr>
			<tr>

				<td><form:input path="passangerName2" /></td>
				<td><form:input path="age2" /></td>
				<td><form:input path="gender2" /></td>
			</tr>
			<tr>

				<td><form:input path="passangerName3" /></td>
				<td><form:input path="age3" /></td>
				<td><form:input path="gender3" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="id" value=${id.trainNum } />
	</form:form>
</body>
</html>