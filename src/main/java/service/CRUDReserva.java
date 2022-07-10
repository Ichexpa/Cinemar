package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.*;

public class CRUDReserva {
	private ConexionDB conexion;
	private String sql;

	public CRUDReserva() {
		this.conexion = new ConexionDB("cinemar");
		this.conexion.conectar();
	}

	private double aplicarDescuento(Reserva reserva) {
		CRUDDescuento d = new CRUDDescuento();
		Descuento descuento = d.getPorcentajeDes();
		return reserva.getPrecio() - (reserva.getPrecio() * descuento.getDescuento() / 100);
	}

	public boolean reservar(Reserva reserva) {
		CRUDButaca cb = new CRUDButaca();
		CRUDUsuario us = new CRUDUsuario();
		Integer idDescuento = 8;
		if (cb.butacaDisponible(reserva.getButaca())) {
			Double totalAPagar;
			if (us.tieneDescuento(reserva.getUsuario())) {
				totalAPagar = aplicarDescuento(reserva);
				idDescuento = new ManejoFecha().getIndiceDia();
			} else {
				totalAPagar = reserva.getPrecio();
			}
			sql = "INSERT INTO reserva(precio,fecha_compra,id_sesion,id_usuario,id_butaca,id_descuento,nro_tarjetaCredito,total) VALUES("
					+ reserva.getPrecio() + ",CURRENT_TIMESTAMP()," + reserva.getSesion().getId() + ","
					+ reserva.getUsuario().getId() + "," + reserva.getButaca().getId() + "," + idDescuento + ","
					+ reserva.getPago().getNumero() + "," + totalAPagar + ")";
			try {
				this.conexion.getSentenciaSQL().executeUpdate(sql);
				cb.cambiarEstadoButaca(reserva.getButaca());
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Error en reserva");
		return false;
	}

	private ArrayList<Reserva> resultadoMostrarReservas() {
		try {
			ArrayList<Reserva> resultado = new ArrayList<Reserva>();
			ResultSet rs = this.conexion.getSentenciaSQL().executeQuery(sql);
			while (rs.next()) {
				Reserva res = new Reserva(new Usuario(rs.getString("nombre"), rs.getString("apellido")),
						new Sesion(new Pelicula(rs.getString("nombrePelicula"))), rs.getTimestamp("fecha_compra"),
						new TarjetaCredito(rs.getString("nro_tarjetaCredito")), rs.getDouble("precio"),
						rs.getDouble("total"));
				resultado.add(res);
			}
			return resultado;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Error al mostrar reserva");
		return null;
	}

	private String consultaGeneral() {
		return "SELECT u.nombre,u.apellido,p.nombre as nombrePelicula,r.precio,r.fecha_compra,r.nro_tarjetaCredito,r.total FROM"
				+ " reserva as r inner join usuario as u on r.id_usuario=u.id"
				+ " inner join sesion as s on s.id=r.id_sesion inner join pelicula p"
				+ " on s.id_pelicula=p.id_pelicula";
	}

	// Observar mis reservas.
	public ArrayList<Reserva> observarReservasParciales(Usuario usuario) {
		this.sql = consultaGeneral() + "  WHERE s.fechaYhora>NOW() AND id_usuario=" + usuario.getId();
		return resultadoMostrarReservas();
	}

	// Ver el histórico de mis entradas.
	public ArrayList<Reserva> mostrarReservas(Usuario usuario) {
		this.sql = consultaGeneral() + " WHERE id_usuario=" + usuario.getId();
		return resultadoMostrarReservas();
	}

	// Ver reservas de todos los clientes.
	public ArrayList<Reserva> mostrarReservas() {
		sql = consultaGeneral();
		return resultadoMostrarReservas();
	}

	private Sesion getIdSesionDeRes(Reserva res) {
		this.sql = "SELECT id_sesion FROM reserva WHERE id=" + res.getId();
		try {
			ResultSet rs = this.conexion.getSentenciaSQL().executeQuery(sql);
			rs.next();
			return new Sesion(rs.getInt("id_sesion"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean actualizarReserva(Reserva reserva) {
		CRUDSesion sesion = new CRUDSesion();
		if (sesion.comenzoLaFuncion(reserva.getSesion()) && sesion.comenzoLaFuncion(getIdSesionDeRes(reserva))) {
			// Le asigno la misma fecha ya que si no lo hago se actualiza sola
			this.sql = "UPDATE reserva SET fecha_compra=fecha_compra, id_sesion=" + reserva.getSesion().getId()
					+ ",id_butaca=" + reserva.getButaca().getId() + " WHERE id=" + reserva.getId();
			try {
				int res = this.conexion.getSentenciaSQL().executeUpdate(sql);
				return res > 0;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
