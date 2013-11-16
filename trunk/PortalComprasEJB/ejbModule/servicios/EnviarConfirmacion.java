package servicios;


public class EnviarConfirmacion {
/*
	public void enviarConfirmacion(OrdenCompraCCAcep occ, String ip) {
		Hashtable props = new Hashtable();
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		props.put(InitialContext.PROVIDER_URL, "jnp://" + ip + ":1099");
		try {
			Context ctx = new InitialContext(props);
			// buscar la Connection Factory en JNDI
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx
					.lookup("ConnectionFactory");
			// buscar la Cola en JNDI
			Queue queue = (Queue) ctx.lookup("queue/ordenCompraAcepQueue");
			// crear la connection y la session a partir de la connection
			QueueConnection qCon = qfactory.createQueueConnection();
			QueueSession qSession = qCon.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			// crear un producer para enviar mensajes usando la session
			QueueSender qSender = qSession.createSender(queue);
			// crear un mensaje de tipo text y setearle el contenido
			TextMessage message = qSession.createTextMessage();
			FromObjectToXml f = new FromObjectToXml();
			String xml = f.ordenCompraCCAcep(occ);
			message.setText(xml);
			// enviar el mensaje
			qSender.send(message);
			System.out.println("Confirmacion Enviada N��� "
					+ occ.getNroOrdenCompra());
			// cerrar la session y la connection
			qCon.close();
			qSender.close();
			qSession.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
