<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entities.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tabla1.css">
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
</head>
<body>
<jsp:include page="cab.jsp" flush="true" />
<h1>Tabla de Configuración</h1>
<div class="datagrid"><table>
<thead><tr>
<th>Id</th>
<th>Tipo</th>
<th>Estado</th>
<th>Funcionalidad</th>
<th>Nombre</th>
<th>IP</th>
<th>Puerto</th>
<th>URL</th>
<th>User</th>
<th>Password</th>
<th>Cambiar Estado?</th>
 
</tr></thead>
<tbody>
    <%  
        List<Configuracion> configs = (List<Configuracion>)request.getAttribute("listado"); 
    	Iterator<Configuracion> itConf = configs.iterator();
    	int rotar = 0;
    	String clase = "";
    	String accionEstado = "";
    	String estado = "";
		while (itConf.hasNext()){
			Configuracion conf = itConf.next();
			if (rotar % 2 != 0)
				clase = "\"alt\"";
			else
				clase = "\"\"";
			if (conf.isActivo()) {
				accionEstado = "Desactivar";
				estado = "Activo";
			}
			else {
				accionEstado = "Activar";
				estado = "Inactivo";
			}
	%>
            <tr class=<%=clase %>>
            <td><%=conf.getId()%></td>
            <td><%=conf.getClass().getSimpleName()%></td>
            <td><%=estado%></td>
            <td><%=conf.getFuncionalidad()%></td>
            <td><%=conf.getNombre()%></td>
            <td><%=conf.getIp()%></td>
            <td><%=conf.getPuerto()%></td>
            <% 
            	if (conf.getClass().getSimpleName().equals("ConfiguracionAsincronica")) {
            		ConfiguracionAsincronica asinc = (ConfiguracionAsincronica) conf;
            %>
            		<td>N/A</td>
            		<td><%=asinc.getUser() %></td>
            		<td><%=asinc.getPassword() %></td>
            <%
            	}
            	else {
            		ConfiguracionSincronica sinc = (ConfiguracionSincronica) conf;
            %>
            		<td><%=sinc.getUrl()%></td>
            		<td>N/A</td>
            		<td>N/A</td>
            <%		
            	}
            %>
            <td><a href="ModificarEstadoConf?accion=<%=accionEstado %>&id=<%=conf.getId()%>"><%=accionEstado%></a></td>
            </tr>
    <%  
    		rotar++;
		} 
    %>   
</tbody>
</table></div>
<br>

</body>
</html>