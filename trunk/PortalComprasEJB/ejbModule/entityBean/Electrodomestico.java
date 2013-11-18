package entityBean;

import javax.persistence.Entity;
import javax.persistence.Transient;

import tipoYEstados.ETipoArticulo;

@Entity
public class Electrodomestico extends Articulo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5496814341194039696L;
	private String fichaTecnica;
	
	public Electrodomestico() {
		super();
	}

	public String getFichaTecnica() {
		return fichaTecnica;
	}

	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	
	@Override
	@Transient
	public String obtenerCaracteristicas() {
		return "Ficha tecnica: " +fichaTecnica;
	}
	@Override
	@Transient
	public ETipoArticulo getTipo() {
		return ETipoArticulo.Electrodomestico;
	}
}
