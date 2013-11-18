package fachada;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import sessionBean.AdministradorArticulo;
import sessionBean.AdministradorConfiguracion;
import sessionBean.AdministradorNotificaciones;
import sessionBean.AdministradorUsuario;
import transformers.Transformer;
import DTO.ArticuloDTO;
import DTO.UsuarioDTO;
import entityBean.Articulo;

@Stateless
public class FachadaBean implements Fachada, Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private AdministradorNotificaciones adminNotificaciones;
	@EJB
	private AdministradorUsuario adminUsuario;
	@EJB
	private AdministradorConfiguracion adminConfiguracion;
	@EJB
	private AdministradorArticulo adminArticulo;

	public FachadaBean() {

	}

	@Override
	public List<ArticuloDTO> buscarArticulos(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticuloDTO buscarArticulo(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticuloDTO> getArticulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void asignarRanking(String json) {
		// TODO Auto-generated method stub

	}

	@Override
	public Articulo registrarArticulo(ArticuloDTO art) {
		Articulo a = Transformer.toArticulo(art);
		a = adminArticulo.registrarArticulo(a);
		return a;
	}

	@Override
	public boolean loguearUser(String dni, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioDTO obtenerUsuario(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String test() {
		return "todoOk";
	}
}
