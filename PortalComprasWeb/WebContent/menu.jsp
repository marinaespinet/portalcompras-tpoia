<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.List"%>

<html>
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
        <li><a class="main-link" href="ObtenerTodosArticulos?action=listar">Articulos</a>
          <ul class="sub-links">
            <li><a href="ObtenerTodosArticulos?cat=moda&action=listar" title="Ver todos los articulos de Moda">Moda</a> </li>
            <li><a href="ObtenerTodosArticulos?cat=electro&action=listar" title="Ver todos los articulos de Electro">Electro</a> </li>
            <li><a href="ObtenerTodosArticulos?cat=niños&action=listar" title="Ver todos los articulos de Niños">Niños</a> </li>
            <li><a href="ObtenerTodosArticulos?cat=muebles&action=listar" title="Ver todos los articulos de Muebles">Muebles</a> </li>            
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
				<li><a href="TodasLasVentas" title="Ventas">Historial de Ventas</a> </li>
				<% if (((Usuario)session.getAttribute("usuario")).isAdministrador()) { %>
		        <li><a class="main-link" href="ObtenerConfiguracion">Configuracion</a>
		        	<ul class="sub-links">
		            	<li><a href="ObtenerConfiguracion" title="Config">Ver Configuraciones</a></li>
		            	<li><a href="agregarConfig.jsp" title="Agregar Config">Agregar Configuracion</a></li>
		            </ul>
		        </li>
            <%} }%>           
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
    		<b style="color:#FFFFFF;font-family: sans-serif; text-align:right; font-size: x-small;">Usuario: <%=u.getNombre() %></b>
   	<% } %>
 </div>

</body>
</html>