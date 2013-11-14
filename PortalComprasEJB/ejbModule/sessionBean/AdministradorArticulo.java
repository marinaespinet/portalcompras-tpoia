package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Articulo;


@Local
public interface AdministradorArticulo {

	
	public Articulo registrarArticulo(String xml);

	public List<Articulo> buscarArticulos(String criterio);

	public void asignarRanking(String jsonArray);

	public Articulo buscarArticulo(int codigo);

	public List<Articulo> getArticulos();

}
