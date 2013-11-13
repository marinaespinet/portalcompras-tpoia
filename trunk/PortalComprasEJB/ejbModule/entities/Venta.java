package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Venta implements Serializable {
	
	//Duda sobre el tipo de dato de nroVeta y idModulo
	private String nroVenta;
	private  String idModulo;
	private int  coordenadaX;
	private int coordenadaY;
	private Date fecha;
	private float montoTotal;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "venta")
	private List<ItemVenta> itemsVenta;
	
	public Venta() {
		// TODO Auto-generated constructor stub
	}

	public String getNroVenta() {
		return nroVenta;
	}

	public void setNroVenta(String nroVenta) {
		this.nroVenta = nroVenta;
	}

	public String getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public List<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(List<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}
	
	
}
