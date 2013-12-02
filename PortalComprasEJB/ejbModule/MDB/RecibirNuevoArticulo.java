package MDB;

import java.io.StringReader;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;

import DTO.ArticuloDTO;
import fachada.Fachada;

/*@MessageDriven(mappedName = "queue/deposito", activationConfig = {
		@ActivationConfigProperty(propertyName = "clientId", propertyValue = "depositoClientID"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/deposito"),
		@ActivationConfigProperty(propertyName = "user", propertyValue = "deposito"),
		@ActivationConfigProperty(propertyName = "password", propertyValue = "deposito123"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })*/
@MessageDriven(mappedName = "jms/queue/deposito", activationConfig = {
		@ActivationConfigProperty(propertyName = "clientId", propertyValue = "depositoClientID"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/deposito"),
		@ActivationConfigProperty(propertyName = "user", propertyValue = "deposito"),
		@ActivationConfigProperty(propertyName = "password", propertyValue = "deposito123"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class RecibirNuevoArticulo implements MessageListener {

	@EJB
	private Fachada fachada;

	/**
	 * Default constructor.
	 */
	public RecibirNuevoArticulo() {
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		String articuloXML;
		ArticuloDTO art;
		try {
			articuloXML = ((TextMessage) message).getText();
			art = (ArticuloDTO) JAXBContext.newInstance(ArticuloDTO.class)
					.createUnmarshaller()
					.unmarshal(new StringReader(articuloXML));
			fachada.registrarArticulo(art);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
