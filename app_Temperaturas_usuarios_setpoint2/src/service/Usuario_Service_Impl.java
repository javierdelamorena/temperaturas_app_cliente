package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.DtoUsuario;
@Service
public class Usuario_Service_Impl implements Usuario_Service{
	
	String url="http://localhost:8000/";
	
	@Autowired
	RestTemplate template;

	@Override
	public String darDeAlta(DtoUsuario usuario) {
		
		template.postForLocation(url+"UsuarioAlta",  usuario);
		
		return "tologing";
		
	}

	@Override
	public String darDeBaja(DtoUsuario usuario) {

		template.postForLocation(url+"UsuarioBaja", usuario);
		
		return "alta";
		
	}

	@Override
	public List<DtoUsuario> todos() {
		
	DtoUsuario[]usuarios=	template.getForObject(url+"UsuarioTodos", DtoUsuario[].class);
	
		return Arrays.asList(usuarios);
	}

	@Override
	public DtoUsuario Logging(String nombre, String password) {
		
	DtoUsuario usuario=template.getForObject(url+"Usuariologing/{nombre}/{password}",DtoUsuario.class, nombre,password);
	
	//System.out.println("este es el template"+usuario.getIdUsuario()+"    "+usuario.getNombre());
		
		return usuario;
	}

}
