<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Please enter ur login ID and password</h2>
<form:form method="POST" action="/RailBookig/validate">
   <table>
    <tr>
        <td><form:label path="userId">UserId</form:label></td>
        <td><form:input path="userId" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input type="password" path="password" /></td>
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