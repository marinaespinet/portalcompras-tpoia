package sessionBean;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.InformarAsincronicoLyM;
import servicios.InformarSincronicoLyM;
import tipoYEstados.EEstadoRetorno;
import tipoYEstados.EFuncionalidad;
import util.TransformerUtil;
import DTO.LogDTO;
import DTO.ResultadoDTO;
import DTO.VentaDTO;
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
public class AdministradorNotificacionesBean implements AdministradorNotificaciones {

	@EJB
	private AdministradorConfiguracion adminConfig;
	
    public AdministradorNotificacionesBean() {
        // TODO Auto-generated constructor stub
    }

    private String armarMensaje(String inicioMensaje ,Usuario u, int codArt){
    	return inicioMensaje+" articulo con codigo "+codArt+ " del carrito del usuario con ID:"+ u.getDni();
    }
	@Override
	public void notificarAgregadoArticuloCarrito(Usuario u, int codArt, int cant) {
			informarLog(armarMensaje("Se Agregaron " + cant+" unidades  del", u, codArt));
	}

	@Override
	public void notificarBajaArticuloCarrito(Usuario u, int codArt) {
		informarLog(armarMensaje("Se quito el" , u, codArt));
		
	}

	@Override
	public void notificarModificacionesArticuloCarrito(Usuario u, int codArt,
			int cant) {
		informarLog(armarMensaje("Se Modifico la cantidad a " + cant+" unidades  del", u, codArt));
	}

	@Override
	public void notificarCambioEstadoVenta(Usuario u, Venta v, String s) {
		informarLog("Se Cambio el estado de la venta nro. " + v.getNroVenta() +" al usuario ID:"+ u.getDni() +" a " + v.getEstado());
	}
	
	private String informarLog(String mensajeLog) {
		try{
		//agarro el primero (solo deberia haber 1 a la vez activo, si hay 2 agarro cualquiera
		Config c = adminConfig.getConfigsByFuncionalidad(EFuncionalidad.log.toString()).get(0);
		if(c.isSincronico()){
			return InformarSincronicoLyM.informarLog(new LogDTO(mensajeLog), (ConfigSincronica) c);
		}else{
			InformarAsincronicoLyM.informarLog(new LogDTO(mensajeLog), (ConfigAsincronica) c);
			return TransformerUtil.getXML(ResultadoDTO.getResultadoOK());
		}
		
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
					
		}
	}

	@Override
	public ResultadoDTO informarVenta(Usuario u, Venta v) throws Exception {
		//agarro el primero (solo deberia haber 1 a la vez activo, si hay 2 agarro cualquiera
		Config c = adminConfig.getConfigsByFuncionalidad(EFuncionalidad.venta.toString()).get(0);
		return TransformerUtil.getObjectFromXml(InformarSincronicoLyM.informarVenta(v.getDTO(), (ConfigSincronica) c), ResultadoDTO.class);
	}
	

}
