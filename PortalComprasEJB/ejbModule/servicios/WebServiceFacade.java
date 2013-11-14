package servicios;

import javax.ejb.Remote;

@Remote
public interface WebServiceFacade {
	public String getListaPrecios();
}
