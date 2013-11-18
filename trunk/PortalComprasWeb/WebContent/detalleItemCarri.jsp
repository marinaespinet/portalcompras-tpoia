<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="DTO.ItemCantidadDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp" flush="true" />

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

</head>
<body>
	<jsp:include page="menu.jsp" flush="true" />
	<br>
	<br>
	<br>
	<h1>Detalle del Carrito</h1>
	<form name="form1" action="Carrito" method="POST"
		onsubmit="return validar();">
		<table>
			<tr style="color: #FFFFFF; font-family: sans-serif">
				<td><b>Id</b></td>
				<td><b>Nombre</b></td>
				<td><b>Marca</b></td>
				<td><b>Precio</b></td>
				<td><b>Ranking</b></td>
				<td><b>Categoria</b></td>
				<td><b>Cantidad</b></td>
			</tr>

			<%
				ItemCantidadDTO ic = (ItemCantidadDTO) request
						.getAttribute("articulo");
			%>
			<tr style="color: #FFFFFF; font-family: sans-serif">
				<td><input type="text" size="8"
					style="color: #FFFFFF; font-family: sans-serif; background-color: transparent; border: 0px solid white;"
					name="id" readonly="readonly" value="<%=ic.getArticulo().getCodigo() %>"
					></td>
				<td><%=ic.getArticulo().getNombre()%></td>
				<td><%=ic.getArticulo().getMarca()%></td>
				<td><%=ic.getArticulo().getPrecio()%></td>
				<td><%=ic.getArticulo().getPosicion() %></td>
				<td><%=ic.getArticulo().getTipo().toString()%></td>
				<td><input type="text" onkeypress="return soloNumeros(event)"
					name="cantidad" value=<%=ic.getCantidad()%>></td>
			</tr>
		</table>
		<input type="submit" value="Actualizar" name="actualizar"
			style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;"> <input
			type="hidden" name="action" value="update"><br> <input
			type="submit" value="Eliminar" name="delete"
			style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">
	</form>
	<br>
</body>
</html>