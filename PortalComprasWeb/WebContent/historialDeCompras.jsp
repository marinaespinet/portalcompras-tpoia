<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="DTO.*"%>
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
	<br>
	<br>
	<br>
	<h1 style="color:#444444; margin-top:-10px;">Historial de Compras</h1>
	<div style="width: 1000px; margin: auto; background-color: #FFFFFF;">
		<div
			style="width: 960px; margin: auto; padding-top: 20px; padding-bottom: 20px;">
			<table class="tablesorter">
				<thead>
					<tr>
						<th>Nro de Compra</th>
						<th>Estado</th>
						<th>Fecha</th>
						<th>Contenido</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Venta> ventas = (List<Venta>) request.getAttribute("ventas");
						Iterator<Venta> itPed = ventas.iterator();
						int rotar = 0;
						String clase = "";
						while (itPed.hasNext()) {
							Venta venta = itPed.next();
							if (rotar % 2 != 0)
								clase = "\"alt\"";
							else
								clase = "\"\"";
					%>
					<tr class=<%=clase%>>
						<td><%=venta.getNroVenta()%></td>
						<td><%=venta.getEstado()%></td>
						<td><%=venta.getFecha()%></td>
						<td>
							<%
								Iterator<ItemVenta> itemsPed = venta.getItemsVenta().iterator();
									while (itemsPed.hasNext()) {
										ItemVenta ped = itemsPed.next();
							%> <%=ped.toString()%><br> <%
 	}
 %>
						</td>
					</tr>
					<%
						rotar++;
						}
					%>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>