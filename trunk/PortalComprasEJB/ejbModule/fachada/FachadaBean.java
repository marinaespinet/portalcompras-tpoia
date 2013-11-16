package fachada;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessionBean.AdministradorArticulo;
import sessionBean.AdministradorConfiguracion;
import sessionBean.AdministradorNotificaciones;
import sessionBean.AdministradorUsuario;
import transformers.Transformer;
import DTO.ArticuloDTO;
import DTO.UsuarioDTO;
import entityBean.Articulo;

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

	public FachadaBean() {

	}

	@Override
	public List<ArticuloDTO> buscarArticulos(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloDTO buscarArticulo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticuloDTO> getArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarRanking(String json) {
		// TODO Auto-generated method stub

	}

	@Override
	public Articulo registrarArticulo(ArticuloDTO art) {
		Articulo a = Transformer.toArticulo(art);
		a = adminArticulo.registrarArticulo(a);
		return a;
	}

	@Override
	public boolean loguearUser(String dni, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioDTO obtenerUsuario(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public void altaRodamiento(Rodamiento r, List<String> l) throws
	 * EJBTransactionRolledbackException{ Rodamiento
	 * rod=adminRodamiento.altaRodamiento(r,l); enviarRodamiento(rod); }
	 * 
	 * @Override public void ProcesarOrdenCompraCC(OrdenCompraCC ord) {
	 * adminOrdenCompra.altaOrdenCompra(ord); SolicitudMatPrima solMP = new
	 * SolicitudMatPrima(); // Verifica Stock List<Componente> rv =
	 * adminRodamiento.validarStock(ord); // De ser necesario, genera solicitud
	 * MP if(rv.size()!=0){ solMP = generarSolicitudMateriaPrima(rv, ord);
	 * EnviarSolicitud env = new EnviarSolicitud(); String ip =
	 * getIPProveedorMP(); env.enviarSolicitud(solMP,ip); } else
	 * venderRodamientos(ord.getNroOrden()); }
	 * 
	 * private SolicitudMatPrima generarSolicitudMateriaPrima(List<Componente>
	 * rv, OrdenCompraCC ord) { return adminSolicitudMP.generarSolicitud(rv,
	 * ord); }
	 * 
	 * public List<MateriaPrima> buscarMatPrimas() { return
	 * adminMateriaPrima.buscarTodos(); }
	 * 
	 * public ListaDePrecios obtenerListaPrecios() { return
	 * adminListaPrecios.obtenerListaPrecios(); }
	 * 
	 * public void recepcionMatPrima(SolicitudMatPrima smp) {
	 * adminSolicitudMP.cargarMateriasPrimas(smp);
	 * venderRodamientos(smp.getNroOrdenCC()); }
	 * 
	 * public void venderRodamientos(int nroOrdenCC){
	 * adminMateriaPrima.venderRodamiento(nroOrdenCC); EnviarConfirmacion ec =
	 * new EnviarConfirmacion(); OrdenCompraCCAcep ok = new OrdenCompraCCAcep();
	 * ok.setNroOrdenCompra(nroOrdenCC); String ip = getIPCasaCentral();
	 * ec.enviarConfirmacion(ok,ip); } public void enviarRodamiento(Rodamiento
	 * rod) { EnviarRodamiento er = new EnviarRodamiento(); String ip =
	 * getEndPoint(); er.enviarRodamiento(rod,ip); }
	 * 
	 * private String getIPProveedorMP() { return
	 * adminProveedor.getIPProveedorMP(); }
	 * 
	 * private String getIPCasaCentral() { return
	 * adminProveedor.getIPCasaCentral(); }
	 * 
	 * private String getEndPoint(){ return adminProveedor.getEndPoint(); }
	 */
}
