package sessionBean;

import javax.ejb.Local;

import DTO.ResultadoDTO;

import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface AdministradorNotificaciones {
	public void notificarAgregadoArticuloCarrito(Usuario u, int codArt, int cant) throws Exception;
	public void notificarBajaArticuloCarrito(Usuario u, int codArt) throws Exception;
	public void notificarModificacionesArticuloCarrito(Usuario u, int codArt, int cant) throws Exception;
	public void notificarCambioEstadoVenta(Usuario u, Venta v, String s) throws Exception;
	public ResultadoDTO informarVenta(Usuario u, Venta v) throws Exception;
}
