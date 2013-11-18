<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp" flush="true" />
<script type="text/javascript">
function validar(){
	if(document.form1.cantidad.value=='' || document.form1.cantidad.value=='0'){
		alert('El campo cantidad esta vacio o es 0');
		document.form1.cantidad.focus();
		return false;
	}
}

function soloNumeros(evt){
	if(window.event){
		keynum = evt.keyCode;
	}else{
		keynum = evt.which;
	}
	if(keynum>47 && keynum<58){
		return true;
	}else{
		return false;
	}
}
</script>

</head>
<body>
<jsp:include page="menu.jsp"/>
<br><br><br>
<h1>Detalle del Articulo</h1>
<form name="form1" action="Carrito" method="POST" onsubmit="return validar();">
<fieldset style="float: left; padding: 2em">
<table>
	<tr style="color:#FFFFFF;font-family: sans-serif">
		<td><b>Id</b></td>
		<td><b>Nombre</b></td>
		<td><b>Marca</b></td>
		<td><b>Precio</b></td>
		<td><b>Categoria</b></td>
		<td><b>Descripcion</b></td>
		<td><b>Cantidad</b></td>
		<td><b> </b></td>
	</tr>

    <%  
        Articulo articulo= (Articulo)request.getAttribute("Articulo"); 
	%>
		<tr style="color:#FFFFFF;font-family: sans-serif">
			<td><input type="text" size="8" style="color:#FFFFFF;font-family: sans-serif;background-color:transparent;border:0px solid white;" name="id" readonly="readonly" value=<%=articulo.getCodigo()%>></td>
            <td><%=articulo.getNombre()%></td>
            <td><%=articulo.getMarca()%></td>
            <td><%=articulo.getPrecio()%></td>
 			<td><%=articulo.getTipo().toString()%></td>
            <td><%=articulo.getDescripcion()%></td>
            <td><input type="text" onkeypress="return soloNumeros(event)" name="cantidad" value=0></td>
            <td><input type="submit" value="Agregar" name="add"><input type="hidden" name="action" value="add"></td>
        </tr>
</table>
</fieldset>
</form>
<br><br><br><br><br><br><br><br><br>
<b style="color:#FFFFFF;font-family: Verdana;font-size: medium;text-align: left;">Mas información</b>
<br>
<table style="color:#FFFFFF;font-family: sans-serif">
    <tbody>
    <tr>
        <td colspan="2"></td>
    </tr>
    <tr>
        <td>Caracteristicas</td>
        <td><%=articulo.obtenerCaracteristicas()%></td>
    </tr>
    <tr>
        <td>Imagen</td>
        <td><a href="<%= articulo.getFoto() %>" target = "_blank"><%=articulo.getFoto()%></a></td>
    </tr>
    </tbody>
</table>
</body>
</html>