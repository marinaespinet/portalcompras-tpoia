package entityBean;

import javax.persistence.Entity;

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
}
