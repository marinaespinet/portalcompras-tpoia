package ejb;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import entities.Venta;

/**
 * Session Bean implementation class AdministradorVentaBean
 */
@Stateful
@LocalBean
public class AdministradorVentaBean implements AdministradorVenta {

	/**
	 * Default constructor.
	 */

	private Map<Integer, Integer> articulosCantidad = new HashMap<Integer, Integer>();

	public AdministradorVentaBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Venta realizarVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarArticulo(int codigo, int cant) {
		if (articulosCantidad.containsKey(codigo)) {
			modificarCantidad(codigo, articulosCantidad.get(codigo) + cant);
		} else {
			articulosCantidad.put(codigo, cant);
		}
	}

	@Override
	public void quitarArticulo(int codigo) {
		articulosCantidad.remove(codigo);

	}

	@Override
	public void modificarCantidad(int codigo, int cantidad) {
		articulosCantidad.put(codigo, cantidad);

	}

}
