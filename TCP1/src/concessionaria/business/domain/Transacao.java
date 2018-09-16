package concessionaria.business.domain;

import java.util.Date;

public abstract class Transacao {
	private Cliente cliente;
	private double montante;
	private Date data;
	private Loja loja;
	
	public Transacao(Cliente cliente, double montante, Loja loja) {
		this.cliente = cliente;
		this.montante = montante;
		this.data = new Date(System.currentTimeMillis());
		this.loja = loja;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public double getMontante() {
		return montante;
	}
	public Date getDate() {
		return data;
	}
	public Loja getLoja() {
		return loja;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
}
