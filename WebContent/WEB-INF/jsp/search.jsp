<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Please enter Boarding and Destination</h2>
<form:form method="POST" action="/RailBookig/availableTrains">
   <table>
    <tr>
        <td><form:label path="start">Start</form:label></td>
        <td><form:input path="start" /></td>
    </tr>
    <tr>
        <td><form:label path="end">End</form:label></td>
        <td><form:input path="end" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>