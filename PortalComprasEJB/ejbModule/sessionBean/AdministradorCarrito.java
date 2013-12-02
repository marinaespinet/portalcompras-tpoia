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

	public void agregarArticulo(int codigo, int cant) throws Exception;

	public void quitarArticulo(int codigo) throws Exception;

	public void modificarCantidad(int codigo, int cantidad) throws Exception;

	public void setUsuario(Usuario u);
	public Usuario getUsuario();
	public List<ItemCantidadDTO> getItemsCarrito() throws Exception;

	public ItemCantidadDTO getItemCantidadDTO(Articulo articulo) throws Exception;

}
