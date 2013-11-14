package entityBean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private float importe;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemVenta() {
		// TODO Auto-generated constructor stub
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

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	
}
