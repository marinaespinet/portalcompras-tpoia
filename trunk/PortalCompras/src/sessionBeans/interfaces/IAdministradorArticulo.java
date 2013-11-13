package sessionBeans.interfaces;

import java.util.List;

import negocio.Articulo;

public interface IAdministradorArticulo {

	public Articulo registrarArticulo(String xml);
	public List<Articulo> buscarArticulos(String criterio);
	public void asignarRanking(String jsonArray);
	public Articulo buscarArticulo(int codigo);
	public List<Articulo> getArticulos();
	
}
