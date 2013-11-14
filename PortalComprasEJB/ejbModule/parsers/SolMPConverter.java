package parsers;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import entityBean.ItemSolicitudMP;
import entityBean.SolicitudMatPrima;

public class SolMPConverter implements Converter {

        public boolean canConvert(Class clazz) {
                return clazz.equals(SolicitudMatPrima.class);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {
        	SolicitudMatPrima SolMP = (SolicitudMatPrima) value;
        	writer.startNode("nroSolicitudMP");
        	int nro = SolMP.getNroSolicitudMP();
           	writer.setValue(String.valueOf(nro));
           	writer.endNode();
           	
           	writer.startNode("nroOrdenCC");
        	nro = SolMP.getNroOrdenCC();
           	writer.setValue(String.valueOf(nro));
           	writer.endNode();
        	
           	writer.startNode("cliente");
           	writer.startNode("cuit");
           	writer.setValue(SolMP.getCliente().getCuit().toString());
           	writer.endNode();
           	writer.endNode();
           	
           	writer.startNode("fecha");
           	writer.setValue(SolMP.getFecha().toString());
           	writer.endNode();
           	
           	writer.startNode("items");
            for (ItemSolicitudMP it : SolMP.getItems()){
            	writer.startNode("ItemSolicitudMP");
            	writer.startNode("id");
               	writer.setValue(String.valueOf(it.getId()));
               	writer.endNode();
               	writer.startNode("cantidad");
               	writer.setValue(String.valueOf(it.getCantidad()));
               	writer.endNode();
               	writer.startNode("materiaPrima");
               	writer.startNode("codigoMatPrima");
               	writer.setValue(it.getMateriaPrima().getCodigoMatPrima());
               	writer.endNode();
               	writer.endNode();
               	writer.endNode();
            }
            writer.endNode();
        }

        public Object unmarshal(HierarchicalStreamReader reader,
                        UnmarshallingContext context) {
                return null;
        }

}
