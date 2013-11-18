package sessionBean;

import javax.ejb.Local;

import entityBean.Usuario;

@Local
public interface AdministradorUsuario {

	public boolean loguearUser(String dni, String pass);
	public Usuario obtenerUsuario(String dni);
	public void registrar(Object o);
}
