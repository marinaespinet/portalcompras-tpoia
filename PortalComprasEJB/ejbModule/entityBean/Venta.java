package entityBean;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Venta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -202495457899650081L;
	//Duda sobre el tipo de dato de nroVeta y idModulo
	private int nroVenta;
	private  String idModulo;
	private int  coordenadaX;
	private int coordenadaY;
	private Date fecha;
	//private float montoTotal;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "venta")
	private List<ItemVenta> itemsVenta;
	private String estado;
	@ManyToOne
	private Usuario usuario;
	
	public Venta() {
		// TODO Auto-generated constructor stub
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

	public float getImporteTotal() {
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
	
	
}
