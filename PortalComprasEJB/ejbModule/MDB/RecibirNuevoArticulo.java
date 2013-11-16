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
import fachada.FachadaBean;

/**
 * Message-Driven Bean implementation class for: RecibirNuevoArticulo
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/deposito") }, mappedName = "queue/deposito")
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
