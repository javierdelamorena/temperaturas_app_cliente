package service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import dto.DtoTemperatura;

public interface Temperatura_Service {
	
	List<DtoTemperatura> todas(int idUsuario);
	DtoTemperatura una(int temp,int idUsuario);
	void agregarTemperatura(int temp,int humedad,int idUsuario);
	double mediaTemperatura(int idUsuario);
	DtoTemperatura TemperaturaMaxima(int idUsuario);
	DtoTemperatura TemperaturaMinima(int idUsuario);
	DtoTemperatura TemperaturaMaximaDia(String fecha,int idUsuario);
	DtoTemperatura TemperaturaMinimaDia(String fecha,int idUsuario);
	List<DtoTemperatura>temperaturaEntreFechas(String fechaIni,String FechaFin,int idUsuario);
	
	
	
		
	
	
	

}
