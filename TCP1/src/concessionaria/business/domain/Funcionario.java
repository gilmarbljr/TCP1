package concessionaria.business.domain;

public class Funcionario extends Pessoa{

	private int vendas;
	
	public Funcionario(String nome, int idade) {
		super(nome, idade);
		this.setVendas(0);
	}

	public int getVendas() {
		return vendas;
	}

	public void setVendas(int vendas) {
		this.vendas = vendas;
	}
	
	public void incrementaVendas() {
		this.vendas = this.vendas+1;
	}
	
	public void incrementaVendas(int vendas) {
		this.vendas = this.vendas + vendas;
	}

}
