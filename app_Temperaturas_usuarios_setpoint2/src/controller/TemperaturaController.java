package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import dto.Setpoint;
import dto.DtoTemperatura;
import dto.DtoUsuario;
import service.SetPoint_Service;
import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins = "*")
@Controller
public class TemperaturaController {

	@Autowired
	Temperatura_Service service;
	
	@Autowired
	SetPoint_Service services;

	@GetMapping(value = "doTodasTemperaturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<DtoTemperatura> temperaturas(@SessionAttribute("usuario") DtoUsuario usuario) {

		List<DtoTemperatura> lista = service.todas(usuario.getIdUsuario());

		return lista;
	}

	@PostMapping("doAgregarTemperaturas")
	public String agregar(@RequestParam("temp1") String temp1, @RequestParam("humedad") String humedad,
			HttpSession sesion, HttpServletResponse response) throws IOException {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");
		service.agregarTemperatura(Integer.parseInt(temp1), Integer.parseInt(humedad), usuarios.getIdUsuario());

		return "agregar.html";

	}

	@PostMapping("doAgregarTemperaturasMicro")
	public String agregarMicro(HttpSession sesion, HttpServletResponse response, @RequestParam("temp1") String temp1,
			@RequestParam("humedad") String humedad, @RequestParam("idUsuario") String idUsuario) throws IOException {

		service.agregarTemperatura(Integer.parseInt(temp1), Integer.parseInt(humedad), Integer.parseInt(idUsuario));
		
			
		List<Setpoint> dto=services.recuperarSetPoint(Integer.parseInt(idUsuario));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		for(Setpoint e:dto) {
		out.println("++++");
		out.println(+e.getTemp());
		
		out.println(+e.getHumedades());
		
		out.close();
		}
		

		return "respuestaMicro.html";

	}

	

	@GetMapping(value = "doMostrarTemperaturas", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temperatura(HttpSession sesion) {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");

		List<DtoTemperatura> listaString = service.todas(usuarios.getIdUsuario());

		return listaString;
	}

	@GetMapping(value = "doMostrarTemperaturaEntreFechas", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody List<DtoTemperatura> temp(HttpSession sesion) {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");

		String fecha1 = (String) sesion.getAttribute("Fecha1");
		String fecha2 = (String) sesion.getAttribute("Fecha2");
		System.out.println("esto es lo que dice que null: " + fecha1 + " la otra: " + fecha2);
		List<DtoTemperatura> listaString = service.temperaturaEntreFechas(fecha1, fecha2, usuarios.getIdUsuario());

		listaString.forEach(l -> System.out.println(l.getFecha()));

		return listaString;
	}

	@PostMapping("doTemperaturaEntreFechas")

	public String temperaturaFechas(@RequestParam("fecha1") String fechaIni, @RequestParam("fecha2") String fechaFin,
			HttpSession sesion) throws ParseException {

		System.out.println("esta es la fecha en doTemperaturaEntreFechas" + fechaIni + " yesta la otra" + fechaFin);

		sesion.setAttribute("Fecha1", Utilidades.cambioFormato5(fechaIni));
		sesion.setAttribute("Fecha2", Utilidades.cambioFormato5(fechaFin));

		return "graficoEntreFechas";
	}

}
