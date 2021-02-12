package service;

import java.time.LocalDate;
import java.util.List;

import dto.DtoTemperatura;

public interface Temperatura_Service {
	
	List<DtoTemperatura> todas();
	DtoTemperatura una(int temp);
	void agregarTeperatuta(int temp,int humedad);
	double mediaTemperatura();
	DtoTemperatura TemperaturaMaxima();
	DtoTemperatura TemperaturaMinima();
	DtoTemperatura TemperaturaMaximaDia(LocalDate fecha);
	DtoTemperatura TemperaturaMinimaDia(LocalDate fecha);
	List<DtoTemperatura>temperaturaEntreFechas(LocalDate fechaIni,LocalDate FechaFin);
	
	

}
