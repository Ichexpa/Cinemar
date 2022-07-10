package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.Butaca;
import models.ConexionDB;

public class CRUDButaca {
	private ConexionDB conexion;
	private String sql;

	public CRUDButaca() {
		this.conexion = new ConexionDB("cinemar");
		this.conexion.conectar();
	}

	public boolean cambiarEstadoButaca(Butaca b) {
		System.out.println("Entrando a actualizar estado butaca");
		System.out.println(b.getReservado() + " " + b.getId());
		this.sql = "UPDATE butaca SET reservada=" + !b.getReservado() + " WHERE id=" + b.getId();
		try {
			System.out.println("Intentando ejecutar sentencia para actualizar butaca");
			this.conexion.getSentenciaSQL().executeUpdate(this.sql);
			System.out.println("Sentencia ejecturada con exito");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error al actualizar butaca");
		return false;
	}

	public boolean butacaDisponible(Butaca b) {
		System.out.println("Entrando a butaca");
		this.sql = "SELECT reservada FROM butaca where id=" + b.getId();
		try {
			System.out.println("Buscando resultados");
			ResultSet res = this.conexion.getSentenciaSQL().executeQuery(sql);
			System.out.println("Ejecuto sentencia con exito");
			res.next();
			System.out.println(res.getBoolean("reservada") );
			if (res.getBoolean("reservada") == false) {
				b.setReservado(false);
				return true;
			}
			System.out.println("la butaca ya se encuentra reservada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error");
		return false;
	}
}
