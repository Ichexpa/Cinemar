package models;

public class Clasificacion {
	private Integer id;
	private String recomendacion;
	private String identificador;
	private String descripcion;
	public Clasificacion(String identificador, String recomendacion) {
		this.identificador = identificador;
		this.recomendacion = recomendacion;
	}
	public Clasificacion(Integer id, String recomendacion, String identificador, String descripcion) {
		super();
		this.id = id;
		this.recomendacion = recomendacion;
		this.identificador = identificador;
		this.descripcion = descripcion;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRecomendacion() {
		return recomendacion;
	}


	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}


	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
