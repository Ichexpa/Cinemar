package models;

import java.sql.Date;

public class TarjetaDescuento {
	private String numero;
	private Date fechaCreacion;
	public TarjetaDescuento(String numero) {
		this.numero=numero;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
