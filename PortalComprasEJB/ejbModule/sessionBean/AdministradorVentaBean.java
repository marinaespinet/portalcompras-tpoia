package sessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Venta getVentaByNro(int nro) {
		return em.find(Venta.class, nro);
	}
	
	@Override
	public Venta cambiarEstado(Venta v, String estado) {
		Venta vp = getVentaByNro(v.getNroVenta());
		vp.setEstado(estado);
		em.merge(vp);
		return vp;
	}
	
	@Override
	public List<Venta> getVentasByUsuario(Usuario u) {
		return em.createQuery(
				"from Venta v where v.usuario = :usuario").setParameter("usuario", u)
				.getResultList();
	}
	@Override
	public void registrarVenta(Venta v) {
		em.persist(v);
	}

}
