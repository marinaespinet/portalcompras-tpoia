<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="DTO.ItemCantidadDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.Articulo"%>
<%@page import="java.util.*"%>
<%@ page session="true"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="head.jsp" flush="true" />

</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<br>
	<%
		String mensaje = (String) request.getAttribute("mensaje");
	%>
	<%if(mensaje !=null) {%>
			<b style="color: #ff0000; font-family: sans-serif; font-size:16"><%=mensaje%></b>
		<%} %>
	<%
		List<ItemCantidadDTO> items = (List<ItemCantidadDTO>) request
				.getAttribute("items");
		if (items != null && items.size() > 0) {
	%>
	<br>
	<br>
	<center>
		<table border="0" cellpadding="0" width="100%"
			style="color: #FFFFFF; font-family: sans-serif">
			<tr>
				<td><b>#</b></td>
				<td><b>Nombre</b></td>
				<td><b>Marca</b></td>
				<td><b>Precio</b></td>
				<td><b>Ranking</b></td>
				<td><b>Categoria</b></td>
				<td><b>Cantidad</b></td>
				<td><b>Editar</b></td>
			</tr>

			<%
				for (int i = 0; i < items.size(); i++) {
						ItemCantidadDTO it = items.get(i);
			%>
			<tr>
				<td><%=i+1%></td>
				<td><%=it.getArticulo().getNombre()%></td>
				<td><%=it.getArticulo().getMarca()%></td>
				<td><%=it.getArticulo().getPrecio()%></td>
				<td><%=it.getArticulo().getPosicion()%></td>
				<td><%=it.getArticulo().getTipoString()%></td>
				<td><%=it.getCantidad()%></td>
				<td><a
					href="ObtenerArticuloCarrito?id=<%=it.getArticulo().getCodigo()%>">Editar</a><br></td>
			</tr>
			<%
				}
			%>
		</table>
		<p>
	</center>
	<form name="form1" action="Carrito" method="POST">
		<input type="submit" name="save" value="Comprar"
			style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;"> <input
			type="hidden" name="action" value="save">
	</form>


	<%
		}else{
			
	%>
	<p>No hay productos seleccionados en el carrito</p>
		
	<%} %>

</body>
</html>