package models;
import java.util.ArrayList;

public class Pelicula {
	private Integer id;
	private String nombre;
	private ArrayList<String> reparto;
	private Integer duracion;
	private String director;
	private String genero;
	private String sinopsis;
	private Clasificacion clasificacion;
	private TipoPelicula tipo;
	public Pelicula(Integer id) {
		this.id=id;
	}
	public Pelicula(String nombre,Integer duracion,String sinopsis,Clasificacion clasificacion,TipoPelicula tp) {
		this.nombre=nombre;
		this.duracion=duracion;
		this.clasificacion=clasificacion;
		this.tipo=tp;
		this.sinopsis=sinopsis;
	}
	public Pelicula(String nombre,Integer duracion,Clasificacion clasificacion,TipoPelicula tp) {
		this.nombre=nombre;
		this.duracion=duracion;
		this.clasificacion=clasificacion;
		this.tipo=tp;
	}
	public Pelicula(String nombre) {
		this.nombre=nombre;
	}
	public Pelicula(String nombre,Integer duracion) {
		this.nombre=nombre;
		this.duracion=duracion;
	}
	public Pelicula(String nombre, ArrayList<String> reparto, Integer duracion, String director, String genero,
			String sinopsis, Clasificacion clasificacion, TipoPelicula tipo) {
		super();
		this.nombre = nombre;
		this.reparto = reparto;
		this.duracion = duracion;
		this.director = director;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.clasificacion = clasificacion;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getReparto() {
		return reparto;
	}

	public void setReparto(ArrayList<String> reparto) {
		this.reparto = reparto;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public TipoPelicula getTipo() {
		return tipo;
	}

	public void setTipo(TipoPelicula tipo) {
		this.tipo = tipo;
	}
}