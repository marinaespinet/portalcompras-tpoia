<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<jsp:include page="head.jsp" flush="true" />
</head>
<body>
<jsp:include page="menu.jsp"/>
 <br><br>
 <br><br>
 <table width="900px" align="center">
 <tr>
 <td>
 <form name="form1" action="LoginUsuario" method="post">
 	<fieldset style="float: left; padding: 2em">
 	<legend style="color:#FFFFFF;font-family: sans-serif">Login Portal de Compras</legend>
	<table align="center" border="0" cellpadding="0" width="50" bgcolor="#2d2620">
		<tr>
			<td><b style="color:#FFFFFF;font-family: sans-serif">Dni: </b></td>
			<td>
				<input id="usuario" type="text" name="usuario">
			</td>
		</tr>
		<tr>
			<td><b style="color:#FFFFFF;font-family: sans-serif">Contraseña: </b></td>
			<td>
				<input id="password" type="password" name="password">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="hidden" name="action" value="login">
				<input type="submit" value="Ingresar" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">
			</td>
		</tr>
	</table>
	
	<%
		String error = (String)request.getAttribute("error");
		if (error==null) 
			error="";
	%>
	<b style="color:#FFFFFF;font-family: sans-serif"><%= error%></b>
	
	</fieldset>
</form>
</td>
</tr>
</table>

</body>
</html>