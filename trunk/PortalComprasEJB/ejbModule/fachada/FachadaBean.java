package fachada;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.json.JSONException;

import sessionBean.AdministradorArticulo;
import sessionBean.AdministradorConfiguracion;
import sessionBean.AdministradorNotificaciones;
import sessionBean.AdministradorUsuario;
import sessionBean.AdministradorVenta;
import tipoYEstados.ETipoArticulo;
import util.TransformerUtil;
import DTO.ArticuloDTO;
import entityBean.Articulo;
import entityBean.Config;
import entityBean.Direccion;
import entityBean.Usuario;
import entityBean.Venta;

@Stateless
public class FachadaBean implements Fachada, Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private AdministradorNotificaciones adminNotificaciones;
	@EJB
	private AdministradorUsuario adminUsuario;
	@EJB
	private AdministradorConfiguracion adminConfiguracion;
	@EJB
	private AdministradorArticulo adminArticulo;
	@EJB
	private AdministradorVenta adminVenta;

	public FachadaBean() {
		Usuario u = new Usuario();
		u.setAdministrador(true);
		u.setCoordenadaX(123124423);
		u.setCoordenadaY(123124213);
		u.setDireccion(new Direccion("prov", "ciud", "calle", 1,"depto"));
		u.setDni("1234");
		u.setMail("sfsa@asdas.com");
			u.setNombre("Hernan Escola");
			u.setPassword("1234");
		adminUsuario.registrar(u);
	}

	@Override
	public List<Articulo> buscarArticulos(String criterio) {
		return adminArticulo.buscarArticulos(criterio);
	}

	@Override
	public Articulo buscarArticulo(int codigo) {
		return adminArticulo.buscarArticulo(codigo);
	}

	@Override
	public List<Articulo> getArticulos() {
		return adminArticulo.getArticulos();
	}

	@Override
	public void asignarRanking(String json) throws JSONException, Exception {
		adminArticulo.asignarRanking(TransformerUtil
				.getListBestSellerFromJSON(json));
	}

	@Override
	public Articulo registrarArticulo(ArticuloDTO art) throws ParseException {
		Articulo a = TransformerUtil.toArticulo(art);
		a = adminArticulo.registrarArticulo(a);
		return a;
	}

	@Override
	public boolean loguearUser(String dni, String pass) {
		return adminUsuario.loguearUser(dni, pass);
	}

	@Override
	public Usuario obtenerUsuario(String dni) {
		return adminUsuario.obtenerUsuario(dni);
	}

	@Override
	public String test() {
		return "todoOk";
	}

	@Override
	public Venta getVentaByNro(int nro) throws Exception {
		return adminVenta.getVentaByNro(nro);
	}

	@Override
	public void cambiarEstadoVenta(int nro) throws Exception {
		Venta v = adminVenta.getVentaByNro(nro);
		adminVenta.cambiarEstado(v);
	}

	@Override
	public List<Venta> getVentasByUsuario(String dni) {
		return adminVenta.getVentasByUsuario(adminUsuario.obtenerUsuario(dni));
	}

	@Override
	public void registrarVenta(Venta v) throws Exception {
		adminVenta.registrarVenta(v);

	}

	@Override
	public List<Articulo> getBestSellers() {
		return adminArticulo.getBestSellers();
	}

	@Override
	public List<Articulo> buscarArticulos(String criterio, String orderBy,
			boolean asc) {
		return adminArticulo.buscarArticulos(criterio, orderBy, asc);
	}

	@Override
	public List<Config> getConfigs() {
		return adminConfiguracion.getConfigs();
	}

	@Override
	public void addConfig(Config c) {
		adminConfiguracion.addConfig(c);
	}

	@Override
	public Config activarConfig(int c) {
		return adminConfiguracion.activarConfig(c);
	}

	@Override
	public Config desactivarConfig(int c) {
		return adminConfiguracion.desactivarConfig(c);
	}

	@Override
	public List<Config> getConfigsByFuncionalidad(String funcion) {
		return adminConfiguracion.getConfigsByFuncionalidad(funcion);
	}
	
	@Override
	public List<Articulo> getArticulosPorTipo(ETipoArticulo tipo) {
		return adminArticulo.getArticulosPorTipo(tipo);
	}
	
	@Override
	public List<ETipoArticulo> getTipoArticulos() {
		return adminArticulo.getTipoArticulos();
	}

}
