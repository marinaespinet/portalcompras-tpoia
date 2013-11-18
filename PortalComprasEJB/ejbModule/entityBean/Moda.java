package entityBean;

import javax.persistence.Entity;
import javax.persistence.Transient;

import tipoYEstados.ETipoArticulo;

@Entity
public class Moda extends Articulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5076058167300753617L;
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
	
	@Override
	@Transient
	public String obtenerCaracteristicas() {
		return "Color: " + color +", \n Talle: "+talle;
	}
	@Override
	@Transient
	public ETipoArticulo getTipo() {
		return ETipoArticulo.Moda;
	}
	
}
