package transformers;

import DTO.ArticuloDTO;
import entityBean.Articulo;
import entityBean.Electrodomestico;
import entityBean.Moda;
import entityBean.Mueble;
import entityBean.Nino;

public class Transformer {

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
}
