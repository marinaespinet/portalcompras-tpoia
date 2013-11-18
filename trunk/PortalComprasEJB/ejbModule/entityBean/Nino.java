package entityBean;

import javax.persistence.Entity;
import javax.persistence.Transient;

import tipoYEstados.ETipoArticulo;

@Entity
public class Nino extends Articulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4496945645734699729L;
	private String edadRecomendada;
	
	public Nino() {
		setTipo(ETipoArticulo.Nino);
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	
	@Override
	@Transient
	public String obtenerCaracteristicas() {
		return "Edad recomendada: " + edadRecomendada;
	}
	
	
}
