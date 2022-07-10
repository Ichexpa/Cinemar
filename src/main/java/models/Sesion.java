package models;

import java.sql.Timestamp;

public class Sesion {
	private Integer id;
	private Pelicula pelicula;
	private Timestamp fecha;
	private Sala sala;
	public Sesion(Pelicula p) {
			this.pelicula=p;
	}
	public Sesion(Pelicula pelicula,Sala s,Timestamp fecha) {
		super();
		this.sala = s;
		this.pelicula = pelicula;
		this.fecha = fecha;	
	}
	public Sesion(Integer id, Pelicula pelicula, Timestamp fecha) {
		super();
		this.id = id;
		this.pelicula = pelicula;
		this.fecha = fecha;	
	}
	public Sesion(Integer id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}