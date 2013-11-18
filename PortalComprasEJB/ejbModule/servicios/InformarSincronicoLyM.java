package servicios;

import java.net.MalformedURLException;
import java.net.URL;

import util.TransformerUtil;
import webservice.LogisticaMonitoreoBeanService;
import webservice.LogisticaMonitoreoWS;
import DTO.LogDTO;
import DTO.VentaDTO;
import entityBean.ConfigSincronica;

public class InformarSincronicoLyM {

	public static String informarVenta(VentaDTO venta, ConfigSincronica conf) throws Exception {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		LogisticaMonitoreoBeanService service1 = getBeanService(conf);
		System.out.println("Create Web Service...");
		LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("***********************");
		System.out.println("Call Over!");
		return port1.informarVenta(TransformerUtil.getXML(venta));
	}
	
	private static LogisticaMonitoreoBeanService getBeanService(ConfigSincronica conf) throws MalformedURLException {
		URL url = new URL("http://" + conf.getIp() + ":" + conf.getPuerto() +  "/" + conf.getUrl()+ "?wsdl");
		return new LogisticaMonitoreoBeanService(url);
	}

	public static String informarLog(LogDTO logDTO, ConfigSincronica conf)  throws Exception {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		LogisticaMonitoreoBeanService service1 = getBeanService(conf);
		
		System.out.println("Create Web Service...");
		LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("***********************");
		System.out.println("Call Over!");
		return port1.informarLog(TransformerUtil.getXML(logDTO));
	}
}
