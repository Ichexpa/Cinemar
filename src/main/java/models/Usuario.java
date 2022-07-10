package models;

import java.sql.Date;
public class Usuario {
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private Date fecha_nac;
	private String documento;
	private String contraseña;
	private String nombreUsuario;
	private String numeroContacto;
	private boolean tieneDescuento;
	public Usuario(Integer id) {
		this.id=id;
	}
	public Usuario(String nombre,String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}
	public Usuario(String nombre, String apellido,String email,String dni,String contraseña,String
			nombreUsuario) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
		this.documento=dni;
		this.contraseña=contraseña;
		this.nombreUsuario=nombreUsuario;
	}
	public Usuario(String nombre, String apellido,String email,String dni,String contraseña,String
			nombreUsuario,String numeroContacto) {
		this(nombre,apellido,email,dni,contraseña,nombreUsuario);
		this.numeroContacto=numeroContacto;
		
	}
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public boolean isTieneDescuento() {
		return tieneDescuento;
	}
	public void setTieneDescuento(boolean tieneDescuento) {
		this.tieneDescuento = tieneDescuento;
	}
	public String getNumeroContacto() {
		return numeroContacto;
	}
	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(Date fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

}
