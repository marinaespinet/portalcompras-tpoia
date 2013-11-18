package bd;

import java.util.List;

import tipoYEstados.ETipoArticulo;
import entityBean.Articulo;
import entityBean.Config;
import entityBean.ConfigAsincronica;
import entityBean.ConfigSincronica;
import entityBean.Usuario;
import entityBean.Venta;

public interface BusinessDelegate {


	public List<Articulo> getBestSellers();
	
	public boolean loginValido(String userDni, String password);
	
	public Usuario obtenerUsuario(String userDni);
	
	public List<Articulo> getArticulos();
	
	public List<Articulo> busquedaArticulos(String criterioBusqueda);
	
	public List<Venta> todosLosPedidos(Usuario usuario);

	public void nuevaConfiguracion(ConfigSincronica sync) ;
	public void nuevaConfiguracion(ConfigAsincronica async);

	public List<Config> getConfigs();

	public Articulo getArticuloPorId(int codigo);

	public void activarConfiguracion(int config);

	public void desactivarConfiguracion(int i) ;

	public List<Venta> getVentasByUsuario(Usuario usuario);

	public List<Articulo> todosArticulos();

	public List<Articulo> getArticulosPorTipo(ETipoArticulo tipo) ;

	public List<ETipoArticulo> getTipoArticulos();
	
}
