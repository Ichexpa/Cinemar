package app;

import static spark.Spark.*;
import com.google.gson.*;
import models.*;
import service.*;

public class App {

	public static void main(String[] args) {
		Gson mapper = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		port(1111);
		// USUARIOS
		post("/registrar", (request, response) -> {
			response.type("application/json");
			Gson mapperUs = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			Usuario user = mapperUs.fromJson(request.body(), Usuario.class);
			if (user.getContraseña().length() > 8) {
				CRUDUsuario cUser = new CRUDUsuario();
				if (cUser.registrarUsuario(user)) {
					return mapperUs.toJson("Registrado con exito");
				}
				return mapperUs.toJson("Error al registrarse");
			} else {
				return mapper.toJson("La contraseña debe ser mayor a 8 caracteres");
			}
		});
		post("/login", (request, response) -> {
			response.type("application/json");
			Usuario user = mapper.fromJson(request.body(), Usuario.class);
			if (new CRUDUsuario().iniciarSesion(user)) {
				return mapper.toJson("Se ingreso correctamente");
			}
			return mapper.toJson("Error al ingresar");
		});
		post("/reservar/new", (request, response) -> {
			response.type("application,json");
			Reserva r = mapper.fromJson(request.body(), Reserva.class);
			if (new CRUDReserva().reservar(r)) {
				return mapper.toJson("Se reservó con exito");
			}
			return mapper.toJson("Hubo un error en la reserva");
		});
		get("/misReservas/:idUsuario", (request, response) -> {
			Usuario user = new Usuario(Integer.valueOf(request.params(":idUsuario")));
			CRUDReserva r = new CRUDReserva();
			return mapper.toJson(r.observarReservasParciales(user));
		});
		get("/misEntradas/:idUsuario", (request, response) -> {
			Usuario user = new Usuario(Integer.valueOf(request.params(":idUsuario")));
			CRUDReserva r = new CRUDReserva();
			return mapper.toJson(r.mostrarReservas(user));
		});
		put("/solicitarTarjetaDescuento/:idUsuario", (request, response) -> {
			Usuario user = new Usuario(Integer.valueOf(request.params(":idUsuario")));
			CRUDUsuario cu = new CRUDUsuario();
			if (cu.solicitarTarjetaDescuento(user)) {
				return mapper.toJson("Se registro correctamente la tarjeta de descuento en su cuenta");
			}
			return mapper.toJson("No se cumplio con los requisitos para obtener la tarjeta");
		});
		put("/actualizarReserva/:idReserva", (request, response) -> {
			Reserva reserva = mapper.fromJson(request.body(), Reserva.class);
			reserva.setId(Integer.valueOf(request.params(":idReserva")));
			CRUDReserva res = new CRUDReserva();
			if (res.actualizarReserva(reserva)) {
				return mapper.toJson("Se actualizo con exito");
			}
			return mapper.toJson("Error al actualizar reserva");
		});
		get("/mostrarSesiones", (request, response) -> {
			CRUDSesion s = new CRUDSesion();
			return mapper.toJson(s.verSesiones());
		});
		// ADMINISTRADORES
		post("/crearPelicula", (request, response) -> {
			response.type("application,json");
			Pelicula p = mapper.fromJson(request.body(), Pelicula.class);
			if (new CRUDPelicula().crear(p)) {
				return mapper.toJson("Pelicula creada con exito");
			} else {
				return mapper.toJson("Error al crear la pelicula");
			}
		});
		post("/crearSesion/new", (request, response) -> {
			response.type("application,json");
			Sesion s = mapper.fromJson(request.body(), Sesion.class);
			if (new CRUDSesion().crearSesion(s)) {
				return mapper.toJson("Se creó correctamente la sesion");
			}
			return mapper.toJson("Hubo un error en la creacion");
		});
		put("/modificarDescuento/:idDescuento", (request, response) -> {
			response.type("application/json");
			Descuento d = mapper.fromJson(request.body(), Descuento.class);
			d.setId(Integer.valueOf(request.params(":idDescuento")));
			CRUDDescuento ca = new CRUDDescuento();
			if (ca.actualizarDescuento(d)) {
				return mapper.toJson("Descuento actualizado con Exito");
			} else {
				return mapper.toJson("Error al actualizar descuento");
			}
		});
		delete("/room/delete/:idSala", (request, response) -> {
			Sala s = mapper.fromJson(request.body(), Sala.class);
			s.setId(Integer.valueOf(request.params(":idSala")));
			if (new CRUDSala().eliminarSala(s)) {
				return mapper.toJson("Eliminado con exito");
			}
			return mapper.toJson("Error al eliminar ");
		});
		put("/room/modify/:idSesion", (request, response) -> {
			Sesion s = mapper.fromJson(request.body(), Sesion.class);
			s.setId(Integer.valueOf(request.params(":idSesion")));
			if (new CRUDSesion().modificarSesion(s)) {
				return mapper.toJson("Sesion modificada con exito");
			}
			return mapper.toJson("Error al modificar sesion");
		});
		get("/todasLasReservas", (request, response) -> {
			CRUDReserva reserva = new CRUDReserva();
			return mapper.toJson(reserva.mostrarReservas());
		});
		get("/verPeliculas", (request, response) -> {
			CRUDPelicula s = new CRUDPelicula();
			return mapper.toJson(s.verPeliculas());
		});
		get("/verPeliculas/:idPelicula", (request, response) -> {
			CRUDPelicula s = new CRUDPelicula();
			return mapper.toJson(s.verPeliculas(new Pelicula(Integer.valueOf(request.params(":idPelicula")))));
		});
	}

}
