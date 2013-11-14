package parsers;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import entityBean.ListaDePrecios;
import entityBean.Rodamiento;

public class ListaPreciosConverter implements Converter{

    public boolean canConvert(Class clazz) {
            return clazz.equals(ListaDePrecios.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,MarshallingContext context) {
    	ListaDePrecios lp = (ListaDePrecios) value;
    	writer.startNode("nroLista");
    	int nro = lp.getNroLista();
       	writer.setValue(String.valueOf(nro));
       	writer.endNode();
       	writer.startNode("proveedor");
    	writer.startNode("cuit");
		writer.setValue("04");
		writer.endNode();
       	writer.startNode("razonSocial");
       	writer.setValue(lp.getProveedor().getRazonSocial());
       	writer.endNode();
       	writer.startNode("telefono");
       	writer.setValue(lp.getProveedor().getTelefono());
       	writer.endNode();
       	writer.startNode("direccion");
       	writer.setValue(lp.getProveedor().getDireccion());
       	writer.endNode();
       	writer.startNode("ciudad");
       	writer.setValue(lp.getProveedor().getCiudad());
       	writer.endNode();
       	writer.startNode("provincia");
       	writer.setValue(lp.getProveedor().getProvincia());
       	writer.endNode();
       	writer.startNode("cod_postal");
       	writer.setValue(lp.getProveedor().getCod_postal());
       	writer.endNode();
       	writer.endNode();
       	
    	writer.startNode("vigenciaDesde");
    	String fecha = lp.getVigenciaDesde().toString();
    	fecha = fecha.replace("-", "");
       	writer.setValue(fecha);
       	writer.endNode();
       	writer.startNode("vigenciaHasta");
    	fecha = lp.getVigenciaHasta().toString();
    	fecha = fecha.replace("-", "");
       	writer.setValue(fecha);
       	writer.endNode();
       	
       	writer.startNode("itemsLP");
        for (Rodamiento r : lp.getItemsLP()){
        	writer.startNode("Rodamiento");
        	writer.startNode("codigoRodamiento");
           	writer.setValue(r.getCodigoRodamiento());
           	writer.endNode();
           	writer.startNode("precio");
           	writer.setValue(String.valueOf(r.getPrecio()));
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
