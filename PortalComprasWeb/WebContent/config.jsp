<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tablesorter.css" type="text/css" id=""
	media="print, projection, screen" />


<jsp:include page="head.jsp" flush="true" />

</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1 style="color:#444444; margin-top:-10px;">Configuraci&oacute;n</h1>
	<div style="width: 1000px; background-color: #FFFFFF; margin: auto;">
		<div
			style="width: 960px; margin: auto; padding-top: 20px; padding-bottom: 20px;">
			<table id="prods" class="tablesorter">
				<thead>
					<tr>
						<th>Id</th>
						<th>Tipo</th>
						<th>Estado</th>
						<th>Funcionalidad</th>
						<th>Nombre</th>
						<th>IP</th>
						<th>Puerto</th>
						<th>URL</th>
						<th>User</th>
						<th>Password</th>
						<th>Cambiar Estado?</th>

					</tr>
				</thead>
				<tbody>
					<%
					List<Config> configs = (List<Config>) request
							.getAttribute("listado");
					Iterator<Config> itConf = configs.iterator();
					int rotar = 0;
					String clase = "";
					String accionEstado = "";
					String estado = "";
					while (itConf.hasNext()) {
						Config conf = itConf.next();
						if (rotar % 2 != 0)
							clase = "\"alt\"";
						else
							clase = "\"\"";
						if (conf.isActivado()) {
							accionEstado = "Desactivar";
							estado = "Activo";
						} else {
							accionEstado = "Activar";
							estado = "Inactivo";
						}
				%>
					<tr class=<%=clase%>>
						<td><%=conf.getId()%></td>
						<td><%=conf.getClass().getSimpleName()%></td>
						<td><%=estado%></td>
						<td><%=conf.getFuncionalidad()%></td>
						<td><%=conf.getNombre()%></td>
						<td><%=conf.getIp()%></td>
						<td><%=conf.getPuerto()%></td>
						<%
						if (conf.getClass().getSimpleName().equals("ConfigAsincronica")) {
								ConfigAsincronica asinc = (ConfigAsincronica) conf;
					%>
						<td>N/A</td>
						<td><%=asinc.getUser()%></td>
						<td><%=asinc.getPassword()%></td>
						<%
						} else {
								ConfigSincronica sinc = (ConfigSincronica) conf;
					%>
						<td><%=sinc.getUrl()%></td>
						<td>N/A</td>
						<td>N/A</td>
						<%
						}
					%>
						<td><a
							href="ModificarEstadoConf?accion=<%=accionEstado%>&id=<%=conf.getId()%>"><%=accionEstado%></a></td>
					</tr>
					<%
					rotar++;
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
	<br>

</body>
</html>