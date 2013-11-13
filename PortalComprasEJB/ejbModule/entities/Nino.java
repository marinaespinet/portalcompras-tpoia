package entities;

import javax.persistence.Entity;

@Entity
public class Nino extends Articulo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4496945645734699729L;
	private String edadRecomendada;
	
	public Nino() {
		// TODO Auto-generated constructor stub
	}

	public String getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	
	
}
