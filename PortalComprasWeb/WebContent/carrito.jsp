<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="DTO.ItemCantidadDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.Articulo"%>
<%@page import="java.util.*"%>
<%@ page session="true" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal de Compras</title>
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

</head>
<body>
<jsp:include page="cab.jsp" flush="true" />
<br><br><br>
<%
 List<ItemCantidadDTO> items = (List<ItemCantidadDTO>) request.getAttribute("items");
 if (items!= null && items.size() > 0) {
%> 
<br><br>
<center>
<table border="0" cellpadding="0" width="100%" style="color:#FFFFFF;font-family: sans-serif">
 <tr>
 <td><b>Id</b></td>
 <td><b>Nombre</b></td>
 <td><b>Marca</b></td>
 <td><b>Precio</b></td>
 <td><b>Ranking</b></td>
 <td><b>Categoria</b></td>
 <td><b>Cantidad</b></td>
 <td><b>Editar</b></td>
 </tr>
 
 <%
  for (int i=0; i < items.size();i++) {
   ItemCantidadDTO it = items.get(i);
 %>
 <tr>
  <td><%=it.getProducto().getId()%></td>
  <td><%= it.getProducto().getNombre()%></td>
  <td><%= it.getProducto().getMarca()%></td>
  <td><%= it.getProducto().getPrecio()%></td>
  <td><%= it.getProducto().getBestSellerRanking()%></td>
  <td><%= it.getProducto().getCategoria().getNombre()%></td>
  <td><%=it.getCantidad()%></td>
  <td><a href="ObtenerProductoCarrito?id=<%=it.getProducto().getId()%>">Editar</a><br></td>
</tr> 
<% } %>
</table>
<p>
</center>
<form name="form1" action="Carrito" method="POST">
	 <input type="submit" name="save" value="Confirmar carrito" style="FONT-FAMILY: 'Verdana'; FONT-SIZE: x-small;">
	 <input type="hidden" name="action" value="save">
</form>


<% } %>

 </body>
</html>