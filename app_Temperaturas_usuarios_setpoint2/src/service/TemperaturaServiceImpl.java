package service;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.DtoTemperatura;
import util.Utilidades;

@Service
public class TemperaturaServiceImpl implements Temperatura_Service {

	String url = "http://localhost:8000/";

	@Autowired
	RestTemplate template;

	@Override
	public List<DtoTemperatura> todas(int idUsuario) {

		System.out.println("este es el id usuario en todas" + idUsuario);

		DtoTemperatura[] lista = template.getForObject(url + "Temperatura/{idUsuario}", DtoTemperatura[].class,
				idUsuario);
		return Arrays.asList(lista);
	}

	@Override
	public DtoTemperatura una(int temp, int idUsuario) {

		DtoTemperatura unaTemp = template.getForObject(url + "Temperatura", DtoTemperatura.class);

		return unaTemp;
	}

	@Override
	public void agregarTemperatura(int temp1, int humedad, int idUsuario) {

		template.postForLocation(url + "TemperaturasAgregar/{temp1}/{humedad}/{idUsuario}",String.class,temp1,
				humedad, idUsuario);

	}

	@Override
	public double mediaTemperatura(int idUsuario) {
		Double media = template.getForObject(url + "TemperaturaMedia/{idUsuario}", Double.class, idUsuario);

		return media;

	}

	@Override
	public List<DtoTemperatura> temperaturaEntreFechas(String fechaIni, String FechaFin, int idUsuario) {

		System.out.println("fecha en el impl:  " + fechaIni + "  fecha en impl:  " + FechaFin);

		DtoTemperatura[] lista = template.getForObject(url + "TemperaturaEntreFechas/{fecha1}/{fecha2}/{idUsuario}",
				DtoTemperatura[].class, fechaIni, FechaFin, idUsuario);

		return Arrays.asList(lista);
	}

	@Override
	public DtoTemperatura TemperaturaMaxima(int idUsuario) {
		DtoTemperatura[] lista = template.getForObject(url + "TemperaturaMaxima/{idUsuario}", DtoTemperatura[].class,
				idUsuario);
		return Arrays.asList(lista).stream().filter(t->t.getIdUsuario()==idUsuario).max(Comparator.comparingDouble(t->t.getTemp1())).orElse(null);
	}

	@Override
	public DtoTemperatura TemperaturaMinima(int idUsuario) {
		DtoTemperatura[] lista = template.getForObject(url + "TemperaturaMinima/{idUsuario}", DtoTemperatura[].class,
				idUsuario);
		return Arrays.asList(lista).stream().filter(t->t.getIdUsuario()==idUsuario).min(Comparator.comparingDouble(t->t.getTemp1())).orElse(null);
	}

	@Override
	public DtoTemperatura TemperaturaMinimaDia(String fecha, int idUsuario) {

		System.out.println("esto es lo que viene en tempMax: "+Utilidades.cambioFormato4(fecha));

		Double lista = template.getForObject(url + "TemperaturaMinimaDia/{fecha}/{idUsuario}",
				Double.class, fecha, idUsuario);
		
		System.out.println(lista);
		
		
		DtoTemperatura dto=new DtoTemperatura(lista,0,fecha,idUsuario);
		
		return dto;
	}

	@Override
	public DtoTemperatura TemperaturaMaximaDia(String fecha, int idUsuario) {
		
		System.out.println("esto es lo que viene en tempMax: "+Utilidades.cambioFormato4(fecha));

		Double lista = template.getForObject(url + "TemperaturaMaximaDia/{fecha}/{idUsuario}",
				Double.class, fecha, idUsuario);
		
		System.out.println(lista);
		
		
		DtoTemperatura dto=new DtoTemperatura(lista,0,fecha,idUsuario);
		
		
		//System.out.println("fecha a comparar  "+dto.getFecha());

		return dto;
	}

	
		
	}


