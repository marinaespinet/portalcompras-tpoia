<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.List"%>

<%
	Usuario u = (Usuario) session.getAttribute("usuario");
%>
<html>
<body>

	<%
		if (u != null) {
	%>
	<div
		style="margin-right: 200px; margin-top: 10px; color: #999999; font-family: sans-serif; text-align: right; font-size: 12px; font-weight: bold;">
		Usuario:
		<%=u.getNombre()%> - <a href="LogoutUsuario" title="Logout">Logout</a></div>
	<%
		}else{
	%><div
		style="margin-right: 200px; margin-top: 10px; color: #999999; font-family: sans-serif; text-align: right; font-size: 12px; font-weight: bold;">
		<a href="LoginUsuario" title="Login">Login</a></div>
		<%} %>
	
	<!-- Start sub-link-bar -->
	<div id="sub-link-bar"></div>
	<!-- End sub-link-bar -->

	<!-- Start wrap -->
	<div id="wrap">
		<div id="main-handle">
			<div class="roundfg">
				<ul id="main-nav">
					<li><a class="main-link" href="index.jsp">Inicio</a>
						<ul class="sub-links">
							<li><a href="index.jsp">Inicio</a></li>
						</ul></li>
					<li><a class="main-link"
						href="ObtenerTodosArticulos?action=listar">Articulos</a>
						<ul class="sub-links">
							<li><a href="ObtenerTodosArticulos?cat=Moda&action=listar"
								title="Ver todos los articulos de Moda">Moda</a></li>
							<li><a
								href="ObtenerTodosArticulos?cat=Electrodomestico&action=listar"
								title="Ver todos los articulos de Electro">Electrodomesticos</a></li>
							<li><a href="ObtenerTodosArticulos?cat=Nino&action=listar"
								title="Ver todos los articulos de Niños">Niños</a></li>
							<li><a
								href="ObtenerTodosArticulos?cat=Mueble&action=listar"
								title="Ver todos los articulos de Muebles">Muebles</a></li>
						</ul></li>
					<li><a class="main-link" href="ObtenerBestSellers">Mas
							Vendidos</a>
						<ul class="sub-links">
							<li><a href="ObtenerBestSellers" title="Best sellers">Ver
									articulos mas vendidos</a></li>
						</ul></li>
						 <%
 	if (u != null) {
 %>
					<li><a href="Carrito" title="Carrito">Ver Carrito</a></li>
					<li><a href="TodasLasCompras" title="Ventas">Historial de
							Compras</a></li>
					<%
						if (u.isAdministrador()) {
					%>
					<li><a class="main-link" href="ObtenerConfiguracion">Configuracion</a>
						<ul class="sub-links">
							<li><a href="ObtenerConfiguracion" title="Config">Ver
									Configuraciones</a></li>
							<li><a href="agregarConfig.jsp" title="Agregar Config">Agregar
									Configuracion</a></li>
						</ul></li>
					<%
						}
						}
					%>

					<!--</li >
         <li style="margin-left:515px;"><a class="close" title="Click para cerrar" href="#">SALIR</a></li> -->
				</ul>
			</div>
			<!-- End roundfg -->
			<b class="round"> <b class="round5"></b> <b class="round4"></b> <b
				class="round3"></b> <b class="round2"><b></b></b> <b class="round1"><b></b></b></b>
		</div>
		<!-- End main-handle-->

	</div>
	<!-- End wrap -->

</body>
</html>