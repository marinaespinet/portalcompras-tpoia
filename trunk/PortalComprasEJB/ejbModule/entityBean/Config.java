package entityBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Config implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nombre;
	private String ip;
	private String puerto;
	//cambiar por enums
	private String funcionalidad;
	private boolean activado;
	
	public Config() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getFuncionalidad() {
		return funcionalidad;
	}
	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	public boolean isActivado() {
		return activado;
	}
	public void setActivado(boolean activado) {
		this.activado = activado;
	}
	
	@Transient
	public abstract boolean isSincronico();	
	
	
}
