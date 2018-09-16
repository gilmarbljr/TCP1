package concessionaria.business;

import concessionaria.business.domain.Loja;

public interface Operacoes {
	
	public double getSaldo(String clienteCadastro) throws ValoresException;
	public String getCliente(Loja loja);
	public void criarAutomoveis();
	public void showCarros();
	public void showMotos();
}
