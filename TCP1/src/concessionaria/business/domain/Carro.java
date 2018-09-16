package concessionaria.business.domain;

public class Carro extends Automovel{
	private int portas;
	
	public Carro(String nome, int ano, int portas) {
		super(nome, ano);
		this.setPortas(portas);
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
}
