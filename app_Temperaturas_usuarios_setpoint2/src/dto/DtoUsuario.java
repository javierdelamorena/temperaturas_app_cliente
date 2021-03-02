package dto;

public class DtoUsuario {
	
	private int idUsuario;

	private String email;

	private String nombre;

	private String password;
	
	public DtoUsuario(int idUsuario,String nombre,String password, String email) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
	}
	public DtoUsuario() {
		super();
	}



	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
