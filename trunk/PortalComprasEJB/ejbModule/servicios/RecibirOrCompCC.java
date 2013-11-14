package servicios;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;

import parsers.FromXMLToObject;

import entityBean.ItemOrdenCompraCC;
import entityBean.OrdenCompraCC;
import fachada.Fachada;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="queue/ordenCompraQueue")
	})
	
public class RecibirOrCompCC implements MessageListener {
	@EJB
	private Fachada fachada;

	public void onMessage(Message m) {
		if (m instanceof TextMessage) {
			TextMessage msg = (TextMessage) m;
			try {
				String xml = msg.getText();
				FromXMLToObject to = new FromXMLToObject();
				OrdenCompraCC ord = to.ordenCompra(xml);
				System.out.println("Orden de Compra N°"+ord.getNroOrden()+" recibida");
				for (ItemOrdenCompraCC ioc : ord.getItemsOCCC()){
					System.out.println("Item Solicitado: "+ioc.getRodamiento().getCodigoRodamiento()+" X "+ioc.getCantidad());
				}
				fachada.ProcesarOrdenCompraCC(ord);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Mensaje de tipo incorrecto"); }
	}
}
