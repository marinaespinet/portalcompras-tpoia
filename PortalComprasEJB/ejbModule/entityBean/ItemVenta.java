package entityBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import DTO.ItemCantidadDTO;

@Entity
public class ItemVenta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3380258419215168155L;
	@Id
	private int id;
	@ManyToOne
	private Articulo articulo;
	private int cantidad;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemVenta() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ItemVenta(Articulo articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Transient
	public double getImporte() {
		return this.articulo.getPrecio() * this.cantidad;
	}

	@Transient
	public ItemCantidadDTO getDTO() {
		// TODO Auto-generated method stub
		return new ItemCantidadDTO(this.articulo.getCodigo(), this.cantidad);
	}

	
	
}
