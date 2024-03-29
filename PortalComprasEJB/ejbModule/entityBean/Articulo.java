package entityBean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

import tipoYEstados.ETipoArticulo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Articulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7726705452887822654L;
	@Id
	private int codigo;
	private String nombre;
	private String descripcion;
	private String marca;
	private float precio;
	private String foto;
	private String origen;
	private Integer posicion;
	private String tipoString;
	private Timestamp fecha;

	public Articulo(int codigo) {
		this.codigo = codigo;
	}

	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	@Transient
	public abstract String obtenerCaracteristicas();

	

	@Transient
	public ETipoArticulo getTipo() {
		return ETipoArticulo.valueOf(tipoString);
	}

	@Transient
	public void setTipo(ETipoArticulo tipo) {
		this.tipoString = tipo.toString();
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getTipoString() {
		return tipoString;
	}

	public void setTipoString(String tipoString) {
		this.tipoString = tipoString;
	}
	
	

	
}
