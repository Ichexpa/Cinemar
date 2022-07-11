package models;

import java.util.Calendar;
import java.sql.*;

public class ManejoFecha {
	private Calendar fecha;

	public ManejoFecha() {
		this.fecha = Calendar.getInstance();

	}

	public Timestamp descontarMeses(int cantidad) {
		this.fecha.add(Calendar.MONTH, -cantidad);
		return new Timestamp(this.fecha.getTimeInMillis());
	}

	public int getIndiceDia() {
		return this.fecha.get(Calendar.DAY_OF_WEEK);
	}

	public Calendar getFecha() {
		return fecha;
	}
}
