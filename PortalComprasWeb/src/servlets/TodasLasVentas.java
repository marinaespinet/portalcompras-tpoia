package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bd.BusinessDelegate;
import entityBean.Usuario;
import entityBean.Venta;

/**
 * Servlet implementation class TodosLosPedidos
 */
@WebServlet("/TodasLasVentas")
public class TodasLasVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	private BusinessDelegate facade = BusinessDelegate.getInstance();
	private HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodasLasVentas() {
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
        String resultPage = "/historialDeVentas.jsp";
        
        List<Venta> ventas;
        try {
        	session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			ventas = facade.getVentasByUsuario(usuario);
	    	request.setAttribute("ventas", ventas);
        }
        catch (Exception e) {        
        	request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);   
	}

}
