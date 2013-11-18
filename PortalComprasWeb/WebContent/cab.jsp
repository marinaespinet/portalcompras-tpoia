<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.List"%>

<html>
<head>
<title>Portal Compras </title>
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

<div id="sub-link-bar"> </div>
<!-- End sub-link-bar -->
<div id="wrap">
  <div id="main-handle">
    <div class="roundfg">
      <ul id="main-nav">
        <li><a class="main-link" href="index.jsp">Inicio</a>
        	<ul class="sub-links">
            	<li><a href="index.jsp">Inicio</a></li>
            </ul>
        </li>
        <li><a class="main-link" href="ObtenerTodosProductos?action=listar">Productos</a>
          <ul class="sub-links">
            <li><a href="ObtenerTodosProductos?cat=moda&action=listar" title="Ver todos los articulos de Moda">Moda</a> </li>
            <li><a href="ObtenerTodosProductos?cat=electro&action=listar" title="Ver todos los articulos de Electro">Electro</a> </li>
            <li><a href="ObtenerTodosProductos?cat=niños&action=listar" title="Ver todos los articulos de Niños">Niños</a> </li>
            <li><a href="ObtenerTodosProductos?cat=muebles&action=listar" title="Ver todos los articulos de Muebles">Muebles</a> </li>            
          </ul>
        </li>
        <li><a class="main-link" href="ObtenerBestSellers">Mas Vendidos</a>
          <ul class="sub-links">
            <li ><a href="ObtenerBestSellers" title="Best sellers">Ver articulos mas vendidos</a> </li>            
          </ul>
        </li>
        <li><a class="main-link" href="LoginUsuario">Usuario</a>
          <ul class="sub-links">
          	<% if (session.getAttribute("usuario")==null) { %>
				<li><a href="LoginUsuario" title="Login">Login</a> </li>
			<%}else{ %>	 
				<li><a href="LogoutUsuario" title="Logout">Logout</a> </li>
				<li><a href="Carrito" title="Carrito">Ver Carrito</a> </li>
				<li><a href="TodosLosPedidos" title="Pedidos">Historial de Pedidos</a> </li>
            <%} %>            
          </ul>
        </li>
        <li><a class="main-link" href="ObtenerConfiguracion">Configuracion</a>
        	<ul class="sub-links">
            	<li><a href="ObtenerConfiguracion" title="Config">Ver Configuraciones</a></li>
            	<li><a href="agregarConfig.jsp" title="Agregar Config">Agregar Configuracion</a></li>
            </ul>
        </li>
         <li><a class="close" title="Click para cerrar" href="#">X</a></li>
      </ul>
    </div>
    <!-- End roundfg -->
    <b class="round"> <b class="round5"></b> <b class="round4"></b> <b class="round3"></b> <b class="round2"><b></b></b> <b class="round1"><b></b></b></b> </div>
  <!-- End main-handle-->
    <% if (session.getAttribute("usuario")!=null) { 
    		Usuario u = (Usuario) session.getAttribute("usuario");%>
    		<b style="color:#FFFFFF;font-family: sans-serif; text-align:right; font-size: x-small;">Usuario: <%=u.getMail() %></b>
   	<% } %>
 </div>

</body>
</html>