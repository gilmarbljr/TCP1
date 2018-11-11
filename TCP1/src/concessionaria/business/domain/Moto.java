package concessionaria.business.domain;

import concessionaria.business.ValoresException;

public class Moto extends Automovel{

	private int rodas;
	
	public Moto(String nome, int ano, int rodas, double valor, String placa) throws ValoresException {
		super(nome, ano, placa,valor);
		this.setRodas(rodas);
	}

	public int getRodas() {
		return rodas;
	}

	public void setRodas(int rodas) throws ValoresException {
		if (!hasEnoughWheels(rodas)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.rodas = rodas;
	}
	
	@Override
	public String toString() {
		return "Placa: "+getPlaca()+"\nNome: "+getNome()+"\nAno: "+getAno()+"\nRodas: "+getRodas()+"\nValor: "+getValor()+"\n";
	}
	
	private boolean hasEnoughWheels(int rodas) {
		return rodas >= 2;
	}
}
