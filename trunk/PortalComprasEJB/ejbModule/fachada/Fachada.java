package fachada;
import java.util.List;

import javax.ejb.Local;

import DTO.ArticuloDTO;
import DTO.VentaDTO;
import entityBean.Articulo;
import entityBean.Config;
import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface Fachada {
	
	//usuario
	public boolean loguearUser(String dni, String pass);
	public Usuario obtenerUsuario(String dni);
	
	//articulo
	public List<Articulo> buscarArticulos(String criterio);
	public List<Articulo> buscarArticulos(String criterio, String orderBy, boolean asc);
	public Articulo buscarArticulo(int codigo);
	public List<Articulo> getArticulos();
	void asignarRanking(String json) throws Exception;
	public Articulo registrarArticulo(ArticuloDTO a);
	
	//venta
	public Venta getVentaByNro(int nro) throws Exception;
	public void cambiarEstadoVenta(int nro) throws Exception;
	public List<Venta> getVentasByUsuario(String  id);
	public void registrarVenta(Venta v) throws Exception;
	public List<Articulo> getBestSellers();
	
	
	//confi
	public List<Config> getConfigs();
	public void addConfig(Config c);
	public Config activarConfig(int c);
	public Config desactivarConfig(int c);
	public List<Config> getConfigsByFuncionalidad(String funcion);
	
	public String test();
	
	
}
