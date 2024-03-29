package entityBean;

import javax.persistence.Entity;
import javax.persistence.Transient;

import tipoYEstados.ETipoArticulo;

@Entity
public class Mueble extends Articulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8109256227690275037L;
	private String material;
	
	public Mueble() {
		setTipo(ETipoArticulo.Mueble);
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	@Transient
	public String obtenerCaracteristicas() {
		return "Material : "+material;
	}
	

}
