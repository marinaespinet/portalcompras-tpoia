package DTO;

import java.io.Serializable;


public class BestSellerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int codigoArticulo;

	private int posicion;
	public BestSellerDTO() {
		super();
	}
	
	
	public BestSellerDTO(int codigoArticulo, int posicion) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.posicion = posicion;
	}


	public int getcodigoArticulo() {
		return codigoArticulo;
	}
	public void setcodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	
}
