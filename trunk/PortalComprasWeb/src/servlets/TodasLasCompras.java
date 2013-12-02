package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
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
@WebServlet("/TodasLasCompras")
public class TodasLasCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BusinessDelegate facade;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodasLasCompras() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String resultPage = "/historialDeCompras.jsp";
		if (request.getSession().getAttribute("usuario") == null) {
			resultPage = "/login.jsp";
		} else {
			List<Venta> ventas;
			try {
				session = request.getSession();
				Usuario usuario = (Usuario) session.getAttribute("usuario");

				ventas = facade.getVentasByUsuario(usuario);
				request.setAttribute("ventas", ventas);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				resultPage = "/error.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(resultPage);
		rd.forward(request, response);
	}

}
