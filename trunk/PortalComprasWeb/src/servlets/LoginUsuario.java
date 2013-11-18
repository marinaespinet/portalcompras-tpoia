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
import bd.BusinessDelegate;
import entityBean.Usuario;

/**
 * Servlet implementation class LoginUsuario
 */
@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	@EJB
	private BusinessDelegate facade;
	
	@EJB
	private AdministradorCarrito carrito;
	
    private HttpSession session;
    
    public LoginUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession();
        
        String resultPage = "/login.jsp";
        
		String action = request.getParameter("action");
        if (action == null || action.length() < 1) {
        	action = "default";
        }
        if (action.equals("login")){
        	try {
        		String userMail = request.getParameter("usuario");        		
        		String password = request.getParameter("password");
			
				if (facade.loginValido(userMail, password)){
					Usuario u = facade.obtenerUsuario(userMail);
					session.setAttribute("usuario", u);
					session.setAttribute("carrito", carrito);
					resultPage = "/index.jsp";
				}else{
					request.setAttribute("error", "El usuario y password no coinciden!");
				}			 
        	} catch (Exception e){
        		e.printStackTrace();
        		//TODO: Poner excepcion
        	}
		}
        
        RequestDispatcher rd = request.getRequestDispatcher(resultPage);
        rd.forward(request, response); 
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}
}
