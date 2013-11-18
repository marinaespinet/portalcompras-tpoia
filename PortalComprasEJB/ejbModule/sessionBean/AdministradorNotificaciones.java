package sessionBean;

import javax.ejb.Local;

import DTO.ResultadoDTO;

import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface AdministradorNotificaciones {
	public void notificarAgregadoArticuloCarrito(Usuario u, int codArt, int cant);
	public void notificarBajaArticuloCarrito(Usuario u, int codArt);
	public void notificarModificacionesArticuloCarrito(Usuario u, int codArt, int cant);
	public void notificarCambioEstadoVenta(Usuario u, Venta v, String s);
	public ResultadoDTO informarVenta(Usuario u, Venta v) throws Exception;
}
