package concessionaria.business.domain;

import concessionaria.business.ValoresException;

public class Carro extends Automovel{
	private int portas;
	
	public Carro(String nome, int ano, int portas, double valor, String placa) throws ValoresException{
		super(nome, ano, placa, valor);
		this.setPortas(portas);
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) throws ValoresException{
		if(!isValidNumPorts(portas)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.portas = portas;
	}
	
	private boolean isValidNumPorts(int portas) {
		return portas >= 2;
	}
	
	@Override
	public String toString() {
		return "Placa: "+getPlaca()+"\nNome: "+getNome()+"\nAno: "+getAno()+"\nPortas: "+getPortas()+"\nValor: "+getValor()+ "\n";
	}
}
