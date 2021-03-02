package controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.Setpoint;
import dto.DtoUsuario;
import service.SetPoint_Service;

@CrossOrigin(origins = "*")
@Controller
public class SetPoint_Controller {
     
	@Autowired
	SetPoint_Service service;
	
	@PostMapping("doAgregarSetPoint")
	public String agregarset(@RequestParam("temp") String temp1, @RequestParam("humedades") String humedades,
			HttpSession sesion) throws IOException {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");
		
		service.añadirSetPoint(new Setpoint(usuarios.getIdUsuario(),Integer.parseInt(humedades),Integer.parseInt(temp1)));	
		
		return "configuracion.html";

	}
	@PostMapping("doActualizarSetPoint")
	public String  actualizar(@RequestParam("temp") String temp1, @RequestParam("humedades") String humedades,HttpSession sesion) throws IOException {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");
		
		service.actualizarSetPoint(new Setpoint(usuarios.getIdUsuario(),Integer.parseInt(humedades),Integer.parseInt(temp1)));	
		
		return "configuracion.html";

	}
	@GetMapping("doBorrarSetPoint")
	public String borrar(HttpSession sesion) throws IOException {

		DtoUsuario usuarios = (DtoUsuario) sesion.getAttribute("usuario");
		
		service.deleteSetPoint( usuarios.getIdUsuario());	
		
		return "configuracion.html";
	}

	
}
