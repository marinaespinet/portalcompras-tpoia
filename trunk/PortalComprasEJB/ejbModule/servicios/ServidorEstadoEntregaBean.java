package servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import util.TransformerUtil;

import DTO.ResultadoDTO;

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
    public String notificarEntregaDespacho(int nro) throws Exception{
    	try {
			fachada.cambiarEstadoVenta(nro);
			
			return TransformerUtil.getXML(ResultadoDTO.getResultadoOK());
    	} catch (Exception e ) {
    		e.printStackTrace();
    		//logger.error("Error notificacion estado de entrega: " + e.getMessage() + "\n");
    		return TransformerUtil.getXML(ResultadoDTO.getResultadoError(e.getMessage()));
    	}
    }

}
