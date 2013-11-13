package sessionBeans.interfaces;

import negocio.Venta;

public interface IAdministradorVenta {

	public Venta realizarVenta();
	public void agregarArticulo(int codigo, int cant);
	public void quitarArticulo(int codigo);
	public void modificarCantidad(int codigo, int cantidad);
	
}
