<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="head.jsp" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1 style="color: #444444; margin-top: -10px;">Nueva Configuración</h1>

	<table width="200px" style="background-color: #FFFFFF;" align="center">
		<tr>
			<td>
				<form action="AgregarConfiguracion" method="post">
					<fieldset style="float: left; padding: 2em">
						<legend
							style="color: #AAAAAA; font-family: sans-serif; font-size: 16px">Ingrese
							nueva configuraci&oacute;n</legend>
						<table class="inputData" align="right" border="0" cellpadding="0" width="50"
							bgcolor="#CCCCCC"
							style="text-align: right; FONT-FAMILY: 'Verdana, Geneva, Arial, Helvetica, sans-serif';">
							<tr>
								<td><label for="Nombre">Nombre:
								</label></td>
								<td><input type="text" name="nombre" value=""
									maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="Funcionalidad">Funcionalidad:
								</label></td>
								<td><input type="text" name="funcionalidad" value=""
									maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="tipo">Tipo: </label></td>
								<td><input type="radio" name="tipo" value="sync" checked />
									<b style="color: #FFFFFF; font-family: sans-serif">Sicronico</b>
									<input type="radio" name="tipo" value="async" /> <b
									style="color: #FFFFFF; font-family: sans-serif">Asincronico</b></td>
							</tr>
							<tr>
								<td><label for="IP">IP: </label></td>
								<td><input type="text" name="ip" value="" maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="Puerto">Puerto:
								</label></td>
								<td><input type="text" name="puerto" value=""
									maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="URL">URL: </label></td>
								<td><input type="text" name="url" value="" maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="usuario">Usuario:
								</label></td>
								<td><input type="text" name="usuario" value=""
									maxlength="100" /></td>
							</tr>
							<tr>
								<td><label for="password">Password:
								</label></td>
								<td><input type="text" name="password" value=""
									maxlength="100" /></td>
							</tr>
							<tr>
								<td></td>
								<td><input class="button" type="submit" value="Enviar"
									style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;" /></td>
							</tr>
						</table>
					</fieldset>
				</form>
			</td>
		</tr>
	</table>

</body>
</html>