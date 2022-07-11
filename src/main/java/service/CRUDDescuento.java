package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.ConexionDB;
import models.Descuento;
import models.ManejoFecha;

public class CRUDDescuento {
	private ConexionDB conexion;
	private String sql;
	public CRUDDescuento() {
		this.conexion=new ConexionDB("cinemar");
		this.conexion.conectar();
	}
	public Descuento getPorcentajeDes() {
		ManejoFecha dia=new ManejoFecha();		
		this.sql="SELECT porcentaje FROM descuento where id=" + dia.getIndiceDia();
		try {
			ResultSet resultado=this.conexion.getSentenciaSQL().executeQuery(sql);
			resultado.next();
			return new Descuento(resultado.getDouble("porcentaje"));
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean actualizarDescuento(Descuento d) {
		System.out.println(d.getDescuento()+" " + d.getId());
		this.sql="UPDATE descuento SET porcentaje=" +d.getDescuento()+ " WHERE id=" + d.getId();
		
		try {		
			int resultado= this.conexion.getSentenciaSQL().executeUpdate(sql);
			return resultado>0;
		}
	catch(SQLException e) {
		e.printStackTrace();
	}
		return false;
	}
}
