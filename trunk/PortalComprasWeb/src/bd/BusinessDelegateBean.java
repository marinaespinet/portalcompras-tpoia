package bd;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

import tipoYEstados.ETipoArticulo;

import entityBean.Articulo;
import entityBean.Config;
import entityBean.ConfigAsincronica;
import entityBean.ConfigSincronica;
import entityBean.Usuario;
import entityBean.Venta;
import fachada.Fachada;

@Stateless
@Singleton
public class BusinessDelegateBean implements BusinessDelegate {
	
	@EJB
	private Fachada fachada;
	
	private BusinessDelegateBean() {
		
	}
	
	public List<Articulo> getBestSellers() {
		return fachada.getBestSellers();
	}
	
	public boolean loginValido(String userDni, String password){
		return fachada.loguearUser(userDni, password);
	}
	
	public Usuario obtenerUsuario(String userDni){
		return fachada.obtenerUsuario(userDni);
	}

	
	public List<Articulo> getArticulos() {
		return fachada.getArticulos();
	}
	
	public List<Articulo> busquedaArticulos(String criterioBusqueda) {
		return fachada.buscarArticulos(criterioBusqueda);
	}
	
	public List<Venta> todosLosPedidos(Usuario usuario) {
		return fachada.getVentasByUsuario(usuario.getDni());
	}

//TODO:AGUS de aca para abajo te agregue todos los metodos probalo si funca!
	public void nuevaConfiguracion(ConfigSincronica sync) {
		fachada.addConfig(sync);
		
	}

	public void nuevaConfiguracion(ConfigAsincronica async) {
		fachada.addConfig(async);
		
	}

	public List<Config> getConfigs() {
		return fachada.getConfigs();
	}

	public Articulo getArticuloPorId(int codigo) {
		return fachada.buscarArticulo(codigo);
	}

	public void activarConfiguracion(int config) {
		fachada.activarConfig(config);
		
	}

	public void desactivarConfiguracion(int i) {
		fachada.desactivarConfig(i);
		
	}

	public List<Venta> getVentasByUsuario(Usuario usuario) {
		return fachada.getVentasByUsuario(usuario.getDni());
	}

	public List<Articulo> todosArticulos() {
		return fachada.getArticulos();
	}

	public List<Articulo> getArticulosPorTipo(ETipoArticulo tipo) {
		return fachada.getArticulosPorTipo(tipo);
	}
	
	@Override
	public List<ETipoArticulo> getTipoArticulos() {
		return fachada.getTipoArticulos();
	}
}
