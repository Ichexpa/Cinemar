package models;

import java.sql.*;

public class Prueba {
		private Integer id;
		private String nombre;
		private Timestamp hora;
		private Date fecha;
	
		
		public Prueba(Integer id,String nombre) {
			this.id=id;
			this.nombre=nombre;
		}
		public Prueba(Integer id,Timestamp hora,String nombre) {
				this(id,nombre);
				this.hora=hora;
		}
	
		public Prueba(Integer id, String nombre, Timestamp hora, Date fecha) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.hora = hora;
			this.fecha = fecha;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
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
		public Timestamp getHora() {
			return hora;
		}
		public void setHora(Timestamp hora) {
			this.hora = hora;
		}
		
}
