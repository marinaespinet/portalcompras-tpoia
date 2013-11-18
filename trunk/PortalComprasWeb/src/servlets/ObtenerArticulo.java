package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BusinessDelegate;
import entityBean.Articulo;

/**
 * Servlet implementation class ObtenerArticulo
 */
@WebServlet("/ObtenerArticulo")
public class ObtenerArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BusinessDelegate facade;
	

    public ObtenerArticulo() {
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
		String resultPage = "/detalleArticulo.jsp";        
        
    	Integer id = Integer.valueOf(request.getParameter("id"));
    	try {
    		Articulo producto = facade.getArticuloPorId(id);
	    	request.setAttribute("producto", producto);
    	}
    	catch (Exception e) {
        	request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
    	}
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response); 
	}

}
