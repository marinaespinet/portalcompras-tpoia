package parsers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import entityBean.CasaCentral;
import entityBean.ItemOrdenCompraCC;
import entityBean.ItemSolicitudMP;
import entityBean.MateriaPrima;
import entityBean.OrdenCompraCC;
import entityBean.Proveedor;
import entityBean.Rodamiento;
import entityBean.SolicitudMatPrima;

public class FromXMLToObject {
	public OrdenCompraCC ordenCompra(String xml){
		XStream xstream = new XStream();
		class OrdenCompra {
			private String fecha;
			private int nroOrdenCompra;
			private CasaCentral cliente;
			private List<ItemOrdenCompraCC> itemsOCCC;
		}
		xstream.alias("OrdenCompraCC", OrdenCompra.class);
		xstream.alias("ItemOrdenCompraCC", ItemOrdenCompraCC.class);
		xstream.omitField(ItemOrdenCompraCC.class, "ordenCompra");
		OrdenCompra o = (OrdenCompra)xstream.fromXML(xml);	
		String format = "yyyyMMdd";
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    Date d = new Date(); 
	    try{
	    	d = sdf.parse(o.fecha);
	    }catch(ParseException e){e.printStackTrace();}
	    java.sql.Date fecha = new java.sql.Date(d.getTime());
		OrdenCompraCC occ = new OrdenCompraCC();
		occ.setFecha(fecha);
		occ.setNroOrden(o.nroOrdenCompra);
		occ.setItemsOCCC(o.itemsOCCC);
		occ.setCliente(o.cliente);
		return occ;
	}
	
	public SolicitudMatPrima solicitudMateriaPrima(String xml){
		XStream xstream = new XStream();
		xstream.alias("SolicitudMatPrima", SolicitudMatPrima.class);
		xstream.alias("MateriaPrima", MateriaPrima.class);
		xstream.alias("Rodamiento", Rodamiento.class);
		xstream.alias("Proveedor", Proveedor.class);
		xstream.alias("ItemSolicitudMP", ItemSolicitudMP.class);
		xstream.alias("OrdenCompracc", OrdenCompraCC.class);
		SolicitudMatPrima smp = (SolicitudMatPrima)xstream.fromXML(xml);
		return smp;	
	}
}
