package modelo;

public class Usuario {
	//ATRIBUTOS
	String login;
	String password;
	String nombre;
	String gasto;
	String direccion;
	
	//CONSTRUCTOR
	public Usuario(String login, String password, String nombre, String gasto, String direccion) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.gasto = gasto;
		this.direccion = direccion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGasto() {
		return gasto;
	}

	public void setGasto(String gasto) {
		this.gasto = gasto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
