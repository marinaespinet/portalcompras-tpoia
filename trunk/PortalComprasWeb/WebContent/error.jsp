<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link rel="stylesheet" href="css/navbar.css" type="text/css" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<br>
	<h1>P�gina de Error</h1>
	<%
		String error = (String) request.getAttribute("error");
	%>
	Se ha producido un error:
	<%=error%>
</body>
</html>