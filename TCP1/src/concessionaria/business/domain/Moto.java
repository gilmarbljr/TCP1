package concessionaria.business.domain;

public class Moto extends Automovel{

	private int rodas;
	
	public Moto(String nome, int ano, int rodas, double valor, String placa) {
		super(nome, ano, placa,valor);
		this.rodas = rodas;
	}

	public int getRodas() {
		return rodas;
	}

	public void setRodas(int rodas) {
		this.rodas = rodas;
	}
	
	@Override
	public String toString() {
		return "Placa: "+getPlaca()+"\nNome: "+getNome()+"\nAno: "+getAno()+"\nRodas: "+getRodas()+"\nValor: "+getValor();
	}
}
