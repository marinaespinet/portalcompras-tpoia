package servicios;

import javax.ejb.Remote;

@Remote
public interface ServidorEstadoEntrega {

	public String notificarEntregaDespacho(int nro);
}
