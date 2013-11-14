package servicios;

import java.util.Hashtable;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import parsers.FromObjectToXml;

import entityBean.SolicitudMatPrima;

public class EnviarSolicitud {
	
	public void enviarSolicitud(SolicitudMatPrima smp, String ip){
	Hashtable props = new Hashtable();
	props.put(InitialContext.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
	props.put(InitialContext.PROVIDER_URL,"jnp://"+ip+":1099");
	try{
	Context ctx = new InitialContext(props);
	// buscar la Connection Factory en JNDI
	QueueConnectionFactory qfactory = (QueueConnectionFactory)ctx.lookup("ConnectionFactory");
	// buscar la Cola en JNDI
	Queue queue = (Queue) ctx.lookup("queue/recibirSolicitud");
	// crear la connection y la session a partir de la connection
	QueueConnection qCon = qfactory.createQueueConnection();
	QueueSession qSession = qCon.createQueueSession(false,Session.AUTO_ACKNOWLEDGE);
	// crear un producer para enviar mensajes usando la session
	QueueSender qSender = qSession.createSender(queue);
	// crear un mensaje de tipo text y setearle el contenido
	TextMessage message = qSession.createTextMessage();
	FromObjectToXml f = new FromObjectToXml();
	String xml = f.solicitudMateriaPrima(smp);
	message.setText(xml);
	// enviar el mensaje
	qSender.send(message);
	System.out.println("Solicitud MP N°"+smp.getNroSolicitudMP()+" Enviada");
	//cerrar la session y la connection 
	qCon.close();
	qSender.close();
	qSession.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
