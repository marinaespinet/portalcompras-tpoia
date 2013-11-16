package servicios.rest;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import fachada.Fachada;


@Stateless
public class BestSellerRestBean implements BestSellerRest{
	
	@EJB
	private Fachada facade;

	/**
	 * Default constructor.
	 */
	public BestSellerRestBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String informarMasVendidos(String ranking) {
		try {
			facade.asignarRanking(ranking);
			return "{\"response\":\"OK\", \"mensaje\":\"Actualizacion exitosa\"}";
		} catch (Exception e) { 
			return "{\"response\":\"ERROR\", \"mensaje\":\"" + e.getMessage()
					+ "\"}";
		}
	}

}
