package models;
public class TarjetaCredito {
	private String numero;
	private Usuario titular;
	private Double balance;
	private Double limite;
	private String banco;
	public TarjetaCredito(String numero) {
		this.numero=numero;
	}
	public TarjetaCredito(String numero, Usuario titular, Double balance, Double limite, String banco) {
		this.numero = numero;
		this.titular = titular;
		this.limite = limite;
		this.banco = banco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Usuario getTitular() {
		return titular;
	}
	public void setTitular(Usuario titular) {
		this.titular = titular;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public boolean sePuedePagar(double precio) {
		return this.balance>=precio;
	}
	
}
