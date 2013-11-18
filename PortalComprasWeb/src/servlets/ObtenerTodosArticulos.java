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

import tipoYEstados.ETipoArticulo;

import bd.BusinessDelegate;
import entityBean.Articulo;

/**
 * Servlet implementation class ObtenerTodosArticulos
 */
@WebServlet("/ObtenerTodosArticulos")
public class ObtenerTodosArticulos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BusinessDelegate facade;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerTodosArticulos() {
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
        
        String resultPage = "/catalogoArticulos.jsp";
        List<Articulo> listado;
		String action = request.getParameter("action");
        if (action == null || action.length() < 1) {
        	action = "default";
        }
        if (action.equals("listar")){
        	try {
        		String tipoBuscado = request.getParameter("cat");
        		if (tipoBuscado == null || tipoBuscado.length() < 1) {
        			listado = facade.todosArticulos();  
        			request.setAttribute("listado", listado);
        		}
        		else {
        			ETipoArticulo categoria = ETipoArticulo.valueOf(tipoBuscado);
        			listado = facade.getArticulosPorTipo(categoria);
        			request.setAttribute("listado", listado);
        		}				
        	} catch (Exception e){
            	request.setAttribute("error", e.getMessage());
            	resultPage = "/error.jsp";
        	}
		}
        else {
        	resultPage = "/index.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response); 

	}

}
