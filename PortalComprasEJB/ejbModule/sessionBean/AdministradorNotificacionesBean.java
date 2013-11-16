package sessionBean;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import servicios.InformarLyMSincronico;
import types.EFuncionalidad;
import DTO.LogDTO;
import DTO.VentaDTO;
import entityBean.Config;
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

	@Override
	public void notificarAgregadoArticuloCarrito(Usuario u, int codArt, int cant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarBajaArticuloCarrito(Usuario u, int codArt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarModificacionesArticuloCarrito(Usuario u, int codArt,
			int cant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarCambioEstadoVenta(Usuario u, Venta v, String s) {
		// TODO Auto-generated method stub
	}
	
	private String informarLog(String mensajeLog) {
		//agarro el primero (solo deberia haber 1 a la vez activo, si hay 2 agarro cualquiera
		Config c = adminConfig.getConfigsByFuncionalidad(EFuncionalidad.venta.toString()).get(0);
		return InformarLyMSincronico.informarLog(new LogDTO(), c);
	}

	@Override
	public String informarVenta(Usuario u, Venta v) {
		//agarro el primero (solo deberia haber 1 a la vez activo, si hay 2 agarro cualquiera
		Config c = adminConfig.getConfigsByFuncionalidad(EFuncionalidad.venta.toString()).get(0);
		return InformarLyMSincronico.informarVenta(new VentaDTO(), c);
	}
	

}
