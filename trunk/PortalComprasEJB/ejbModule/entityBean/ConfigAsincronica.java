package entityBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ConfigAsincronica extends Config{
	
	@Column(name="usuario")
	private String user;
	private String password;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	@Transient
	public boolean isSincronico() {
		return false;
	}
	
	
	
	
	
}
