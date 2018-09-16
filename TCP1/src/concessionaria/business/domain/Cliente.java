package concessionaria.business.domain;

public class Cliente extends Pessoa {
	private int cadastro;

	public int getCadastro() {
		return cadastro;
	}

	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}
	
	public Cliente(String nome, int idade, int cadastro) {
		super(nome,idade);
		this.cadastro = cadastro;
	}
}
