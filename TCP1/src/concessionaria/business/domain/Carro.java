package concessionaria.business.domain;

public class Carro extends Automovel{
	private int portas;
	
	public Carro(String nome, int ano, int portas, double valor, String placa) {
		super(nome, ano, placa, valor);
		this.setPortas(portas);
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}
	
	@Override
	public String toString() {
		return "Placa: "+getPlaca()+"\nNome: "+getNome()+"\nAno: "+getAno()+"\nPortas: "+getPortas()+"\nValor: "+getValor();
	}
}
