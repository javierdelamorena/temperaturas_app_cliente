package controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import dto.DtoTemperatura;
import dto.DtoUsuario;
import service.Temperatura_Service;
import util.Utilidades;

@CrossOrigin(origins = "*")
@Controller
public class TemperaturaInformacionController {

	@Autowired
	Temperatura_Service service;

	@GetMapping(value = "doMaximaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maxima(@SessionAttribute("usuario") DtoUsuario usuario) {
		System.out.println("hola");

		System.out.println("este es el atributo de sesion" + usuario.getIdUsuario());
		DtoTemperatura tempMax = service.TemperaturaMaxima(usuario.getIdUsuario());
		System.out.println(tempMax.getTemp1()+"   "+tempMax.getHumedad());
		return tempMax;

	}

	@GetMapping(value = "doMinimaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minima(HttpSession sesion) {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");

		DtoTemperatura tempMin = service.TemperaturaMinima(usuarios.getIdUsuario());

		return tempMin;

	}

	@GetMapping(value = "doMaximaTemperaturaDia", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura maximaTemperaturaDia(@RequestParam("fecha") String fecha,
			@SessionAttribute("usuario") DtoUsuario usuario) {
		System.out.println("fecha en doMaximaTemperaturaDia" + fecha);

		String local = Utilidades.cambioFormato(fecha);
		System.out.println(local);
		DtoTemperatura max=service.TemperaturaMaximaDia(local, usuario.getIdUsuario());
		
		System.out.println("esto es en el controller doMaximaTemperaturaDia: "+max.getFecha());
		return max;

	}

	@GetMapping(value = "doMinimaTemperaturaDia", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody DtoTemperatura minimaTemperatura(@RequestParam("fecha") String fecha,
			@SessionAttribute("usuario") DtoUsuario usuario) {

		String local = Utilidades.cambioFormato(fecha);
		
		DtoTemperatura min=service.TemperaturaMinimaDia(local, usuario.getIdUsuario());

		return min;

	}

	@GetMapping(value = "doMediaTemperatura", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody double mediaTemperatura(@SessionAttribute("usuario") DtoUsuario usuario) {

		return service.mediaTemperatura(usuario.getIdUsuario());
	}

}
