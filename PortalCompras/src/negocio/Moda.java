package negocio;

import javax.persistence.Entity;

@Entity
public class Moda extends Articulo {
	private String color;
	private String talle;
	
	public Moda() {
		super();
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	
}
