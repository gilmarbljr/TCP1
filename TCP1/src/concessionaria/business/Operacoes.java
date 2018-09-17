package concessionaria.business;

import java.util.ArrayList;

import concessionaria.business.domain.Automovel;
import concessionaria.business.domain.Loja;

public interface Operacoes {
	
	public double getSaldo(String clienteCadastro) throws ValoresException;
	public String getCliente(Loja loja);
	public ArrayList<Automovel> criarAutomoveis();
}
