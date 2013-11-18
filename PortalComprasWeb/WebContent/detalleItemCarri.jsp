<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="simples.ItemCarrito"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Portal Compras - Grupo 2</title>
<link rel="stylesheet" href="css/navbar.css" type="text/css" />
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#main-nav li a.main-link").hover(function(){
		$("#main-nav li a.close").fadeIn();
		$("#main-nav li a.main-link").removeClass("active");												 
		$(this).addClass("active");										 
		$("#sub-link-bar").animate({
			height: "40px"					   
		});
		$(".sub-links").hide();
		$(this).siblings(".sub-links").fadeIn();
	});
	$("#main-nav li a.close").click(function(){
		$("#main-nav li a.main-link").removeClass("active");												 									 
		$(".sub-links").fadeOut();
		$("#sub-link-bar").animate({
			height: "10px"					   
		});		
		$("#main-nav li a.close").fadeOut();
	});
	
	
});

</script>

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
<jsp:include page="cab.jsp" flush="true" />
<br><br><br>
<h1>Detalle del Carrito</h1>
<form name="form1" action="Carrito" method="POST" onsubmit="return validar();">
<table>
	<tr style="color:#FFFFFF;font-family: sans-serif">
		<td><b>Id</b></td>
		<td><b>Nombre</b></td>
		<td><b>Marca</b></td>
		<td><b>Precio</b></td>
		<td><b>Ranking</b></td>
		<td><b>Categoria</b></td>
		<td><b>Cantidad</b></td>
	</tr>

    <%  
    	ItemCarrito ic = (ItemCarrito)request.getAttribute("producto"); 
	%>
		<tr style="color:#FFFFFF;font-family: sans-serif">
			<td><input type="text" size="8" style="color:#FFFFFF;font-family: sans-serif;background-color:transparent;border:0px solid white;" name="id" readonly="readonly" value=<%=ic.getProducto().getId()%>></td>
            <td><%=ic.getProducto().getNombre()%></td>
            <td><%=ic.getProducto().getMarca()%></td>
            <td><%=ic.getProducto().getPrecio()%></td>
            <td><%=ic.getProducto().getBestSellerRanking()%></td>
            <td><%=ic.getProducto().getCategoria().getNombre()%></td>
            <td><input type="text" onkeypress="return soloNumeros(event)" name="cantidad" value=<%=ic.getCantidad()%>></td>
        </tr>
</table> 
	<input type="submit" value="Actualizar" name="actualizar" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">
	<input type="hidden" name="action" value="update"><br>
	<input type="submit" value="Eliminar" name="delete" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">  
</form>
<br>
</body>
</html>