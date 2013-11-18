package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import tipoYEstados.ETipoArticulo;
import bd.BusinessDelegate;

/**
 * Servlet implementation class ObtenerTodasCategorias
 */
@WebServlet("/ObtenerTodasCategorias")
public class ObtenerTodasCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BusinessDelegate facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObtenerTodasCategorias() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<ETipoArticulo> tipos = facade.getTipoArticulos();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONArray list = new JSONArray();
		try {
			for (ETipoArticulo t : tipos) {
				JSONObject o = new JSONObject();
				o.put("Categoria", t.name());
				list.put(o);
			}
			list.write(response.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
