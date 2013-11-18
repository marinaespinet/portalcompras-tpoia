package fachada;
import java.util.List;

import javax.ejb.Local;

import DTO.ArticuloDTO;
import DTO.UsuarioDTO;
import DTO.VentaDTO;
import entityBean.Articulo;
import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface Fachada {
	
	//usuario
	public boolean loguearUser(String dni, String pass);
	public UsuarioDTO obtenerUsuario(String dni);
	
	//articulo
	public List<ArticuloDTO> buscarArticulos(String criterio);
	public ArticuloDTO buscarArticulo(int codigo);
	public List<ArticuloDTO> getArticulos();
	void asignarRanking(String json);
	public Articulo registrarArticulo(ArticuloDTO a);
	
	
	
	//venta
	public VentaDTO getVentaByNro(int nro);
	public Venta cambiarEstado(int nro, String estado);
	public List<Venta> getVentasByUsuario(int  id);
	public void registrarVenta(Venta v);

	
	public String test();
	
	
	/*Pedido*/
	public Pedido consultaEstado(int nroPedido);
	public String cambioEstado (int nroPedido);
	public List<Pedido> todosPedidos (Usuario usuario);	
	
	/*Producto*/
	public List<Producto> busquedaProductos(String criterioBusqueda);
	public List<Producto> todosProductos();
	public List<Producto> getBestSellers();
	public Producto getProductoPorId(Producto producto);
	public void nuevoProducto(Producto producto);
	public Categoria getCategoria(String nombre);
	public void nuevaCategoria(Categoria categoria);
	public List<Producto> getProductosPorCategoria(Categoria categoria);
	public List<Categoria> todasCategorias();
	public void procesarBestSellers(ListaBestSeller bestSellers);
	
	/*Usuario*/
	public boolean loginValido (String userMail, String password);
	public Usuario obtenerUsuario (String userMail);
	
	/*Configuracion*/
	public List<Configuracion> todasConfiguraciones();
	public void activarConfiguracion(Configuracion configuracion);
	public void desactivarConfiguracion(Configuracion configuracion);
	public void nuevaConfiguracion(Configuracion configuracion);
}
