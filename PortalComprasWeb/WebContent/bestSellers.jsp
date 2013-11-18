<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entityBean.Articulo"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/tabla1.css">
<<jsp:include page="head.jsp" flush="true" />
<body>
<jsp:include page="menu.jsp" flush="true" />
<br><br><br>
<h1>Articulos Mas Vendidos</h1>
<div class="datagrid"><table>
<thead><tr><th>Ranking</th><th>Nombre</th></tr></thead>
<tbody>
    <%  
        List<Articulo> Articulos= (List<Articulo>)request.getAttribute("listado"); 
    	Iterator<Articulo> itProd = Articulos.iterator();
    	int rotar = 0;
    	String clase = "";
		while (itProd.hasNext()){
			Articulo articulo = itProd.next();
			if (rotar % 2 != 0)
				clase = "\"alt\"";
			else
				clase = "\"\"";
	%>
            <tr class=<%=clase %>>
            <td><%=articulo.getPosicion()%></td>
            <td><a href="ObtenerArticulo?id=<%=articulo.getCodigo()%>"><%=articulo.getNombre()%></a></td>
            </tr>
    <%  
    		rotar++;
		} 
    %>   
</tbody>
</table></div>

</body>
</html>