package sessionBean;

import java.util.List;

import javax.ejb.Local;

import DTO.ItemCantidadDTO;
import entityBean.Articulo;
import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface AdministradorCarrito {

	public Venta realizarVenta() throws Exception;

	public void agregarArticulo(int codigo, int cant);

	public void quitarArticulo(int codigo);

	public void modificarCantidad(int codigo, int cantidad);

	public void setUsuario(Usuario u);
	public Usuario getUsuario();
	public List<ItemCantidadDTO> getItemsCarrito();

	public ItemCantidadDTO getItemCantidadDTO(Articulo articulo);

}
