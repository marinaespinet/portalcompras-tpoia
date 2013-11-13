package entities;

import javax.persistence.Entity;

@Entity
public class Electrodomestico extends Articulo {

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
}
