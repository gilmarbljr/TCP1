package concessionaria.business.domain;

import concessionaria.business.ValoresException;

public abstract class Automovel {
	protected String nome;
	protected String placa;
	protected int ano;
	protected double valor;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws ValoresException{
		if(!isValidString(nome)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.nome = nome;
	}
	public String getPlaca() {
		return placa;
	}
	public void emplacar(String placa) throws ValoresException {
		if(!isValidString(placa)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) throws ValoresException {
		if(!isValidValue(ano)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.ano = ano;
	}
	
	public Automovel(String nome, int ano, String placa, double valor) throws ValoresException {
		try {
			setNome(nome);
			emplacar(placa);
			setAno(ano);
			setValor(valor);
		}
		catch (ValoresException e) {
			throw e;
		}
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) throws ValoresException {
		if(!isValidValue(valor)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.valor = valor;
	}
	
	private boolean isValidValue(double valor) {
		return valor >= 0.0;
	}
	private boolean isValidValue(int ano) {
		return ano >= 0.0;
	}
	
	private boolean isValidString(String string) {
		return !string.isEmpty();
	}
}
