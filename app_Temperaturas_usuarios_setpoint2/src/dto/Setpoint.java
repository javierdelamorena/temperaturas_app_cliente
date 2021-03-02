package dto;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the setpoint database table.
 * 
 */


public class Setpoint  {
	

	@Id
	private int idUsuario;

	private int humedades;

	private int temp;
	
	
	

	public Setpoint(int idUsuario, int humedades, int temp) {
		super();
		this.idUsuario = idUsuario;
		this.humedades = humedades;
		this.temp = temp;
	}

	public Setpoint() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getHumedades() {
		return this.humedades;
	}

	public void setHumedades(int humedades) {
		this.humedades = humedades;
	}

	public int getTemp() {
		return this.temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

}