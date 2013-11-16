package sessionBean;

import java.util.List;

import javax.ejb.Local;

import entityBean.Config;

@Local
public interface AdministradorConfiguracion {

	public List<Config> getConfigs();
	public void addConfig(Config c);
	public Config activarConfig(Config c);
	public Config desactivarConfig(Config c);
	public List<Config> getConfigsByFuncionalidad(String funcion);
		
}
