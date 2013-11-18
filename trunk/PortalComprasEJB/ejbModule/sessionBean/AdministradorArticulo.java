package sessionBean;

import java.util.List;

import javax.ejb.Local;

import DTO.BestSellerDTO;
import entityBean.Articulo;


@Local
public interface AdministradorArticulo {

	public List<Articulo> buscarArticulos(String criterio, String orderBy, boolean asc);

	public Articulo buscarArticulo(int codigo);

	public List<Articulo> getArticulos();

	public Articulo registrarArticulo(Articulo a);

	void asignarRanking(List<BestSellerDTO> list) throws Exception;

	public List<Articulo> getBestSellers();

	List<Articulo> buscarArticulos(String criterio);

}
