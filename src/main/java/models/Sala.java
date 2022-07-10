package models;

public class Sala{
	private Integer id;
	private Integer numero;
	private Integer formatos;
	private	Integer capacidad;

	public Sala(Integer id, Integer numero, Integer formatos, Integer capacidad) {
		super();
		this.id = id;
		this.numero = numero;
		this.formatos = formatos;
		this.capacidad = capacidad;
	}
	public Sala(Integer numero) {
		this.numero=numero;
	}
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFormatos() {
		return formatos;
	}

	public void setFormatos(Integer formatos) {
		this.formatos = formatos;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}