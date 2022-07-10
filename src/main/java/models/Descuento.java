package models;

public class Descuento {
	private Integer id;
	private String dia;
	private Double descuento;
	public Descuento(Integer id) {
		this.id=id;
	}
	public Descuento(Double descuento) {
		this.descuento=descuento;
	}
	public Descuento(String dia, Double descuento, Integer id) {
		super();
		this.dia = dia;
		this.descuento = descuento;
		this.id=id;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
