package models;

import java.sql.*;

public class ConexionDB {
	private final String JDBC_URL="com.mysql.cj.jdbc.Driver";
	private String URL_BASE_DATOS="jdbc:mysql://localhost:3306/";
	private final String usuario="root";
	private final String contraseña="";
	private Connection conexion;
	private Statement sentenciaSQL;
	private ResultSet resultados;
	public ConexionDB(String nombreBaseDeDatos) {
		this.URL_BASE_DATOS+=nombreBaseDeDatos;
	}
	public void conectar() {
		try {
			Class.forName(JDBC_URL);
			this.conexion=DriverManager.getConnection(URL_BASE_DATOS,usuario,contraseña);
			this.sentenciaSQL=this.conexion.createStatement();
		}
		catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cerrarConexion(){
		try {
			this.conexion.close();
			this.sentenciaSQL.close();
			this.resultados.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Statement getSentenciaSQL() {
		return sentenciaSQL;
	}
	public void setSentenciaSQL(Statement sentenciaSQL) {
		this.sentenciaSQL = sentenciaSQL;
	}
	public ResultSet getResultados() {
		return resultados;
	}
	public void setResultados(ResultSet resultados) {
		this.resultados = resultados;
	}
	public String getUsuario() {
		return usuario;
	}
	
}
