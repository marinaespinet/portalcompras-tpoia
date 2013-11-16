package sessionBean;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import entityBean.Articulo;
import entityBean.Usuario;
import entityBean.Venta;

/**
 * Session Bean implementation class AdministradorVentaBean
 */
@Stateful
public class AdministradorCarritoBean implements AdministradorCarrito {

	@EJB
	private AdministradorArticulo adminArticulo;
	@EJB
	private AdministradorNotificaciones adminNotificaciones;
	
	private Map<Integer, Integer> articulosCantidad = new HashMap<Integer, Integer>();

	private Usuario usuario;

	public AdministradorCarritoBean(Usuario u) {
		this.usuario = u;
	}

	public AdministradorCarritoBean() {
	}

	@Override
	public Venta realizarVenta() {
		// consultar bine este paso
		return null;
	}

	@Override
	public void agregarArticulo(int codigo, int cant) {
		if (articulosCantidad.containsKey(codigo)) {
			modificarCantidad(codigo, articulosCantidad.get(codigo) + cant);
			
		} else {
			articulosCantidad.put(codigo, cant);
			adminNotificaciones.notificarAgregadoArticuloCarrito(usuario, codigo, cant);
		}
		
	}

	@Override
	public void quitarArticulo(int codigo) {
		articulosCantidad.remove(codigo);
		adminNotificaciones.notificarBajaArticuloCarrito(usuario, codigo);

	}

	@Override
	public void modificarCantidad(int codigo, int cantidad) {
		if (cantidad <= 0) {
			quitarArticulo(codigo);
		} else {
			articulosCantidad.put(codigo, cantidad);
			adminNotificaciones.notificarModificacionesArticuloCarrito(usuario, codigo, cantidad);
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
