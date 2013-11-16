package servicios;

import webservice.LogisticaMonitoreoBeanService;
import webservice.LogisticaMonitoreoWS;
import DTO.LogDTO;
import DTO.VentaDTO;
import entityBean.Config;

public class InformarLyMSincronico {

	public static String informarVenta(VentaDTO venta, Config conf) {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		LogisticaMonitoreoBeanService service1 = new LogisticaMonitoreoBeanService();
		System.out.println("Create Web Service...");
		LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("***********************");
		System.out.println("Call Over!");
		return port1.informarVenta(venta.toString());
	}
	
	public static String informarLog(LogDTO logDTO, Config conf) {
		System.out.println("***********************");
		System.out.println("Create Web Service Client...");
		LogisticaMonitoreoBeanService service1 = new LogisticaMonitoreoBeanService();
		
		System.out.println("Create Web Service...");
		LogisticaMonitoreoWS port1 = service1.getLogisticaMonitoreoWSPort();
		System.out.println("Call Web Service Operation...");
		System.out.println("***********************");
		System.out.println("Call Over!");
		return port1.informarLog(logDTO.toString());
	}
}
