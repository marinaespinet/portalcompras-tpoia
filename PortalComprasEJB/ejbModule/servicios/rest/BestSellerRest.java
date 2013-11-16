package servicios.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bestSeller")
public interface BestSellerRest {

	//Ejemplo recibiendo un parametro por GET
	@POST
	@Path("/procesar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String informarMasVendidos(String json);

}
