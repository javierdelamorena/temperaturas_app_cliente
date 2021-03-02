package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.Setpoint;

@Service
public class SetPoint_Service_Impl implements SetPoint_Service {
	
	String url = "http://localhost:8000/";

	@Autowired

	RestTemplate template;

	@Override
	public List<Setpoint> recuperarSetPoint(int idUsuario) {
		
		Setpoint[] set=template.getForObject(url+"SetPointRecuperar/{idUsuario}",Setpoint[].class, idUsuario);
		
		return Arrays.asList(set);
	}

	@Override
	public void añadirSetPoint(Setpoint set) {
		
		template.postForLocation(url+"SetPointAgregar",set);
		
		
		
	}

	@Override
	public String deleteSetPoint(int idUsuario) {
		
		template.delete(url+"SetPointBorrar/{idUsuario}", idUsuario);
		
		return "configuracion.html";
		
	}

	@Override
	public String actualizarSetPoint(Setpoint set) {

		template.put(url+"SetPointActualizar",set);
		
		return "configuracion.html";
		
	}

	

}
