package concessionaria.business.domain;

public class Loja {
	private String nome;
	private int id;
	
	public Loja(int id, String nome) {
		this.nome = nome;
		this.id = id;
	}
	
	public String toString() {
		return getClass().getSimpleName() + " - " + getNome() + " " + getId();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}
}
