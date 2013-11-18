<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Portal de Compras</title>
<link rel="stylesheet" href="css/navbar.css" type="text/css" />
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#main-nav li a.main-link").hover(function(){
		$("#main-nav li a.close").fadeIn();
		$("#main-nav li a.main-link").removeClass("active");												 
		$(this).addClass("active");										 
		$("#sub-link-bar").animate({
			height: "40px"					   
		});
		$(".sub-links").hide();
		$(this).siblings(".sub-links").fadeIn();
	});
	$("#main-nav li a.close").click(function(){
		$("#main-nav li a.main-link").removeClass("active");												 									 
		$(".sub-links").fadeOut();
		$("#sub-link-bar").animate({
			height: "10px"					   
		});		
		$("#main-nav li a.close").fadeOut();
	});
	
	
});

</script>
</head>
<body>
<jsp:include page="menu.jsp" flush="true" />
 <br><br>
 <br><br>
 <form name="form1" action="LoginUsuario" method="post">
 	<fieldset style="float: left; padding: 2em">
 	<legend style="color:#FFFFFF;font-family: sans-serif">Login Portal de Compras</legend>
	<table border="0" cellpadding="0" width="50" bgcolor="#2d2620">
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
				<input type="SUBMIT" value="Ingresar" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">
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


</body>
</html>