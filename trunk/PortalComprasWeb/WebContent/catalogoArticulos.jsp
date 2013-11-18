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

<jsp:include page="head.jsp" flush="true" />
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
</head>
<body>

    <jsp:include page="menu.jsp"/>
  <br><br><br>
    <h1>Articulos</h1>
	<form action="BusquedaArticulo" method="post">
	<fieldset style="float: left; padding: 2em">
	<legend style="color:#FFFFFF;font-family: sans-serif">Ingrese datos del articulo</legend>
	<table border="0" cellpadding="0" width="100" bgcolor="#444444">
	<tr>
	<td ><label for="Buscar" style="color:#FFFFFF;font-family: sans-serif">Buscar :</label></td>
	<td><input type="text" name="criterio" value="" maxlength="100" /></td>
		
	</tr>
	<tr><td><input type="submit" name="buscar" value="" maxlength="100" /></td></tr>
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
            <td><a href="ObtenerArticulo?id=<%=articulo.getCodigo()%>"><%=articulo.getNombre()%></a></td>
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