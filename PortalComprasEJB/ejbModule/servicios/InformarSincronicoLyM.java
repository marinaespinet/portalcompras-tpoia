package servicios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import util.TransformerUtil;
import webservice.LogisticaMonitoreoBeanService;
import webservice.LogisticaMonitoreoWS;
import DTO.LogDTO;
import DTO.VentaDTO;
import entityBean.ConfigSincronica;

public class InformarSincronicoLyM  {

	private static final int TIME_OUT = 5;
	
	public static String informarVenta(VentaDTO venta, ConfigSincronica conf)
			throws Exception {
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

	private static LogisticaMonitoreoBeanService getBeanService(
			ConfigSincronica conf) throws MalformedURLException, InterruptedException, ExecutionException, TimeoutException {
		final URL url = new URL("http://" + conf.getIp() + ":" + conf.getPuerto()
				+ "/" + conf.getUrl() + "?wsdl");

		ExecutorService executor = Executors.newSingleThreadExecutor();

		Callable<LogisticaMonitoreoBeanService> task = new Callable<LogisticaMonitoreoBeanService>() {
			@Override
			public LogisticaMonitoreoBeanService call() throws Exception {
				return new LogisticaMonitoreoBeanService(url);
			}

		};
		 Future<LogisticaMonitoreoBeanService> future = executor.submit(task);
		 //seteo el timeOut
		 return future.get(TIME_OUT, TimeUnit.SECONDS);
	}

	public static String informarLog(LogDTO logDTO, ConfigSincronica conf)
			throws Exception {

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
