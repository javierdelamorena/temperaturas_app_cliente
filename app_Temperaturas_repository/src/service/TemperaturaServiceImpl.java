package service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.DtoTemperatura;


@Service
public class TemperaturaServiceImpl implements Temperatura_Service {
	
	String url="http://localhost:8000/";

	@Autowired
	RestTemplate template;

	@Override
	public List<DtoTemperatura> todas() {
		
		DtoTemperatura[] lista=template.getForObject(url+"Temperaturas", DtoTemperatura[].class);
		return Arrays.asList(lista);
	}

	@Override
	public DtoTemperatura una(int temp) {
		
		DtoTemperatura unaTemp=template.getForObject(url+"Temperatura", DtoTemperatura.class);

		return unaTemp;
	}

	@Override
	public void agregarTeperatuta(int temp,int humedad) {
		
		template.postForLocation(url+"TemperaturasAgregar/{temp}/{humedad}",temp ,humedad);

	}

	@Override
	public double mediaTemperatura() {
		DtoTemperatura[] lista=template.getForObject(url+"Temperaturas", DtoTemperatura[].class);
		
		return Arrays.asList(lista).stream().collect(Collectors.averagingDouble(s -> (double) s.getTemp1()));

	}

	@Override
	public DtoTemperatura TemperaturaMaximaDia(LocalDate fecha) {
		System.out.println("la fecha que viene"+fecha);
		DtoTemperatura lista=template.getForObject(url+"TemperaturaMinima", DtoTemperatura.class,fecha);
		
		return lista;			
	}
	@Override
	public List<DtoTemperatura> temperaturaEntreFechas(LocalDate fechaIni, LocalDate FechaFin) {

		DtoTemperatura[] lista=template.getForObject(url+"TemperaturaEntreFechas/{fecha1}/{fecha2}", DtoTemperatura[].class,fechaIni,FechaFin);
		
		return Arrays.asList(lista);
	}

	@Override
	public DtoTemperatura TemperaturaMaxima() {
		DtoTemperatura lista=template.getForObject(url+"TemperaturaMaxima", DtoTemperatura.class);
		return lista;
	}

	@Override
	public DtoTemperatura TemperaturaMinima() {
		DtoTemperatura lista=template.getForObject(url+"TemperaturaMinima", DtoTemperatura.class);
		return lista;
	}

	@Override
	public DtoTemperatura TemperaturaMinimaDia(LocalDate fecha) {
		DtoTemperatura lista=template.getForObject(url+"TemperaturaMinimaDia/{fecha}", DtoTemperatura.class,fecha);
		return lista;
	}

}
