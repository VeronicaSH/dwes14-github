package model;

public class Usuario {
	String login;
	String password;
	String nombre_usuario;
	Boolean admin;
	String descripcion;
	public Usuario(String login, String password, String nombre_usuario, Boolean admin, String descripcion) {
		super();
		this.login = login;
		this.password = password;
		this.nombre_usuario = nombre_usuario;
		this.admin = admin;
		this.descripcion = descripcion;
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
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isAdministrador() {
		return admin;
	}
	

	
	
	
}
