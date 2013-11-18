<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal Compras - Grupo 2</title>
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
<jsp:include page="cab.jsp" flush="true" />
    <h1>Nueva Configuración</h1>
    <form action="AgregarConfiguracion" method="post">
	<fieldset style="float: left; padding: 2em">
	<legend style="color:#FFFFFF;font-family: sans-serif">Ingrese nueva configuracion</legend>
	<table border="0" cellpadding="0" width="50" bgcolor="#2d2620">
		<tr>
			<td><label for="Nombre" style="color:#FFFFFF;font-family: sans-serif">Nombre: </label></td>
			<td><input type="text" name="nombre" value="" maxlength="100" /></td>
		</tr>
		<tr>
			<td><label for="Funcionalidad" style="color:#FFFFFF;font-family: sans-serif">Funcionalidad: </label></td>
			<td><input type="text" name="funcionalidad" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td><label for="tipo" style="color:#FFFFFF;font-family: sans-serif">Tipo: </label></td>
		<td><input type="radio" name="tipo" value="sync" checked /> <b style="color:#FFFFFF;font-family: sans-serif">Sync</b>
			<input type="radio" name="tipo" value="async" /> <b style="color:#FFFFFF;font-family: sans-serif">Async</b>
		</td>
		</tr>
		<tr>
		<td><label for="IP" style="color:#FFFFFF;font-family: sans-serif">IP: </label></td>
		<td><input type="text" name="ip" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td><label for="Puerto" style="color:#FFFFFF;font-family: sans-serif">Puerto: </label></td>
		<td><input type="text" name="puerto" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td><label for="URL" style="color:#FFFFFF;font-family: sans-serif">URL: </label></td>
		<td><input type="text" name="url" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td><label for="usuario" style="color:#FFFFFF;font-family: sans-serif">Usuario: </label></td>
		<td><input type="text" name="usuario" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td><label for="password" style="color:#FFFFFF;font-family: sans-serif">Password: </label></td>
		<td><input type="text" name="password" value="" maxlength="100" /></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Enviar" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;" /></td>
		</tr>
	</table>
	</fieldset>
	</form>

</body>
</html>