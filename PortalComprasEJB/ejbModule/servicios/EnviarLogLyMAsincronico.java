package servicios;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviarLogLyMAsincronico {
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";

	private static final String DEFAULT_DESTINATION = "jms/queue/log";

	private static final String DEFAULT_USERNAME = "log";

	private static final String DEFAULT_PASSWORD = "log123";

	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";

	private static final String PROVIDER_URL = "remote://localhost:4447";

	public void enviarLog() throws NamingException, JMSException {

		ConnectionFactory connectionFactory = null;

		Connection connection = null;

		Session session = null;

		MessageProducer producer = null;

		Destination destination = null;

		Context context = null;

		// Set up the context for the JNDI lookup

		final Properties env = new Properties();

		env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);

		env.put(Context.PROVIDER_URL,
				System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));

		env.put(Context.SECURITY_PRINCIPAL,
				System.getProperty("username", DEFAULT_USERNAME));

		env.put(Context.SECURITY_CREDENTIALS,
				System.getProperty("password", DEFAULT_PASSWORD));

		context = new InitialContext(env);

		// Perform the JNDI lookups

		String connectionFactoryString = System.getProperty(
				"connection.factory", DEFAULT_CONNECTION_FACTORY);

		connectionFactory = (ConnectionFactory) context
				.lookup(connectionFactoryString);

		String destinationString = System.getProperty("destination",
				DEFAULT_DESTINATION);

		destination = (Destination) context.lookup(destinationString);

		// Create the JMS connection, session, producer, and consumer

		connection = connectionFactory.createConnection(
				System.getProperty("username", DEFAULT_USERNAME),
				System.getProperty("password", DEFAULT_PASSWORD));

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		producer = session.createProducer(destination);

		connection.start();

		// crear un mensaje de tipo text y setearle el contenido

		TextMessage message = session.createTextMessage();

		message.setText("xml");

		// enviar el mensaje

		producer.send(message);

		connection.close();

	}
}
