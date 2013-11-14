package sessionBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entityBean.Articulo;



/**
 * Session Bean implementation class AdministradorArticuloBean
 */
@Stateless
public class AdministradorArticuloBean implements AdministradorArticulo {

	@PersistenceContext
    private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AdministradorArticuloBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Articulo registrarArticulo(Articulo a) {
		em.persist(a);
		return a;
	}

	@Override
	public List<Articulo> buscarArticulos(String criterio) {
		if(criterio==null){
			
		}
		String jpql = "from Articulo a";
		if (criterio != null && !criterio.trim().isEmpty()) {
			jpql+=" where a.descripcion like :criterio OR a.nombre like :criterio " +
			"OR a.origen like :criterio OR a.marca like :criterio";
		}
		 Query q = em.createQuery("from Articulo a where a.descripcion like :criterio OR a.nombre like :criterio " +
				"OR a.origen like :criterio OR a.marca like :criterio");
		 if (criterio != null) {
			 q.setParameter("criterio", "%"+criterio+"%");
		 }
		return q.getResultList();
		
	}

	@Override
	public void asignarRanking(int codigo, int posicion) {
		Articulo a = buscarArticulo(codigo);
		if(a!=null){
			a.setPosicion(posicion);
		}
		em.merge(a);
	}

	@Override
	public Articulo buscarArticulo(int codigo) {
		return em.find(Articulo.class, codigo);
	}

	@Override
	public List<Articulo> getArticulos() {
		return buscarArticulos(null);
	}

}
