package controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.DtoTemperatura;

import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins="*")
@Controller
public class TemperaturaController {

	@Autowired
	Temperatura_Service service;

	@GetMapping(value = "doTodasTemperaturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoTemperatura> temperaturas() {

		
		
		List<DtoTemperatura> lista = service.todas();

		
		return lista;
	}

	@PostMapping(value="doAgregarTemperaturas", produces = MediaType.TEXT_PLAIN_VALUE)
	public String agregar(@RequestParam("temp1") String temp1, @RequestParam("humedad") String humedad,
			HttpSession sesion) {
		
		
		
		service.agregarTeperatuta(Integer.parseInt(temp1),Integer.parseInt(humedad));

		return "respuestaMicro.html";

	}

	@GetMapping(value = "doMostrarTemperaturas", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temperatura() {

		

		List<DtoTemperatura> listaString =  service.todas();

		

		return listaString;
	}

	@GetMapping(value = "doMostrarTemperaturaEntreFechas", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temp(HttpSession sesion) {
		

		LocalDate nfecha = (LocalDate) sesion.getAttribute("Fecha1");
		LocalDate nfecha2 = (LocalDate) sesion.getAttribute("Fecha2");
		

		List<DtoTemperatura> listaString = service.temperaturaEntreFechas(nfecha, nfecha2);


		
		listaString.forEach(l -> System.out.println(l.getFecha()));

		return listaString;
	}

	@PostMapping("doTemperaturaEntreFechas")

	public String temperaturaFechas(@RequestParam("fecha1") String fechaIni, @RequestParam("fecha2") String fechaFin,
			HttpSession sesion) throws ParseException {
		
		System.out.println(fechaIni);

		
		LocalDate nfecha = LocalDate.parse(fechaIni);
		LocalDate nfecha2 = LocalDate.parse(fechaFin);

		sesion.setAttribute("Fecha1", nfecha);
		sesion.setAttribute("Fecha2", nfecha2);

		return "graficoEntreFechas";
	}

}
