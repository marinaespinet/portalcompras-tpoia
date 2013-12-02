<%@page import="util.FechaUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.*"%>
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
						<td><a href="ObtenerArticulo?id=<%=articulo.getCodigo()%>"><%=articulo.getNombre()%></a> </td>
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