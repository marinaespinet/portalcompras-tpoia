package servicios;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import parsers.FromObjectToXml;
import ejb.casacentral.webservice.RemoteSessionBean;
import ejb.casacentral.webservice.RemoteSessionBeanServiceLocator;
import entityBean.Rodamiento;

public class EnviarRodamiento {
	
	public void enviarRodamiento(Rodamiento r, String ip){
		FromObjectToXml f = new FromObjectToXml();
		String xml = f.Rodamiento(r);
		RemoteSessionBeanServiceLocator serviceLocator = new RemoteSessionBeanServiceLocator();
		//cambio el endpoint
		serviceLocator.setEndpoint(ip);
		try {
			RemoteSessionBean port = serviceLocator.getRemoteSessionBeanPort();
			//Invocación del Web Service
			port.nuevoRodamiento(xml);
		} catch (ServiceException e) {
			e.printStackTrace();
		}catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
