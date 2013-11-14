package entityBean;

import javax.persistence.Entity;

@Entity
public class ConfigSincronica extends Config{
	
	private String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
