package ejb;

import javax.ejb.Local;
import entities.Venta;

@Local
public interface AdministradorVenta {

	public Venta realizarVenta();

	public void agregarArticulo(int codigo, int cant);

	public void quitarArticulo(int codigo);

	public void modificarCantidad(int codigo, int cantidad);

}
