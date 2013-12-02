package sessionBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;

import tipoYEstados.ETipoArticulo;

import DTO.BestSellerDTO;
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
	public List<Articulo> buscarArticulos(String criterio, String orderBy, boolean asc) {
		if (criterio == null) {

		}
		String jpql = "from Articulo a";
		if (criterio != null && !criterio.trim().isEmpty()) {
			jpql += " where a.descripcion like :criterio OR a.nombre like :criterio "
					+ "OR a.origen like :criterio OR a.marca like :criterio ";
		}
		
		if(orderBy!=null){
			jpql+= " ORDER BY ";
			jpql+= ", a." +orderBy + " ";
			
			if(!asc){
				jpql += "desc ";
			}
		}
		Query q = em
				.createQuery(jpql);
		if (criterio != null && !criterio.isEmpty()) {
			q.setParameter("criterio", "%" + criterio + "%");
		}
		return q.getResultList();

	}
	
	@Override
	public List<Articulo> buscarArticulos(String criterio) {
		return buscarArticulos(criterio, null, true);

	}

	@Override
	public void asignarRanking(List<BestSellerDTO> list) throws Exception {
		try {
			em.getTransaction().begin();

			for (BestSellerDTO bs : list) {
				Articulo a = buscarArticulo(bs.getcodigoArticulo());
				if (a != null) {
					a.setPosicion(bs.getPosicion());
				}
				em.merge(a);
			}
			em.getTransaction().commit();
		} catch (RollbackException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Articulo buscarArticulo(int codigo) {
		return em.find(Articulo.class, codigo);
	}

	@Override
	public List<Articulo> getArticulos() {
		return buscarArticulos(null,null,true);
	}

	@Override
	public List<Articulo> getBestSellers() {
		return (List<Articulo>)em.createQuery("select a "
				+ "from Articulo a "
				+ "where a.posicion is not null "
				+ "order by a.posicion asc").getResultList();
	}
	
	@Override
	public List<Articulo> getArticulosPorTipo(ETipoArticulo tipo) {
		return (List<Articulo>)em.createQuery("select a "
				+ "from Articulo a "
				+ "where a.tipoString =:tipo").setParameter("tipo", tipo.toString()).getResultList();
	}
	
	@Override
	public List<ETipoArticulo> getTipoArticulos() {
		return (List<ETipoArticulo>)em.createQuery("select distinct a.tipo  "
				+ "from Articulo a group by a.tipo ").getResultList();
	}

}
