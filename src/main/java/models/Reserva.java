package models;

import java.sql.Timestamp;

public class Reserva {
	private Integer id;
	private Butaca butaca;
	private Usuario usuario;
	private Double precio;
	private Timestamp fecha;
	private TarjetaCredito pago;
	private Descuento descuento;
	private Sesion sesion;
	private Double total;

	public Reserva(Usuario usuario, Sesion sesion, Timestamp fecha, TarjetaCredito pago, Double precio, Double total) {
		this.usuario = usuario;
		this.sesion = sesion;
		this.fecha = fecha;
		this.total = total;
		this.pago = pago;
		this.precio = precio;
	}

	public Reserva(Butaca butaca, Usuario usuario, Double precio, Timestamp fecha, TarjetaCredito pago,
			Descuento descuento, Sesion sesion, Double total, Integer id) {
		super();
		this.butaca = butaca;
		this.usuario = usuario;
		this.precio = precio;
		this.descuento = descuento;
		this.fecha = fecha;
		this.pago = pago;
		this.descuento = descuento;
		this.sesion = sesion;
		this.total = total;
		this.id = id;
	}

	public Reserva(Sesion s, Butaca b) {
		this.butaca = b;
		this.sesion = s;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public TarjetaCredito getPago() {
		return pago;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setPago(TarjetaCredito pago) {
		this.pago = pago;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Butaca getButaca() {
		return butaca;
	}

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public boolean validarReserva() {
		return pago.sePuedePagar(this.precio);
	}

}
