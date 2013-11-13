package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Embeddable
public class Direccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9177743829625132856L;
	private String provincia;
	private String ciudad;
	private String calle;
	private int piso;
	private String dpto;
	
	public Direccion() {
		// TODO Auto-generated constructor stub
	}
	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	
	
	
}
