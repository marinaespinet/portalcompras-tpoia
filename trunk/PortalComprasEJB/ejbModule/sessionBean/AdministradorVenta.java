package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Usuario;
import entityBean.Venta;

@Local
public interface AdministradorVenta {
	
	public Venta getVentaByNro(int nro);
	public Venta cambiarEstado(Venta v, String estado);
	public List<Venta> getVentasByUsuario(Usuario u);
	public void registrarVenta(Venta v);
	

}
