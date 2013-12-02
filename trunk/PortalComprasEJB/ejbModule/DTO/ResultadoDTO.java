package DTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import tipoYEstados.EEstadoRetorno;


@XmlRootElement(name = "resultado")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultadoDTO {

	public ResultadoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ResultadoDTO(String estado, String mensaje) {
		this.estado = estado;
		this.mensaje = mensaje;
	}
	
	public ResultadoDTO(EEstadoRetorno estado, String mensaje) {
		this.estado = estado.toString();
		this.mensaje = mensaje;
	}

	@XmlElement
	private String estado;
	@XmlElement
	private String mensaje;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public static ResultadoDTO getResultadoOK() {
		return new ResultadoDTO(EEstadoRetorno.OK, null);
	}
	
	public static ResultadoDTO getResultadoError(String mensaje) {
		return new ResultadoDTO(EEstadoRetorno.ERROR, mensaje);
	}
	
	public boolean isError(){
		return this.estado.equalsIgnoreCase(EEstadoRetorno.ERROR.toString());
	}

}
