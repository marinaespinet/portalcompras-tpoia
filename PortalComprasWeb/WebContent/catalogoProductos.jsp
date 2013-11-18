<%@page import="util.FechaUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tablesorter.css" type="text/css" id="" media="print, projection, screen" />
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
<script type="text/javascript" src="js/jquery-latest.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter.js"></script> 
<script type="text/javascript" id="js">$(document).ready(function() {
	// call the tablesorter plugin
	$("table").tablesorter({
		// sort on the first column and third column, order asc
		sortList: [[0,0],[2,0]]
	});
});
</script>
<title>Portal Compras</title>
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
        <li><a class="main-link" href="ObtenerTodosProductos?action=listar">Articulos</a>
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
  <br><br><br>
    <h1>Articulos</h1>
	<form action="BusquedaProducto" method="post">
	<fieldset style="float: left; padding: 2em">
	<legend style="color:#FFFFFF;font-family: sans-serif">Ingrese datos del articulo</legend>
	<table border="0" cellpadding="0" width="50" bgcolor="#2d2620">
	<tr>
	<td><label for="Buscar" style="color:#FFFFFF;font-family: sans-serif">Buscar :</label></td>
	<td><input type="text" name="criterio" value="" maxlength="100" /></td>
	</tr>
	</table>
	</fieldset>
	</form>
	<br><br><br>
  <div><table id="prods" class="tablesorter">
<thead><tr><th>Nombre</th><th>Marca</th><th>Precio</th><th>Ranking</th><th>Categoria</th><th>Fecha</th></tr></thead>
<tbody>
    <%  
        List<Articulo> productos= (List<Articulo>)request.getAttribute("listado"); 
    	Iterator<Articulo> itProd = productos.iterator();
    	int rotar = 0;
    	String clase = "";
		while (itProd.hasNext()){
			Articulo articulo = itProd.next();
			if (rotar % 2 != 0)
				clase = "\"alt\"";//System.out.println("<tr class=\"alt\">");
			else
				clase = "\"\"";//System.out.println("<tr>");
	%>
            <tr class=<%=clase %>>
            <td><a href="ObtenerProducto?id=<%=articulo.getCodigo()%>"><%=articulo.getNombre()%></a></td>
            <td><%=articulo.getMarca()%></td>
            <td><%=articulo.getPrecio()%></td>
            <td><%=articulo.getPosicion()%></td>
            <td><%=articulo.getTipo().toString()%></td>
            <td><%=FechaUtil.toStringXml(articulo.getFecha()) %></td>
            </tr>
    <%  
    		rotar++;
		} 
    %>   
</tbody>
</table></div>
<br>
 </div>
<!-- End wrap -->


</body>
</html>