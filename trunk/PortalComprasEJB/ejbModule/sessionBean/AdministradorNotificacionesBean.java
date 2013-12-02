package sessionBean;

import java.rmi.RemoteException;
import java.util.concurrent.TimeoutException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.InformarAsincronicoLyM;
import servicios.InformarSincronicoLyM;
import tipoYEstados.EFuncionalidad;
import util.TransformerUtil;
import DTO.LogDTO;
import DTO.ResultadoDTO;

import entityBean.Config;
import entityBean.ConfigAsincronica;
import entityBean.ConfigSincronica;
import entityBean.Usuario;
import entityBean.Venta;

/**
 * Session Bean implementation class AdministradorNotificacionesBean
 */
@Stateless
@LocalBean
public class AdministradorNotificacionesBean implements
		AdministradorNotificaciones {

	@EJB
	private AdministradorConfiguracion adminConfig;

	public AdministradorNotificacionesBean() {
		// TODO Auto-generated constructor stub
	}

	private String armarMensaje(String inicioMensaje, Usuario u, int codArt) {
		return inicioMensaje + " articulo con codigo " + codArt
				+ " del carrito del usuario con ID:" + u.getDni();
	}

	@Override
	public void notificarAgregadoArticuloCarrito(Usuario u, int codArt, int cant)
			throws Exception {
		informarLog(armarMensaje("Se Agregaron " + cant + " unidades  del", u,
				codArt));
	}

	@Override
	public void notificarBajaArticuloCarrito(Usuario u, int codArt)
			throws Exception {
		informarLog(armarMensaje("Se quito el", u, codArt));

	}

	@Override
	public void notificarModificacionesArticuloCarrito(Usuario u, int codArt,
			int cant) throws Exception {
		informarLog(armarMensaje("Se Modifico la cantidad a " + cant
				+ " unidades  del", u, codArt));
	}

	@Override
	public void notificarCambioEstadoVenta(Usuario u, Venta v, String s)
			throws Exception {
		informarLog("Se Cambio el estado de la venta nro. " + v.getNroVenta()
				+ " al usuario ID:" + u.getDni() + " a " + v.getEstado());
	}

	private void informarLog(String mensajeLog) throws Exception {
		try {
			// agarro el primero (solo deberia haber 1 a la vez activo, si hay 2
			// agarro cualquiera
			Config c = adminConfig.getConfigsByFuncionalidad(
					EFuncionalidad.log.toString()).get(0);
			if (c.isSincronico()) {
				String res = InformarSincronicoLyM.informarLog(new LogDTO(
						mensajeLog), (ConfigSincronica) c);

				System.out
						.println("RESULTADO DEL LLAMADO AL WS sincronico ----------> "
								+ res);
				ResultadoDTO dto = TransformerUtil.getObjectFromXml(res,
						ResultadoDTO.class);
				if (dto.isError()) {
					throw new Exception(dto.getMensaje());
				}
			} else {
				InformarAsincronicoLyM.informarLog(new LogDTO(mensajeLog),
						(ConfigAsincronica) c);
				System.out.println("RESULTADO DEL LLAMADO AL WS asincronico ---------> "+ TransformerUtil.getXML(ResultadoDTO.getResultadoOK()));
				
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
			throw new RemoteException("Ocurrio un error inesperado : Logistica y Monitoreo no respondio.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteException("Ocurrio un error inesperado :"+e.getMessage());
		}

	}

	@Override
	public ResultadoDTO informarVenta(Usuario u, Venta v) throws Exception {
		// agarro el primero (solo deberia haber 1 a la vez activo, si hay 2
		// agarro cualquiera
		Config c = adminConfig.getConfigsByFuncionalidad(
				EFuncionalidad.venta.toString()).get(0);
		return TransformerUtil.getObjectFromXml(InformarSincronicoLyM
				.informarVenta(v.getDTO(), (ConfigSincronica) c),
				ResultadoDTO.class);
	}

}
