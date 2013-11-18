package servicios;

import java.rmi.RemoteException;

import javax.ejb.Remote;

@Remote
public interface ServidorEstadoEntrega {

	public String notificarEntregaDespacho(int nro) throws RemoteException, Exception;
}
