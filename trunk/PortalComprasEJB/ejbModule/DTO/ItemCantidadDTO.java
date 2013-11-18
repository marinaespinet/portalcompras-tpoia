package DTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class ItemCantidadDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private int codigoArticulo;
	@XmlElement
	private int cantidad;
	
	public int getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(int codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ItemCantidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemCantidadDTO(Integer cod, Integer cant) {
		this.codigoArticulo = cod;
		this.cantidad = cant;
	}
	
	

}
