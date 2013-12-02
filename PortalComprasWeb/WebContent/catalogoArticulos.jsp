<%@page import="util.FechaUtil"%>
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
<script type="text/javascript" src="js/jquery-latest.js"></script>
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript" id="js">
	$(document).ready(function() {
		// call the tablesorter plugin
		$("table").tablesorter({
			// sort on the first column and third column, order asc
			sortList : [ [ 0, 0 ], [ 2, 0 ] ]
		});
	});
</script>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<br>
	<h1 class="mainTitle">Art&iacute;culos</h1>
	<div style="margin-left: 200px;">
		<form action="BusquedaArticulo" method="post">
			<fieldset style="float: left; padding: 2em">
				<legend style="color: #AAAAAA; font-family: sans-serif; font-size: 16px">B&uacute;squeda de art&iacute;culos</legend>
				<table align="right" border="0" cellpadding="0" width="50"
							bgcolor="#CCCCCC"
							style="text-align: right; FONT-FAMILY: 'Verdana, Geneva, Arial, Helvetica, sans-serif';">
					<tr>
						<td><label for="Buscar"
							style="font-size: 14px; color: #FFFFFF; font-family: Arial;">Buscar: </label></td>
						<td><input type="text" name="criterio" value=""
							maxlength="250" /></td>
					</tr>
					<tr>
						<td colspan="100"><input class="button" type="submit" name="buscar"
							value="buscar" /></td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>

	<div style="width: 1000px; background-color: #FFFFFF; margin: auto;">
		<div style="width: 960px; margin: auto; padding-top:140px; padding-bottom:20px;">
			<table id="prods" class="tablesorter">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Marca</th>
						<th>Precio</th>
						<th>Ranking</th>
						<th>Categor&iacute;a</th>
						<th>Fecha</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<Articulo> productos = (List<Articulo>) request
								.getAttribute("listado");
						Iterator<Articulo> itProd = productos.iterator();
						int rotar = 0;
						String clase = "";
						while (itProd.hasNext()) {
							Articulo articulo = itProd.next();
							if (rotar % 2 != 0)
								clase = "\"alt\"";//System.out.println("<tr class=\"alt\">");
							else
								clase = "\"\"";//System.out.println("<tr>");
					%>
					<tr class=<%=clase%>>
						<td><a <%if( session.getAttribute("usuario") != null) {%>href="ObtenerArticulo?id=<%=articulo.getCodigo()%><%} %>"><%=articulo.getNombre()%></a> </td>
						<td><%=articulo.getMarca()%></td>
						<td><%=articulo.getPrecio()%></td>
						<td><%=(articulo.getPosicion()==null)?"Sin Ranking":articulo.getPosicion()%></td>
						<td><%=articulo.getTipo().toString()%></td>
						<td><%=FechaUtil.toStringXml(articulo.getFecha())%></td>
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
	</div>
	<!-- End wrap -->


</body>
</html>