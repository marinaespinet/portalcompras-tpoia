package servicios;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.jboss.logging.Logger;

import util.TransformerUtil;
import DTO.LogDTO;
import entityBean.ConfigAsincronica;

public class InformarAsincronicoLyM {
	
	private static Logger logger = Logger.getLogger(InformarAsincronicoLyM.class);
	
	private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";

	private static final String DEFAULT_DESTINATION = "jms/queue/log";

	private static final String DEFAULT_USERNAME = "log";

	private static final String DEFAULT_PASSWORD = "log1234";

	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";


	public static void informarLog(LogDTO log, ConfigAsincronica conf) throws Exception {

		ConnectionFactory connectionFactory = null;

		Connection connection = null;

		Session session = null;

		MessageProducer producer = null;

		Destination destination = null;
		
		String host = conf.getIp();
		String port = conf.getPuerto();
    	String user = conf.getUser();
		//String cola = conf.getNombre();
    	String cola = null;
		String pass = conf.getPassword();
		
		if(user == null ){
			user = DEFAULT_USERNAME;
		}
		if(pass == null){
			pass = DEFAULT_PASSWORD;
		}
    	if(cola==null){
    		cola = DEFAULT_DESTINATION;
    	}
    	
    	
 
    	  

		Context context = null;

		// Set up the context for the JNDI lookup

		final Properties env = new Properties();


		env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, "remote://" +
  			  host + ":" + port));
  	  env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", user));
  	  env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", pass));
  	  env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		context = new InitialContext(env);

		// Perform the JNDI lookups

		String connectionFactoryString = System.getProperty(
				"connection.factory", DEFAULT_CONNECTION_FACTORY);

		connectionFactory = (ConnectionFactory) context
				.lookup(connectionFactoryString);

		String destinationString = System.getProperty("destination",
				cola);

		destination = (Destination) context.lookup(destinationString);

		// Create the JMS connection, session, producer, and consumer

		connection = connectionFactory.createConnection(
				System.getProperty("username", user),
				System.getProperty("password", pass));

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		producer = session.createProducer(destination);

		connection.start();

		// crear un mensaje de tipo text y setearle el contenido

		TextMessage message = session.createTextMessage();

		String xml = TransformerUtil.getXML(log);
		logger.info("logXML : "+xml);
		message.setText(xml);

		// enviar el mensaje

		producer.send(message);

		connection.close();

	}
}
