package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.ConexionDB;
import models.Pelicula;
import models.Sala;
import models.Sesion;

public class CRUDSesion {
		private ConexionDB conexion;
		private String sql;
		public CRUDSesion() {
			this.conexion=new ConexionDB("cinemar");
			this.conexion.conectar();
		}
		public  boolean crearSesion(Sesion s) {
				sql="insert into sesion(id_sala,id_pelicula,fechaYhora) value("+ s.getSala().getId() + "," +s.getPelicula().getId()+ ",'" +s.getFecha() + "')";
				try {
						this.conexion.getSentenciaSQL().executeUpdate(sql);	
						return true;
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
		public boolean modificarSesion(Sesion s) {
			sql="UPDATE sesion SET  id_sala=" + s.getSala().getId() +",id_pelicula="+s.getPelicula().getId() + ",fechaYhora= '" + s.getFecha() +"' WHERE id=" +s.getId();
			try {
				int res=this.conexion.getSentenciaSQL().executeUpdate(sql);
				return res>0;
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return false;
		}
		public boolean comenzoLaFuncion(Sesion s) {
			this.sql="SELECT fechaYhora FROM sesion where fechaYhora>NOW() and id="+ s.getId() ;
			try {
				ResultSet res= this.conexion.getSentenciaSQL().executeQuery(sql);
				return res.next();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
		//Se muestran todas las sesiones que todavia no iniciaron
		public ArrayList<Sesion> verSesiones(){
			this.sql="SELECT p.nombre,p.duracion,s.fechaYhora,sla.numero as nroSala FROM"+
					 " sesion as s inner join pelicula as p on s.id_pelicula=p.id_pelicula"+ 
					" inner join sala as sla on s.id_sala=sla.id WHERE s.fechaYhora>NOW()";
			try {
				ArrayList<Sesion> resQuery=new ArrayList<Sesion>();
				ResultSet res=this.conexion.getSentenciaSQL().executeQuery(sql);

				while(res.next()) {
					resQuery.add(new Sesion(new Pelicula(res.getString("nombre"),res.getInt("duracion")),
															new Sala(res.getInt("nroSala")),res.getTimestamp("fechaYhora")));
				}
				return resQuery;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	
			return null;
		}
}
