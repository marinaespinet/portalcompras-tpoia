package sessionBean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entityBean.Config;

/**
 * Session Bean implementation class AdministradorConfiguracionBean
 */
@Stateless
@LocalBean
public class AdministradorConfiguracionBean implements AdministradorConfiguracion {

	@PersistenceContext
	private EntityManager em;
	
    public AdministradorConfiguracionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Config> getConfigs() {
			return em.createQuery(
					"from Config c")
					.getResultList();
	}

	@Override
	public void addConfig(Config c) {
		em.persist(c);
	}

	@Override
	public Config activarConfig(int c) {
		Config cp = em.find(Config.class, c);
		cp.setActivado(true);
		//mergea solo por estar en sesion?
		return em.merge(cp);
	}

	@Override
	public Config desactivarConfig(int c) {
		Config cp = em.find(Config.class,c);
		cp.setActivado(false);
		//mergea solo por estar en sesion?
		return em.merge(cp);
	}

	@Override
	public List<Config> getConfigsByFuncionalidad(String funcion) {
		return em.createQuery(
				"from Config c where c.funcionalidad = :funcion AND c.activado = 1").setParameter("funcion", funcion)
				.getResultList();
	}

}
