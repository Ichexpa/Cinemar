package service;

import java.sql.SQLException;

import models.ConexionDB;
import models.Sala;

public class CRUDSala {
	private ConexionDB conexion;
	private String sql;
	public CRUDSala() {
		this.conexion=new ConexionDB("cinemar");
		this.conexion.conectar();
	}
	public boolean eliminarSala(Sala s) {	
		this.sql="DELETE FROM sala WHERE id="+s.getId();
		try {
			int res=this.conexion.getSentenciaSQL().executeUpdate(sql);
			return res>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
