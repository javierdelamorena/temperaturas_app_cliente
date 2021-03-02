package dto;

public class DtoTemperatura {
	
	private double temp1;

	private int humedad;
	 
	private String fecha;
	
	private int idUsuario;

	public DtoTemperatura(double temp1, int humedad, String fecha) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		this.fecha = fecha;
	}



	public DtoTemperatura(double temp1, int humedad, String fecha, int idUsuario) {
		super();
		this.temp1 = temp1;
		this.humedad = humedad;
		this.fecha = fecha;
		this.idUsuario = idUsuario;
	}

	public DtoTemperatura() {
		super();
	}

	public double getTemp1() {
		return temp1;
	}

	public void setTemp1(double temp1) {
		this.temp1 = temp1;
	}

	public int getHumedad() {
		return humedad;
	}

	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	

}
