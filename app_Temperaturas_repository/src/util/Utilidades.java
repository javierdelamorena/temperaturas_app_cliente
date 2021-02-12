package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;


import dto.DtoTemperatura;




public class Utilidades {
	
		public static LocalDate convertirDateALocalDate(Date fecha) {	//convertir Date a LocalDate
			
			LocalDate ld=Instant.ofEpochMilli(fecha.getTime()) //Instant
					.atZone(ZoneId.systemDefault()) //ZoneDateTime
					.toLocalDate();
			System.out.println(ld);
			
			return ld;
		}
		public static Date convertirLocalDateADate(LocalDate fecha) {//convertir LocalDate a Date
			
			
			
			Date fe=Date.from(
					fecha.atStartOfDay(ZoneId.systemDefault()) //ZoneDateTime
					.toInstant()); //Instrant
			System.out.println(fe);
			return fe;
		}
		
		public static LocalDate cambioFormato(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			LocalDate date = LocalDate.parse(fecha, inputFormatter);
			String formattedDate = outputFormatter.format(date.plusDays(1));
			
			return date.plusDays(1);
		}
		
		
	}




