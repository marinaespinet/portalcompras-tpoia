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

/**
 * Servlet implementation class ObtenerConfiguracion
 */
@WebServlet("/ObtenerConfiguracion")
public class ObtenerConfiguracion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private BusinessDelegate facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerConfiguracion() {
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
        
        if(request.getSession().getAttribute("usuario") ==null){
        	resultPage = "/login.jsp";
		}else{

        try {
        	List<Config> configs = facade.getConfigs();
        	resultPage = "/config.jsp";
        	request.setAttribute("listado", configs);
        }
        catch (Exception e) {
        	request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);  
		}
	}

}
