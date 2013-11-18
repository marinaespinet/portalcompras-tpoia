package sessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tipoYEstados.EEstadoVenta;
import entityBean.Usuario;
import entityBean.Venta;

/**
 * Session Bean implementation class AdministradorVentaBean
 */
@Stateless
@LocalBean
public class AdministradorVentaBean implements AdministradorVenta {

	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public AdministradorVentaBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Venta getVentaByNro(int nro) throws Exception {
		Venta v = em.find(Venta.class, nro);
		if( v == null){
			throw new Exception("No se encontro una venta con Nro: "+nro);
		}
		return v;
	}
	
	@Override
	public void cambiarEstado(Venta v) throws Exception {
		v.setEstado(EEstadoVenta.Despachada.toString());
		em.merge(v);	
	}
	
	@Override
	public List<Venta> getVentasByUsuario(Usuario u) {
		return em.createQuery(
				"from Venta v where v.usuario = :usuario").setParameter("usuario", u)
				.getResultList();
	}
	@Override
	public void registrarVenta(Venta v) throws Exception{
		em.persist(v);
	}
	
	@Override
	public Venta modificarVenta(Venta v) throws Exception{
		return em.merge(v);
	}

}
