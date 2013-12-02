package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface AdministradorVenta {
	
	public Venta getVentaByNro(int nro) throws Exception;
	public void cambiarEstado(Venta v) throws Exception;
	public List<Venta> getVentasByUsuario(Usuario u);
	public void registrarVenta(Venta v) throws Exception;
	public Venta modificarVenta(Venta v) throws Exception;
	public void eliminarVenta(Venta v);
	

}
