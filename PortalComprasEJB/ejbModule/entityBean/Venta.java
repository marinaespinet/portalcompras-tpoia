package entityBean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import util.FechaUtil;

import DTO.ItemCantidadDTO;
import DTO.VentaDTO;

public class Venta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -202495457899650081L;
	//Duda sobre el tipo de dato de nroVeta y idModulo
	private int nroVenta;
	private  String idModulo;
	private double  coordenadaX;
	private double coordenadaY;
	private Timestamp fecha;
	//private float montoTotal;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "venta")
	private List<ItemVenta> itemsVenta;
	private String estado;
	@ManyToOne
	private Usuario usuario;
	
	public Venta() {
		this.idModulo = "7";
	}


	public String getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}


	public double getImporteTotal() {
		float total = 0;
		for(ItemVenta i: this.itemsVenta){
			total += i.getImporte();
		}
		
		return total;
	}


	public List<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(List<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	public int getNroVenta() {
		return nroVenta;
	}



	public void setNroVenta(int nroVenta) {
		this.nroVenta = nroVenta;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	@Transient
	public VentaDTO getDTO() {
		VentaDTO v = new VentaDTO();
		v.setCoordenadaX(this.coordenadaX);
		v.setCoordenadaY(this.coordenadaY);
		v.setFecha(FechaUtil.toStringXml(this.getFecha()));
		v.setIdModulo(this.idModulo);
		v.setMontoTotal(this.getImporteTotal());
		v.setNroVenta(this.getNroVenta());
		v.setItemsVenta(new LinkedList<ItemCantidadDTO>());
		for(ItemVenta iv : this.getItemsVenta()){
			v.getItemsVenta().add(iv.getDTO());
		}
		return v;
	}
	
	
}
