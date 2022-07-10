package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Clasificacion;
import models.ConexionDB;
import models.Pelicula;
import models.TipoPelicula;

public class CRUDPelicula {
	private ConexionDB conexion;
	private String sql;
	public CRUDPelicula() {
		this.conexion=new ConexionDB("cinemar");
		this.conexion.conectar();
	}
	public boolean crear(Pelicula pelicula) {
		this.sql="INSERT INTO pelicula(nombre,duracion,id_tipoPelicula,id_clasificacion,sinopsis) VALUE('"+pelicula.getNombre()+"','"+
				pelicula.getDuracion() + "','" + pelicula.getTipo().getId()+ "','" + pelicula.getClasificacion().getId() + "','" + pelicula.getSinopsis() + "')";
		try {
				this.conexion.getSentenciaSQL().executeUpdate(sql);
				return true;
		}
		catch(SQLException e) {
				e.printStackTrace();
		}
		return false;
	}
	private ArrayList<Pelicula> resultadoConsultaVer(){
		try {
			ArrayList<Pelicula> resQuery= new ArrayList<Pelicula>();
			ResultSet res=this.conexion.getSentenciaSQL().executeQuery(sql);
			while(res.next()) {
				resQuery.add(new Pelicula(res.getString("nombre"),res.getInt("duracion"),res.getString("sinopsis"),
									new Clasificacion(res.getString("identificador"),res.getString("recomendacion")),
									new TipoPelicula(res.getString("idioma"),res.getBoolean("subtitulada"))));
			}
			return resQuery;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String consultaGralSelect() {
		return "SELECT p.nombre,p.duracion,p.sinopsis,tp.idioma,tp.subtitulada,c.identificador,c.recomendacion " +  
				"FROM pelicula as p inner join tipo_pelicula as tp on p.id_tipoPelicula=tp.id inner join clasificacion as c " + 
				"on p.id_clasificacion=c.id";
	}
	public ArrayList<Pelicula> verPeliculas(Pelicula pelicula){
		this.sql=consultaGralSelect()+  " WHERE p.id_pelicula=" + pelicula.getId();
		return resultadoConsultaVer();
	}
	public ArrayList<Pelicula> verPeliculas(){
		this.sql=consultaGralSelect();
		return resultadoConsultaVer();
	}

}
