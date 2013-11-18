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

import com.google.gson.Gson;

import entities.Categoria;
import entities.Articulo;
import bd.BusinessDelegate;
import beans.interfaces.BusinessFacade;

/**
 * Servlet implementation class ObtenerTodasCategorias
 */
@WebServlet("/ObtenerTodasCategorias")
public class ObtenerTodasCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BusinessDelegate facade = BusinessDelegate.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerTodasCategorias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
		response.setContentType("text/html;charset=UTF-8");
        
        String resultPage = "/cab.jsp";
        List<Categoria> categorias = facade.todasCategorias();
        request.setAttribute("categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);
        */ 
		List<Categoria> categorias = facade.todasCategorias();		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(categorias));
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
