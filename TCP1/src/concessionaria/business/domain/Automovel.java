package concessionaria.business.domain;

public abstract class Automovel {
	private String nome;
	private String placa;
	private int ano;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void emplacar(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Automovel(String nome, int ano, String placa) {
		this.nome = nome;
		this.placa = placa;
		this.ano = ano;
	}
}
