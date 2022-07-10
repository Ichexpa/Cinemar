package models;

public class Butaca {
	private Integer id;
	private String fila;
	private Integer numero;
	private Sala sala;
	private Boolean reservado;
	
	public Butaca(Integer id,String fila, Integer numero, Sala sala) {
		super();
		this.fila = fila;
		this.numero = numero;
		this.sala = sala;
		this.reservado=false;
		this.id=id;
	}
	public Butaca(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
	
}
