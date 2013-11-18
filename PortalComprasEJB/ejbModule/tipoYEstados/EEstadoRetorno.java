package tipoYEstados;

public enum EEstadoRetorno {
	ERROR, OK;
	
	public static EEstadoRetorno getEstado(boolean ok){
		if(ok){
			return OK;
		}else{
			return ERROR;
		}
	}
}
