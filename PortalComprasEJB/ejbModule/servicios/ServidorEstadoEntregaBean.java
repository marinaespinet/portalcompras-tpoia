package servicios;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Session Bean implementation class ServidorEstadoEntregaBean
 */
@Stateless
@WebService (name="ServidorEstadoEntregaBean",
serviceName="ServidorEstadoEntregaBeanService",
targetNamespace="http://portalEstadoEntrega/",
portName="ServidorEstadoEntregaBeanPort")
public class ServidorEstadoEntregaBean implements ServidorEstadoEntrega {

    /**
     * Default constructor. 
     */
    public ServidorEstadoEntregaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod
    public String notificarEntregaDespacho(int nro){
    	return null;
    }

}
