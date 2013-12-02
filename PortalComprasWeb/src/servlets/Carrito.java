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

import sessionBean.AdministradorCarrito;
import DTO.ItemCantidadDTO;
import bd.BusinessDelegate;
import entityBean.Articulo;
import entityBean.Usuario;

/**
 * Servlet implementation class Carrito
 */
@WebServlet("/Carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HttpSession session;
	@EJB
	private BusinessDelegate facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Carrito() {
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
		session = request.getSession();
		String resultPage = null;
		if (request.getSession().getAttribute("usuario") == null) {
			resultPage = "/login.jsp";
		} else {
			resultPage = "/carrito.jsp";
			String action = request.getParameter("action");
			String mensaje = null;
			try {
				AdministradorCarrito carrito = (AdministradorCarrito) session
						.getAttribute("carrito");

				if (request.getParameter("delete") != null) {
					action = "delete";
				}
				if (request.getParameter("save") != null) {
					action = "save";
				}

				if (action == null || action.length() < 1) {
					action = "default";
				}

				if ("delete".equals(action)) {
					Integer id = Integer.valueOf(request.getParameter("id"));
					try{
						carrito.quitarArticulo(id);
					}catch (Exception e) {
						mensaje = e.getMessage();
					}
					List<ItemCantidadDTO> items = carrito.getItemsCarrito();
					request.setAttribute("items", items);
				}
				if ("add".equals(action)) {
						Integer cantidad = Integer.valueOf(request
								.getParameter("cantidad"));
						Integer id = Integer
								.valueOf(request.getParameter("id"));
						try{
							carrito.agregarArticulo(id, cantidad);
						}catch (Exception e) {
							mensaje = e.getMessage();
						}
						List<ItemCantidadDTO> items = carrito.getItemsCarrito();
						request.setAttribute("items", items);
				}
				if ("update".equals(action)) {
					Integer id = Integer.valueOf(request.getParameter("id"));
					Integer cantidad = Integer.valueOf(request
							.getParameter("cantidad"));
					try{
						carrito.modificarCantidad(id, cantidad);
					}catch (Exception e) {
						mensaje = e.getMessage();
					}

					List<ItemCantidadDTO> items = carrito.getItemsCarrito();
					request.setAttribute("items", items);
				}
				if ("save".equals(action)) {
					Usuario u = (Usuario) session.getAttribute("usuario");
					
					try {
						carrito.realizarVenta();
						request.setAttribute("mensaje",
								"Compra realizada exitosamente.");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						request.setAttribute("mensaje", e.getMessage());
					}
				}

				if ("default".equals(action)) {
					List<ItemCantidadDTO> items = carrito.getItemsCarrito();
					resultPage = "/carrito.jsp";
					request.setAttribute("items", items);

				}
				
				if(mensaje!=null){
					request.setAttribute("mensaje",
							 mensaje);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("mensaje",
						"Ah ocurrido un error inesperado: " + e.getMessage());
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(resultPage);
		rd.forward(request, response);
	}

}
