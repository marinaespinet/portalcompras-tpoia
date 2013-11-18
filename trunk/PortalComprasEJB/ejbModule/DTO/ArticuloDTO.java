package DTO;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="articulo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticuloDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement
	private int codigo;
	@XmlElement
	private String codigoDeposito;
	@XmlElement
	private String color;
	@XmlElement
	private String descripcion;
	@XmlElement
	private String edadRecomendada;
	@XmlElement
	private String fichaTecnica;
	@XmlElement
	private String fotoURL;
	@XmlElement
	private String marca;
	@XmlElement
	private String material;
	@XmlElement
	private String nombre;
	@XmlElement
	private float precio;
	@XmlElement
	private String talle;
	@XmlElement
	private String tipo;
	@XmlElement
	private String origen;
	@XmlElement
	private String fecha;
	
	
	public ArticuloDTO() {
		super();		
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCodigoDeposito() {
		return codigoDeposito;
	}

	public void setCodigoDeposito(String codigoDeposito) {
		this.codigoDeposito = codigoDeposito;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEdadRecomendada() {
		return edadRecomendada;
	}
	public void setEdadRecomendada(String edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	public String getFichaTecnica() {
		return fichaTecnica;
	}
	public void setFichaTecnica(String fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	public String getFotoURL() {
		return fotoURL;
	}

	public void setFotoURL(String fotoURL) {
		this.fotoURL = fotoURL;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
