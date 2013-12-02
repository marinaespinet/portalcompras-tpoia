<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp" flush="true" />
<link rel="stylesheet" href="css/tablesorter.css" type="text/css" id=""
	media="print, projection, screen" />
<script type="text/javascript">
	function validar() {
		if (document.form1.cantidad.value == ''
				|| document.form1.cantidad.value == '0') {
			alert('El campo cantidad esta vacio o es 0');
			document.form1.cantidad.focus();
			return false;
		}
	}

	function soloNumeros(evt) {
		if (window.event) {
			keynum = evt.keyCode;
		} else {
			keynum = evt.which;
		}
		if (keynum > 47 && keynum < 58) {
			return true;
		} else {
			return false;
		}
	}
</script>
<%
	Usuario u = (Usuario) session.getAttribute("usuario");
%>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<br>
	<br>
	<h1 class="mainTitle">Detalle del Art&iacute;culo</h1>
	<div style="width: 1000px; background-color: #FFFFFF; margin: auto;">
		<form name="form1" action="Carrito" method="POST"
			onsubmit="return validar();">
			<table class="tablesorter">
				<tr>
					<td><b>Nombre</b></td>
					<td><b>Marca</b></td>
					<td><b>Precio</b></td>
					<td><b>Categoria</b></td>
					<td><b>Descripcion</b></td>
					<%if(u!=null){ %>
						<td><b>Cantidad</b></td>
						<td><b> </b></td>
					<%} %>
				</tr>

				<%
					Articulo articulo = (Articulo) request.getAttribute("articulo");
				%>
				<tr style="color: #FFFFFF; font-family: sans-serif">
					<td><%=articulo.getNombre()%></td>
					<td><%=articulo.getMarca()%></td>
					<td><%=articulo.getPrecio()%></td>
					<td><%=articulo.getTipo().toString()%></td>
					<td><%=articulo.getDescripcion()%></td>
					<%if(u!=null){ %>
					<td><input type="text" onkeypress="return soloNumeros(event)"
						name="cantidad" value=0></td>
					<td><input type="hidden" 
						name="id" readonly="readonly" value="<%=articulo.getCodigo()%>"/>
						<input class="button" type="submit" value="Agregar"
						name="add"><input type="hidden" name="action" value="add"/></td>
						<%} %>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<br>
	<b
		style="color: #666666; font-family: Verdana; font-size: medium; text-align: left;">Mas
		información</b>
	<br>
	<br>
	<div style="width: 1000px; background-color: #FFFFFF; margin: auto;">
		<table class="tablesorter">
			<tbody>
				<tr>
					<td><b>Caracter&iacute;sticas</b></td>
					<td><b>Imagen</b></td>
				</tr>
				<tr>
					<td><%=articulo.obtenerCaracteristicas()%></td>
					<td><%if(articulo.getFoto()!=null && !articulo.getFoto().isEmpty()){ %><img alt="Imagen del articulo" src="<%=articulo.getFoto()%>" target="_blank"/><%}else{ %> No disponible <%} %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>