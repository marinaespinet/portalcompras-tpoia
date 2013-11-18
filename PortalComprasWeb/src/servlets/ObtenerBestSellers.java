package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bd.BusinessDelegate;
import entityBean.Articulo;

/**
 * Servlet implementation class ObtenerBestSellers
 */
@WebServlet("/ObtenerBestSellers")
public class ObtenerBestSellers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BusinessDelegate facade = BusinessDelegate.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObtenerBestSellers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /** Para usarlo con AJAX
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");

		List<Articulo> listaArticulos = new ArrayList<Articulo>();
		Articulo p1 = new Articulo(1, "uno", "uno", (float) 1.33, null, "algo", "algo", "china");
		listaArticulos.add(p1);

		Gson gson = new Gson();
		Type prodType = new TypeToken<List<Articulo>>() {}.getType();
		String jsonListaArticulos = gson.toJson(listaArticulos, prodType);
		
		PrintWriter out = response.getWriter();  
		out.print(jsonListaArticulos);
		out.flush();

	}
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String resultPage;

        try {
        	List<Articulo> bestSellers = facade.getBestSellers();        
        	resultPage = "/bestSellers.jsp";
	    	request.setAttribute("listado", bestSellers);
        }
        catch (Exception e) {
        	request.setAttribute("error", e.getMessage());
        	resultPage = "/error.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response);   

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
