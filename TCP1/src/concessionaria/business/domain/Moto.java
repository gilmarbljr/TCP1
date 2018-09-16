package concessionaria.business.domain;

public class Moto extends Automovel{

	private int rodas;
	private double valor;
	
	public Moto(String nome, int ano, int rodas, double valor, String placa) {
		super(nome, ano, placa);
		this.rodas = rodas;
		this.valor = valor;
	}

	public int getRodas() {
		return rodas;
	}

	public void setRodas(int rodas) {
		this.rodas = rodas;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
