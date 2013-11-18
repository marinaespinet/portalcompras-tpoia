package util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FechaUtil {

	public static Timestamp getFechaActual (){
		Timestamp fecha = new Timestamp(Calendar.getInstance().getTimeInMillis());
		return fecha;	
	}
	
	public static String toStringXml (Timestamp fecha){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(fecha);		
	}
}
