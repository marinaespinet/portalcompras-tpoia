package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Config;

@Local
public interface AdministradorConfiguracion {

	public List<Config> getConfigs();
	public void addConfig(Config c);
	public Config activarConfig(int c);
	public Config desactivarConfig(int c);
	public List<Config> getConfigsByFuncionalidad(String funcion);
		
}
