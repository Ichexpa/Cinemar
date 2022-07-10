package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import models.ConexionDB;
import models.ManejoFecha;
import models.Usuario;

public class CRUDUsuario {
	private ConexionDB conexion;
	private String sql;
	public CRUDUsuario() {
		this.conexion=new ConexionDB("cinemar");
		conexion.conectar();
	}
	
	public boolean registrarUsuario(Usuario usuario) {
		boolean resultado=false;
		this.sql= "INSERT INTO usuario(documento,fecha_nac,nombre,"
				+ "apellido,correo,numeroContacto,nombreDeUsuario,contraseña) VALUE ('"+ 
				usuario.getDocumento()+"','" + usuario.getFecha_nac() + "','" + usuario.getNombre() 
				+ "','" + usuario.getApellido() +  "','" + usuario.getEmail() + "','" + usuario.getNumeroContacto() 
				+ "','" + usuario.getNombreUsuario() + "','" + usuario.getContraseña() +"')";
		try {
			System.out.println("Intentando ejecutar");
			this.conexion.getSentenciaSQL().executeUpdate(sql);
			System.out.println("Usuario Registrado");
			resultado=true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			resultado=false;
		}
		return resultado;
		
	}
	public ArrayList<Usuario> consultarUsuario(){
		this.sql="SELECT * FROM usuario";
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		ResultSet resultado;
		try {
			resultado= this.conexion.getSentenciaSQL().executeQuery(sql);
			while(resultado.next()) {
				usuarios.add(new Usuario(resultado.getString("nombre"),
										resultado.getString("apellido"),
										resultado.getString("email"),
										resultado.getString("documento"),
										resultado.getString("constraseña"),
										resultado.getString("nombreUsuario"),
										resultado.getString("numeroContacto")));
			}
			return usuarios;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean iniciarSesion(Usuario user) {
		sql="SELECT * FROM usuario WHERE (nombreDeUsuario="+" '"+ user.getNombreUsuario()+"' OR "
				+ "correo = '" +user.getEmail() + "')AND contraseña='"+user.getContraseña()+"'";
		try {
				ResultSet resultado=this.conexion.getSentenciaSQL().executeQuery(sql);
				if(resultado.next()) {
					System.out.println("Se ingreso correctamente");
					return true;
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private boolean actualizarDescuentos(Usuario user) {
		this.sql="UPDATE usuario SET tieneDescuento=1 WHERE	id="+ user.getId();
		try {
			int res=this.conexion.getSentenciaSQL().executeUpdate(sql);
			return res>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean solicitarTarjetaDescuento(Usuario user) {
		ManejoFecha fecha=new ManejoFecha();
		Timestamp intervaloInf= fecha.descontarMeses(3);
		this.sql="SELECT	count(*) as totalReservas from reserva "+
						"where id_usuario="+user.getId() +" AND (fecha_compra BETWEEN '"+  intervaloInf  +"' AND NOW() )";
		try {
				ResultSet res= this.conexion.getSentenciaSQL().executeQuery(sql);
				res.next();
				if(res.getInt("totalReservas")>=3) {
					return actualizarDescuentos(user);
				}
				System.out.println("No cumple con los requisitos para solicitar la tarjeta de Descuento tiene: " + res.getInt("totalReservas") +
						"reservas en 3 meses");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean tieneDescuento(Usuario user) {
		this.sql="SELECT tieneDescuento FROM usuario where id=" + user.getId();
		try {		
				ResultSet res=this.conexion.getSentenciaSQL().executeQuery(sql);
				res.next();
				return res.getBoolean("tieneDescuento");		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
