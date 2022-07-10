package service;

import java.sql.SQLException;

import models.ConexionDB;
import models.Prueba;

public class CRUDPrueba {
	private ConexionDB conexion;
	private String sql;
	public CRUDPrueba() {
		this.conexion=new ConexionDB("cinemar");
		conexion.conectar();
	}
	public boolean ingresar(Prueba p) {
		boolean a=false;
		//this.sql="Insert into prueba(nombre) value('" + p.getNombre() +"')";
		this.sql="Insert into prueba(nombre,fecha,hora) value(' " + p.getNombre() + " ' , ' " + p.getFecha()+ " ','" + p.getHora() + "')";
		System.out.println(p.getFecha());
		System.out.println(p.getHora());
		try {
			this.conexion.getSentenciaSQL().executeUpdate(sql);
			a=true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
