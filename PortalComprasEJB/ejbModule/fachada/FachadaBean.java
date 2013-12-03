package fachada;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.json.JSONException;

import sessionBean.AdministradorArticulo;
import sessionBean.AdministradorConfiguracion;
import sessionBean.AdministradorNotificaciones;
import sessionBean.AdministradorUsuario;
import sessionBean.AdministradorVenta;
import tipoYEstados.EFuncionalidad;
import tipoYEstados.ETipoArticulo;
import util.FechaUtil;
import util.TransformerUtil;
import DTO.ArticuloDTO;
import entityBean.Articulo;
import entityBean.Config;
import entityBean.ConfigAsincronica;
import entityBean.ConfigSincronica;
import entityBean.Direccion;
import entityBean.Electrodomestico;
import entityBean.Moda;
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
	}

	@PostConstruct
	public void postConstruct() {

		Usuario u = new Usuario();
		u.setAdministrador(true);
		u.setCoordenadaX(-34.6179003d);
		u.setCoordenadaY(-58.3874423d);
		u.setDireccion(new Direccion("prov", "ciud", "calle", 1, "depto"));
		u.setDni("usuario1");
		u.setMail("sfsa@asdas.com");
		u.setNombre("Hernan Escola");
		u.setPassword("1234");
		adminUsuario.registrar(u);
		
		u = new Usuario();
		u.setAdministrador(true);
		u.setCoordenadaX(-31.402701d);
		u.setCoordenadaY(-64.1644477d);
		u.setDireccion(new Direccion("prov", "ciud", "calle", 1, "depto"));
		u.setDni("usuario5");
		u.setMail("sfsa@asdas.com");
		u.setNombre("usuario5");
		u.setPassword("1234");
		adminUsuario.registrar(u);
		
		u = new Usuario();
		u.setAdministrador(true);
		u.setCoordenadaX(-32.958522d);
		u.setCoordenadaY(-60.6677055d);
		u.setDireccion(new Direccion("prov", "ciud", "calle", 1, "depto"));
		u.setDni("uusuario7");
		u.setMail("sfsa@asdas.com");
		u.setNombre("usuario7");
		u.setPassword("1234");
		adminUsuario.registrar(u);
		
		/*
		Usuario u2 = new Usuario();
		u.setAdministrador(true);
		u.setCoordenadaX(-34.6179003d);
		u.setCoordenadaY(-58.3874423d);
		u.setDireccion(new Direccion("prov", "ciud", "calle", 1, "depto"));
		u.setDni("usuario2");
		u.setMail("sfsa@asdas.com");
		u.setNombre("Hernan Escola");
		u.setPassword("1234");
		adminUsuario.registrar(u2);*/

		/*
		 * Electrodomestico a = new Electrodomestico(); a.setCodigo(1);
		 * a.setDescripcion("LavaCosas");
		 * a.setFecha(FechaUtil.getFechaActual());
		 * a.setFichaTecnica("ficha tecnic");
		 * a.setFoto("http://www.google.com.ar/images/srpr/logo11w.png");
		 * a.setMarca("marca"); a.setNombre("nombre"); a.setOrigen("origen");
		 * a.setPosicion(2); a.setPrecio(50.5f);
		 * adminArticulo.registrarArticulo(a);
		 * 
		 * Moda m = new Moda(); m.setCodigo(2);
		 * m.setDescripcion("Remera para gordos");
		 * m.setFecha(FechaUtil.getFechaActual()); m.setColor("Roja");
		 * m.setTalle("XXXXXXXL");
		 * m.setFoto("http://www.google.com.ar/images/srpr/logo11w.png");
		 * m.setMarca("Acme"); m.setNombre("Alta remera"); m.setOrigen("China");
		 * m.setPosicion(1); m.setPrecio(13.22f);
		 * adminArticulo.registrarArticulo(m);
		 */

		ConfigSincronica c = new ConfigSincronica();
		c.setActivado(true);
		c.setFuncionalidad(EFuncionalidad.venta.toString());
		c.setIp("172.16.174.36");
		c.setNombre("Logistica y Monitoreo G15");
		c.setPuerto("8080");
		c.setUrl("LogisticaMonitoreo/LogisticaMonitoreoWS");
		adminConfiguracion.addConfig(c);

		ConfigSincronica c3 = new ConfigSincronica();
		c3.setActivado(true);
		c3.setFuncionalidad(EFuncionalidad.log.toString());
		c3.setIp("172.16.174.36");
		c3.setNombre("Logistica y Monitoreo G15");
		c3.setPuerto("8080");
		c3.setUrl("LogisticaMonitoreo/LogisticaMonitoreoWS");
		adminConfiguracion.addConfig(c3);

		ConfigAsincronica c2 = new ConfigAsincronica();
		c2.setActivado(false);
		c2.setFuncionalidad(EFuncionalidad.log.toString());
		c2.setIp("172.16.174.36");
		c2.setPuerto("4447");
		c2.setNombre("Logistica y Monitoreo G15");
		c2.setUser("log");
		c2.setPassword("log1234");
		adminConfiguracion.addConfig(c2);

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
