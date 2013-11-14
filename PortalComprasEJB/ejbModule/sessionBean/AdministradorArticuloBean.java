package sessionBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public Articulo registrarArticulo(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Articulo> buscarArticulos(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarRanking(String jsonArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Articulo buscarArticulo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

}
