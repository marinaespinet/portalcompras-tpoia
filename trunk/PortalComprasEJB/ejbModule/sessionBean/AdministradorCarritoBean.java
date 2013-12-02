package sessionBean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import tipoYEstados.EEstadoRetorno;
import tipoYEstados.EEstadoVenta;
import util.FechaUtil;
import DTO.ItemCantidadDTO;
import DTO.ResultadoDTO;
import entityBean.Articulo;
import entityBean.ItemVenta;
import entityBean.Usuario;
import entityBean.Venta;

/**
 * Session Bean implementation class AdministradorVentaBean
 */
@Stateful
public class AdministradorCarritoBean implements AdministradorCarrito {

	@EJB
	private AdministradorArticulo adminArticulo;
	@EJB
	private AdministradorNotificaciones adminNotificaciones;
	@EJB
	private AdministradorVenta adminVenta;

	private Map<Integer, ItemCantidadDTO> articulosCantidad = new HashMap<Integer, ItemCantidadDTO>();
	private Map<Integer, Articulo> mapaArticulos = new HashMap<Integer, Articulo>();

	private Usuario usuario;

	public AdministradorCarritoBean(Usuario u) {
		this.usuario = u;
	}

	public AdministradorCarritoBean() {
	}

	@Override
	public Venta realizarVenta() throws Exception {

		Venta v = new Venta();
		v.setCoordenadaX(usuario.getCoordenadaX());
		v.setCoordenadaY(usuario.getCoordenadaY());
		v.setItemsVenta(new LinkedList<ItemVenta>());
		for (Integer cod : articulosCantidad.keySet()) {
			v.getItemsVenta().add(
					new ItemVenta(mapaArticulos.get(cod), articulosCantidad
							.get(cod).getCantidad()));
		}
		v.setFecha(FechaUtil.getFechaActual());
		v.setEstado(EEstadoVenta.Cheackout.name());
		v.setUsuario(usuario);
		adminVenta.registrarVenta(v);

		ResultadoDTO res;
		try {
			res = adminNotificaciones.informarVenta(usuario, v);
		} catch (Exception e) {
			// no se pudo concretar la conexion con LyM asi q elimino la venta
			// COMENTAR ESTO, SOLO PARA TEST
			/*if (true) {
				v.setEstado(EEstadoVenta.Aceptada.toString());
				adminVenta.modificarVenta(v);
				limpiarCarrito();
				return v;
			}*/
			adminVenta.eliminarVenta(v);
			throw new Exception(
					"No se pudo realizar la compra exitosamente debido a problemas en la conexion. Vuelva a intetnarlo mas tarde");
		}
		if (res.getEstado().equalsIgnoreCase(EEstadoRetorno.OK.toString())) {
			v.setEstado(EEstadoVenta.Aceptada.toString());

		} else {
			v.setEstado(EEstadoVenta.Rechazada.toString());
		}

		adminVenta.modificarVenta(v);
		limpiarCarrito();
		return v;
	}

	private void limpiarCarrito() {
		this.mapaArticulos.clear();
		this.articulosCantidad.clear();

	}

	@Override
	public void agregarArticulo(int codigo, int cant) throws Exception {
		Articulo a = adminArticulo.buscarArticulo(codigo);
		mapaArticulos.put(codigo, a);
		if (articulosCantidad.containsKey(codigo)) {
			modificarCantidad(codigo, articulosCantidad.get(codigo)
					.getCantidad() + cant);
		} else {
			articulosCantidad.put(codigo, new ItemCantidadDTO(a, cant));
			adminNotificaciones.notificarAgregadoArticuloCarrito(usuario,
					codigo, cant);
		}

	}

	@Override
	public void quitarArticulo(int codigo) throws Exception {
		articulosCantidad.remove(codigo);
		mapaArticulos.remove(codigo);
		adminNotificaciones.notificarBajaArticuloCarrito(usuario, codigo);

	}

	@Override
	public void modificarCantidad(int codigo, int cantidad) throws Exception {
		if (cantidad <= 0) {
			quitarArticulo(codigo);
		} else {
			ItemCantidadDTO item = articulosCantidad.get(codigo);
			item.setCantidad(cantidad);
			articulosCantidad.put(codigo, item);
			adminNotificaciones.notificarModificacionesArticuloCarrito(usuario,
					codigo, cantidad);
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public List<ItemCantidadDTO> getItemsCarrito() {
		return new LinkedList<ItemCantidadDTO>(articulosCantidad.values());
	}

	@Override
	public ItemCantidadDTO getItemCantidadDTO(Articulo articulo) {
		return articulosCantidad.get(articulo.getCodigo());
	}

}
