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
		// TODO Auto-generated constructor stub
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
	
	@Override
	@Transient
	public ETipoArticulo getTipo() {
		return ETipoArticulo.Mueble;
	}
}
