package model;

public class Autor {
	public String idAutor;
	public String nombre_autor;
	
	public Autor( String idAutor, String nombre_autor) {
		super();
		this.idAutor=idAutor;
		this.nombre_autor=nombre_autor;
	}
	public String getid() {
		return idAutor;
	}
	public String getNombre() {
		return nombre_autor;
	}
}
