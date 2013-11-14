package sessionBean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entityBean.Usuario;

/**
 * Session Bean implementation class AdministradorUsuarioBean
 */
@Stateless
@LocalBean
public class AdministradorUsuarioBean implements AdministradorUsuario {

	@PersistenceContext
	private EntityManager em;

	public AdministradorUsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean loguearUser(String dni, String pass) {
		try {
			em.createQuery(
					"from Usuario u where u.dni = :dni AND u.password = :pass")
					.setParameter("dni", dni).setParameter("pass", pass)
					.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return true;

	}

	@Override
	public Usuario obtenerUsuario(String dni) {
		return em.find(Usuario.class, dni);
	}

}
