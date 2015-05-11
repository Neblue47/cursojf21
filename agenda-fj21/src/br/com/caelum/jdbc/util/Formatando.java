package br.com.caelum.jdbc.util;

//import java.sql.Date;
import java.util.Calendar;

//import br.com.caelum.jdbc.DateFormat;
import java.text.*;//SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Formatando {
	
	
		
	public String formataData(java.util.Calendar data){  
	    return String.format("%1$td%1$tm%1$tY",data) ; 
	}
}
