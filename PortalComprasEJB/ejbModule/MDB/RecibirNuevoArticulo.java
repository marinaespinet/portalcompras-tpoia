package MDB;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: RecibirNuevoArticulo
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/deposito") }, mappedName = "queue/deposito")
public class RecibirNuevoArticulo implements MessageListener {

	/**
	 * Default constructor.
	 */
	public RecibirNuevoArticulo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		TextMessage txtmsg = (TextMessage) message;
		try {
			System.out
					.println("Recibido Mensaje Cola Test " + txtmsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
