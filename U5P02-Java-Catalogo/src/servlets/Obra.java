package servlets;

public class Obra {
	public String idJuego;
    public String Nombre;
    public String genero;
    public String consola;
    public String autor;
    public String imagen;
    public String nombre_autor;
    
   
    public Obra(String string, String Nombre, String genero, String consola, String autor, String imagen, String nombre_autor) {
		super();
		this.idJuego = string;
		this.Nombre = Nombre;
		this.genero = genero;
		this.consola = consola;
		this.autor = autor;
		this.imagen = imagen;
		this.nombre_autor=nombre_autor;
	}
	public String getIdJuego(){
        return idJuego;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getGenero(){
        return genero;
    }
    public String getConsola(){
        return consola;
    }
    public String getAutor(){
        return autor;
    }
    public String getImagen(){
        return imagen;
    }
    public String getNombreAutor(){
        return nombre_autor;
    }
	@Override
	public String toString() {
		return "Obra [idJuego=" + idJuego + ", Nombre=" + Nombre + ", genero=" + genero + ", consola=" + consola
				+ ", autor=" + autor + ", imagen=" + imagen + ", nombre_autor=" + nombre_autor + "]";
	}
    
    
}
