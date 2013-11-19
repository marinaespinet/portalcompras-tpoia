package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sessionBean.AdministradorCarrito;
import DTO.ItemCantidadDTO;
import bd.BusinessDelegate;
import entityBean.Articulo;

/**
 * Servlet implementation class ObtenerArticuloCarrito
 */
@WebServlet("/ObtenerArticuloCarrito")
public class ObtenerArticuloCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BusinessDelegate facade;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerArticuloCarrito() {
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
        String resultPage = "/detalleItemCarri.jsp";
        HttpSession session = request.getSession();
        AdministradorCarrito carrito = (AdministradorCarrito)session.getAttribute("carrito");
        
    	Integer id = Integer.valueOf(request.getParameter("id"));
    	try {
    		Articulo articulo = facade.getArticuloPorId(id);
			ItemCantidadDTO item = carrito.getItemCantidadDTO(articulo);
	    	request.setAttribute("articulo", item);
    	}
    	catch (Exception e) {
        	request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
    	}
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);
	}

}
