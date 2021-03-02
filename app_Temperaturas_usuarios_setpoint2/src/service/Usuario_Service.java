package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import dto.DtoUsuario;

public interface Usuario_Service {
	
	
	
	String darDeAlta(DtoUsuario usuario);
	String darDeBaja(DtoUsuario usuario);
	List<DtoUsuario> todos();
	DtoUsuario Logging(String nombre,String password  );

}
