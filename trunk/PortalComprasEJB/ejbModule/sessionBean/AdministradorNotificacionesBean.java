package sessionBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entityBean.Usuario;
import entityBean.Venta;

/**
 * Session Bean implementation class AdministradorNotificacionesBean
 */
@Stateless
@LocalBean
public class AdministradorNotificacionesBean implements AdministradorNotificaciones {

    /**
     * Default constructor. 
     */
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

}
