package DTO;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "venta")
@XmlAccessorType(XmlAccessType.FIELD)
public class VentaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private int nroVenta;
	@XmlElement
	private String idModulo;
	@XmlElement
	private double coordenadaX;
	@XmlElement
	private double coordenadaY;
	@XmlElement
	private String fecha;
	@XmlElement
	private double montoTotal;
	
	@XmlElementWrapper(name = "itemsVenta")
	@XmlElement(name = "item")
	private List<ItemCantidadDTO> itemsVenta;
	
	
	public int getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	public double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public List<ItemCantidadDTO> getItemsVenta() {
		return itemsVenta;
	}
	public void setItemsVenta(List<ItemCantidadDTO> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}
	public VentaDTO() {
		super();
		this.idModulo = "7";
	}
	
	

}
