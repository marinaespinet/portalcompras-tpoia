package negocio;

import javax.persistence.Entity;

@Entity
public class Nino extends Articulo {
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
