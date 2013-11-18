package servicios.rest;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fachada.Fachada;


@Path("/bestSeller")
@Stateless
public class BestSellerRestBean {

	@EJB
	private Fachada fachada;


	public BestSellerRestBean() {
		// TODO Auto-generated constructor stub
	}
	
	


	@POST
	@Path("/procesar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public String informarMasVendidos(String ranking) {
		try {
			//facade.asignarRanking(ranking);
			return "{\"response\":\"OK\", \"mensaje\":\"Actualizacion exitosa\"}";
		} catch (Exception e) { 
			return "{\"response\":\"ERROR\", \"mensaje\":\"" + e.getMessage()
					+ "\"}";
		}
	}

	@GET
	@Path("/test")
	public String test() {
		return fachada.test();
	}

}
