package controller;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoTemperatura;

import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins="*")
@Controller
public class TemperaturaInformacionController {

	@Autowired
	Temperatura_Service service;

	@GetMapping(value = "doMaximaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maxima() {

		DtoTemperatura tempMax=service.TemperaturaMaxima();
		 
		 return tempMax;

	}
	@GetMapping(value = "doMinimaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minima() {

		DtoTemperatura tempMin=service.TemperaturaMinima();
		 
		 return tempMin;

	}


	@GetMapping(value = "doMaximaTemperaturaDia", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maximaTemperaturaDia(@RequestParam("fecha")String fecha)  {
		
		
			
		
		 return service.TemperaturaMaximaDia(Utilidades.cambioFormato(fecha));

	}
	@GetMapping(value = "doMinimaTemperaturaDia", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minimaTemperatura(@RequestParam("fecha")String fecha) {
		
		
		 return service.TemperaturaMinimaDia(Utilidades.cambioFormato(fecha));


	}
	@GetMapping(value = "doMediaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double mediaTemperatura() {

		return service.mediaTemperatura();
	}

}
