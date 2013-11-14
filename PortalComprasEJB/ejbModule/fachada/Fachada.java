package fachada;
import java.util.List;

import javax.ejb.Remote;

import DTO.ArticuloDTO;
import DTO.UsuarioDTO;
import entityBean.Articulo;

@Remote
public interface Fachada {
	public List<ArticuloDTO> buscarArticulos(String criterio);

	public ArticuloDTO buscarArticulo(int codigo);

	public List<ArticuloDTO> getArticulos();

	void asignarRanking(String json);

	Articulo registrarArticulo(String xml);
	
	public boolean loguearUser(String dni, String pass);
	
	public UsuarioDTO obtenerUsuario(String dni);
}
