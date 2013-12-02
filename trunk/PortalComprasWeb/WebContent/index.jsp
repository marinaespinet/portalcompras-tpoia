<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="true"%>
<%@page import="entityBean.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	Usuario u = (Usuario) session.getAttribute("usuario");
%>
<html>
<jsp:include page="head.jsp" flush="true" />
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<p style="font-size: 35;">
		<b style="FONT-SIZE: xx-large; COLOR: #444444;">PORTAL DE COMPRAS</b>
	</p>
	<%if ( u == null) {%>
	<table width="200px" style="background-color: #FFFFFF;" align="center">
		<tr>
			<td>
				<form name="form1" action="LoginUsuario" method="post">
					<fieldset style="float: left; padding: 2em">
						<legend
							style="color: #AAAAAA; font-family: sans-serif; font-size: 16px">Ingresar:</legend>
						<table align="right" border="0" cellpadding="0" width="50"
							bgcolor="#CCCCCC"
							style="text-align: right; FONT-FAMILY: 'Verdana, Geneva, Arial, Helvetica, sans-serif';">
							<tr>
								<td style="font-size: 14px; color: #FFFFFF; font-family: Arial;">Usuario(Dni):
								</td>
								<td><input id="usuario" type="text" name="usuario">
								</td>
							</tr>
							<tr>
								<td style="font-size: 14px; color: #FFFFFF; font-family: Arial;">Clave:
								</td>
								<td><input id="password" type="password" name="password">
								</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="hidden" name="action" value="login">
									<input class="button" type="submit" value="Ingresar"></td>
							</tr>
						</table>

						<%
							String error = (String) request.getAttribute("error");
							if (error == null)
								error = "";
						%>
						<b style="color: #FFFFFF; font-family: sans-serif"><%=error%></b>

					</fieldset>
				</form>
			</td>
		</tr>
	</table>
	<%} else {%>
	<p style="font-size: 35;">
		<b style="FONT-SIZE: xx-large; COLOR: #444444;">Bienvenido <%= u.getNombre() %>!!!</b>
	</p>
	<%} %>
	<br>
</body>
</html>
