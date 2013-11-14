package servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import parsers.FromObjectToXml;

import fachada.Fachada;

@Stateless
@WebService
public class WebServiceFacadeBean implements WebServiceFacade {
	@EJB
	private Fachada fachada;
	
    public WebServiceFacadeBean() {}
    
    @WebMethod
	public String getListaPrecios(){
		FromObjectToXml f = new FromObjectToXml();
	 	return f.listaDePrecios(fachada.obtenerListaPrecios());
	}
}
