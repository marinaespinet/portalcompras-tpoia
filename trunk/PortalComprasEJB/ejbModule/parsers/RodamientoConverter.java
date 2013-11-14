package parsers;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import entityBean.Rodamiento;

public class RodamientoConverter implements Converter{

	public boolean canConvert(Class clazz) {
		return clazz.equals(Rodamiento.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Rodamiento r = (Rodamiento) value;
		writer.startNode("codigoRodamiento");
		writer.setValue(r.getCodigoRodamiento());
		writer.endNode();
		writer.startNode("caracteristica");
		writer.setValue(r.getCaracteristica());
		writer.endNode();
		writer.startNode("marca");
		writer.setValue(r.getMarca());
		writer.endNode();
		writer.startNode("origen");
		writer.setValue(r.getOrigen());
		writer.endNode();
		writer.startNode("tipo");
		writer.setValue(r.getTipo());
		writer.endNode();
		writer.startNode("cod_propietario");
		writer.setValue("04");
		writer.endNode();
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		return null;
	}

}
