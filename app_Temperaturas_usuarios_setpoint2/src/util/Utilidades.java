package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;




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
		
		public static String cambioFormato(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(fecha, inputFormatter);
			String formattedDate = outputFormatter.format(date.plusHours(1));
			
			return formattedDate;
		}
		public static String cambioFormato3(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(fecha, inputFormatter);
			String formattedDate = outputFormatter.format(date.plusHours(1));
			
			return formattedDate;
		}
		public static String cambioFormato5(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(fecha, inputFormatter);
			String formattedDate = outputFormatter.format(date.plusHours(1));
			
			return formattedDate;
		}
		public static String cambioFormato4(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(fecha, inputFormatter);
			String formattedDate = outputFormatter.format(date.plusHours(1));
			
			return formattedDate;
		}
		public static String cambioFormato2(LocalDateTime fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
			String date = outputFormatter.format(fecha);
			
			
			return date;
		}
		public static LocalDateTime cambioFormato2(String fecha) {
			DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
			LocalDateTime local=LocalDateTime.parse(fecha,outputFormatter);
			
			
			
			return local;
		}
		
		
	}




