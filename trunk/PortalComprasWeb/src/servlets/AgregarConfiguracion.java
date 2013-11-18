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

import bd.BusinessDelegate;
import entityBean.Config;
import entityBean.ConfigAsincronica;
import entityBean.ConfigSincronica;

/**
 * Servlet implementation class AgregarConfiguracion
 */
@WebServlet("/AgregarConfiguracion")
public class AgregarConfiguracion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BusinessDelegate facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarConfiguracion() {
		super();
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
		String resultPage;
		if (request.getSession().getAttribute("usuario") == null) {
			resultPage = "/login.jsp";
		} else {

			try {
				String tipo = request.getParameter("tipo");
				if (tipo.equals("sync")) {
					ConfigSincronica sync = new ConfigSincronica();
					sync.setId(null);
					sync.setActivado(true);
					sync.setFuncionalidad(request.getParameter("funcionalidad"));
					sync.setIp(request.getParameter("ip"));
					sync.setNombre(request.getParameter("nombre"));
					sync.setPuerto(request.getParameter("puerto"));
					sync.setUrl(request.getParameter("url"));
					facade.nuevaConfiguracion(sync);
				} else {
					ConfigAsincronica async = new ConfigAsincronica();
					async.setId(null);
					async.setActivado(true);
					async.setFuncionalidad(request
							.getParameter("funcionalidad"));
					async.setIp(request.getParameter("ip"));
					async.setNombre(request.getParameter("nombre"));
					async.setPuerto(request.getParameter("puerto"));
					async.setPassword(request.getParameter("password"));
					async.setUser(request.getParameter("usuario"));
					facade.nuevaConfiguracion(async);
				}

				List<Config> configs = facade.getConfigs();
				resultPage = "/config.jsp";
				request.setAttribute("listado", configs);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				resultPage = "/error.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(resultPage);
		rd.forward(request, response);
	}

}
