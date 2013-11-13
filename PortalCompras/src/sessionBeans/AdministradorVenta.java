package sessionBeans;

import java.util.HashMap;
import java.util.Map;

import negocio.Articulo;
import negocio.Venta;

import sessionBeans.interfaces.IAdministradorVenta;

public class AdministradorVenta implements IAdministradorVenta{
	
	//codigoArticulo:cantidad
	private Map<Integer, Integer> articulosCantidad = new HashMap<Integer, Integer>();
	
	public AdministradorVenta() {
	}
	
	public Venta realizarVenta() {
		Venta venta =  new Venta();
		
		VentaDao.registrarVenta(venta);
	}

	public void agregarArticulo(int codigo, int cant) {
		if(articulosCantidad.containsKey(codigo)){
			modificarCantidad(codigo, articulosCantidad.get(codigo)+cant);
		}else{
			articulosCantidad.put(codigo, cant);
		}
	}

	public void quitarArticulo(int codigo) {
		articulosCantidad.remove(codigo);
		
	}

	public void modificarCantidad(int codigo, int cantidad) {
		articulosCantidad.put(codigo, cantidad);
	}
	
	private Map<Integer, Articulo> getArticulosMapped(){
		return null;
	}
}
