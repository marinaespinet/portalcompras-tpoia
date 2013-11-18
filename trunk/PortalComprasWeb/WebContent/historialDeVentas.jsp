<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.*"%>
<%@page import="DTO.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tabla1.css">
<title>Portal Compras - Grupo 2</title>
<link rel="stylesheet" href="css/navbar.css" type="text/css" />
<link rel="stylesheet" href="css/tabla1.css">
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
<h1>Historial de Ventas</h1>
<div class="datagrid"><table>
<thead><tr><th>Id Venta</th><th>Estado</th><th>Fecha</th><th>Contenido</th></tr></thead>
<tbody>
    <%  
    	List<Venta> Ventas= (List<Venta>)request.getAttribute("Ventas"); 
		Iterator<Venta> itPed = Ventas.iterator();
    	int rotar = 0;
    	String clase = "";
		while (itPed.hasNext()){
			Venta Venta = itPed.next();
			if (rotar % 2 != 0)
				clase = "\"alt\"";
			else
				clase = "\"\"";
	%>
            <tr class=<%=clase %>>
            <td><%=Venta.getNroVenta()%></td>
            <td><%=Venta.getEstado()%></td>
            <td><%=Venta.getFecha()%></td>
            <td>
            	<%
            		Iterator<ItemCantidadDTO> itemsPed = Venta.getItems().iterator();
            		while (itemsPed.hasNext()) {
            			ItemCantidadDTO ped = itemsPed.next();
            	%>	
            		<%=ped.toString() %><br>	
            	<%		
            		}
            	%>
            </td>
            </tr>
    <%  
    		rotar++;
		} 
    %> 
</tbody>
</table></div>


</body>
</html>