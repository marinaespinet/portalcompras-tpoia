package entities;

import javax.persistence.Entity;

@Entity
public class Mueble extends Articulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8109256227690275037L;
	private String material;
	
	public Mueble() {
		// TODO Auto-generated constructor stub
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
}
