package service;

import java.util.List;

import dto.Setpoint;

public interface SetPoint_Service {
	
	
    List<Setpoint> recuperarSetPoint(int idUsuario);
	
	
	void a�adirSetPoint(Setpoint set);
	
	String deleteSetPoint(int idUsuario);
	
	String actualizarSetPoint(Setpoint set);

}
