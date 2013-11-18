package servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import fachada.Fachada;

/**
 * Session Bean implementation class ServidorEstadoEntregaBean
 */
@Stateless
@WebService (name="ServidorEstadoEntregaBean",
serviceName="ServidorEstadoEntregaBeanService",
targetNamespace="http://portalEstadoEntrega/",
portName="ServidorEstadoEntregaBeanPort")
// para q se adapte al contrato deberi ser @WebService solo
public class ServidorEstadoEntregaBean implements ServidorEstadoEntrega {

	@EJB
	private Fachada fachada;
	
    public ServidorEstadoEntregaBean() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod
    public String notificarEntregaDespacho(int nro){
    	try {
			String resultado = fachada.cambioEstado(nro);
			return this.getResultadoXML(resultado);
    	} catch (Exception e ) {
    		logger.error("Error notificacion estado de entrega: " + e.getMessage() + "\n");
    		return this.getResultadoXML(e.getMessage());
    	}
    }

}
