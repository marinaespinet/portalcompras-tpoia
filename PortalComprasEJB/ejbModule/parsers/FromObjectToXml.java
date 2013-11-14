package parsers;

import com.thoughtworks.xstream.XStream;

import entityBean.ListaDePrecios;
import entityBean.OrdenCompraCCAcep;
import entityBean.Rodamiento;
import entityBean.SolicitudMatPrima;

public class FromObjectToXml {
	/*public String ordenCompra(OrdenCompraCC occc){
		XStream xstream = new XStream();
		xstream.alias("OrdenCompraCC", OrdenCompraCC.class);
		xstream.alias("ItemOrdenCompraCC", ItemOrdenCompraCC.class);
		xstream.omitField(ItemOrdenCompraCC.class, "ordenCompra");
		String occcXML = xstream.toXML(occc);
		return occcXML;
	}*/

	public String solicitudMateriaPrima(SolicitudMatPrima solMP) {
		XStream xstream = new XStream();
		xstream.registerConverter(new SolMPConverter());
		xstream.alias("SolicitudMatPrima", SolicitudMatPrima.class);
		String smpXML = xstream.toXML(solMP);	
		return smpXML;	
	}
	
	public String listaDePrecios(ListaDePrecios lp){
		XStream xstream = new XStream();
		xstream.registerConverter(new ListaPreciosConverter());
		xstream.alias("ListaDePrecios", ListaDePrecios.class);
		String lpXML = xstream.toXML(lp);	
		return lpXML;	
	}

	public String ordenCompraCCAcep(OrdenCompraCCAcep occ) {
		XStream xstream = new XStream();
		xstream.alias("OrdenCompraCCAcep", OrdenCompraCCAcep.class);
		String xml = xstream.toXML(occ);
		return xml;
	}
	
	public String Rodamiento(Rodamiento rod){
		XStream xstream = new XStream();
		xstream.registerConverter(new RodamientoConverter());
		xstream.alias("Rodamiento", Rodamiento.class);
		String xml = xstream.toXML(rod);
		return xml;
	}
}
