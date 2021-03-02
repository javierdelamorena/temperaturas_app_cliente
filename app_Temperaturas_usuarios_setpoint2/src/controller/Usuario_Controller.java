package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import dto.DtoUsuario;
import service.Usuario_Service;

@Controller
public class Usuario_Controller {
	
	@Autowired
	Usuario_Service service;
	
	
	
	@PostMapping(value="doAlta",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String registrar(@RequestParam("nombre")String nombre,
			@RequestParam("password")String password,
			@RequestParam("email")String email,
			@RequestParam("idUsuario")String idUsuario) {
		
		DtoUsuario usuario=new DtoUsuario(Integer.parseInt(idUsuario),nombre,password,email);
		service.darDeAlta(usuario);
		
		
		return "loging";
		
		
	}
    @PostMapping(value="doBaja",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String darDeBaja(@RequestParam("nombre")String nombre,
			@RequestParam("password")String password,
			@RequestParam("email")String email,
			@RequestParam("idUsuario")String idUsuario) {
    	
    	DtoUsuario usuario=new DtoUsuario(Integer.parseInt(idUsuario),nombre,password,email);
    			   
        service.darDeBaja(usuario);
    				
		
		
		return "alta";
		
		
	}
   @GetMapping(value="doTodos",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List<DtoUsuario> todas(HttpSession sesion) {
	   
	   List<DtoUsuario>lista=service.todos();
		
		return lista;
		
		
	}
   @GetMapping(value="doLoging",produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String todas(@RequestParam("nombre")String nombre,@RequestParam("password")String password,HttpSession sesion) {
		
	   DtoUsuario usuario=service.Logging(nombre, password);
	   
	   sesion.setAttribute("usuario", usuario);
	   
	   System.out.println("este el logging"+usuario.getIdUsuario());
		   
		   return "menu";
		   
	  
		
		
		
		
	}
   
    

}
