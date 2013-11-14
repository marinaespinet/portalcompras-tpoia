package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Articulo;


@Local
public interface AdministradorArticulo {

	public List<Articulo> buscarArticulos(String criterio);

	public Articulo buscarArticulo(int codigo);

	public List<Articulo> getArticulos();

	void asignarRanking(int codigo, int posicion);

	Articulo registrarArticulo(Articulo a);

}
