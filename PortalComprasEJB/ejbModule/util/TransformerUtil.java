package util;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jboss.dmr.JSONParser;
import org.jboss.dmr.JSONParserImpl;
import org.jboss.resteasy.util.GenericType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import DTO.ArticuloDTO;
import DTO.BestSellerDTO;
import DTO.ResultadoDTO;

import entityBean.Articulo;
import entityBean.Electrodomestico;
import entityBean.Moda;
import entityBean.Mueble;
import entityBean.Nino;

public class TransformerUtil {

	
	public static Articulo toArticulo(ArticuloDTO aDTO) {
		Articulo a = null;
		if (aDTO.getTipo().equalsIgnoreCase("Electrodomesticos")) {
			Electrodomestico e = new Electrodomestico();
			a = e;
			e.setFichaTecnica(aDTO.getFichaTecnica());
		} else if (aDTO.getTipo().equalsIgnoreCase("moda")) {
			Moda m = new Moda();
			a = m;
			m.setColor(aDTO.getColor());
			m.setTalle(aDTO.getTalle());
		} else if (aDTO.getTipo().equalsIgnoreCase("Muebles")) {
			Mueble m = new Mueble();
			a = m;
			m.setMaterial(aDTO.getMaterial());
		} else if (aDTO.getTipo().equalsIgnoreCase("niños")) {
			Nino n = new Nino();
			a = n;
			n.setEdadRecomendada(aDTO.getEdadRecomendada());
		}
		a.setCodigo(aDTO.getCodigo());
		a.setDescripcion(aDTO.getDescripcion());
		a.setFoto(aDTO.getFotoURL());
		a.setMarca(aDTO.getMarca());
		a.setNombre(aDTO.getNombre());
		a.setOrigen(aDTO.getOrigen());
		a.setPrecio(aDTO.getPrecio());

		return a;
	}
	
	public static String getXML(Object o) throws Exception{
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(o.getClass());
			Marshaller m = jc.createMarshaller();
	    	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
	    			Boolean.TRUE);
	    	StringWriter writer = new StringWriter();
	    	m.marshal(o,writer);
	    	return writer.toString();
		} catch (JAXBException e) {
		//	logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "";	    	
	}
	
	public static <E> E getObjectFromXml(String xml, Class<E> clase) throws Exception{
		JAXBContext jc;
		try {
			return (E) JAXBContext.newInstance(clase)
			.createUnmarshaller()
			.unmarshal(new StringReader(xml));
		} catch (JAXBException e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
		return null;	    	
	}
	
	public static List<BestSellerDTO> getListBestSellerFromJSON(String json) throws JSONException{
		JSONObject obj = new JSONObject(json);
		List<BestSellerDTO> ret = new LinkedList<BestSellerDTO>();
		//JSONArray array =  new JSONArray(json);
		JSONArray listJson = obj.getJSONArray("rankings");
		for(int i=0;i<listJson.length();i++){
			JSONObject b = listJson.getJSONObject(1);
			 System.out.println(b);
			 ret.add(new BestSellerDTO((Integer) b.get("codigoArticulo"), (Integer) b.get("posicion")));
		}
		return ret;
	}
}
