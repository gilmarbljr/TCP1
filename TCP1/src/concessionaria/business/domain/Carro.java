package concessionaria.business.domain;

public class Carro extends Automovel{
	private int portas;
	private double valor;
	
	public Carro(String nome, int ano, int portas, double valor, String placa) {
		super(nome, ano, placa);
		this.setPortas(portas);
		this.valor = valor;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
