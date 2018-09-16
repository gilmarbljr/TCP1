package concessionaria.business.domain;

public class Moto extends Automovel{

	private int rodas;
	
	public Moto(String nome, int ano, int rodas) {
		super(nome, ano);
		this.rodas = rodas;
	}

	public int getRodas() {
		return rodas;
	}

	public void setRodas(int rodas) {
		this.rodas = rodas;
	}
}
