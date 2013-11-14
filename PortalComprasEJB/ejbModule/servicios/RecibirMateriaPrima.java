package servicios;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;

import entityBean.ItemSolicitudMP;
import entityBean.SolicitudMatPrima;
import fachada.Fachada;

import parsers.FromXMLToObject;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="queue/recibirMateriaPrima")
	})
	
public class RecibirMateriaPrima implements MessageListener {
	@EJB
	private Fachada fachada;

	public void onMessage(Message m) {
		if (m instanceof TextMessage) {
			TextMessage msg = (TextMessage) m;
			try {
				String xml = msg.getText();
				FromXMLToObject f = new FromXMLToObject();
				SolicitudMatPrima smp = f.solicitudMateriaPrima(xml);
				System.out.println("Materia prima recibida de solicitud N° "+smp.getNroSolicitudMP());
				for (ItemSolicitudMP imp : smp.getItems()){
					System.out.println("Recibido "+imp.getMateriaPrima().getDescripcion()+" X "+imp.getCantidad());
				}
				fachada.recepcionMatPrima(smp);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Mensaje de tipo incorrecto "); 
			}
	}
}
