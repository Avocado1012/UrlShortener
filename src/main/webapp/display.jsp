<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>shorted</title>
</head>
<body>
	shorted : <%= request.getAttribute("result") %> <br><br>
	<form action="get">
		<input type="submit" name="show" value = "Show url">
	</form>
</body>
</html>