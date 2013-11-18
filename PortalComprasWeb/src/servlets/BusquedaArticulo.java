package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BusinessDelegate;
import entityBean.Articulo;

/**
 * Servlet implementation class BusquedaArticulo
 */
@WebServlet("/BusquedaArticulo")
public class BusquedaArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BusinessDelegate facade = BusinessDelegate.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaArticulo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String resultPage;
		String criterio = request.getParameter("criterio");
        
		try {
			List<Articulo> resultado = facade.busquedaArticulos(criterio);
	    	resultPage = "/catalogoArticulos.jsp";
	    	request.setAttribute("listado", resultado);
		}
		catch (Exception e) {
			request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
		}
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);   


	}

}
