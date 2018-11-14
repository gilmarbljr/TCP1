package concessionaria.business;

import java.util.ArrayList;

import concessionaria.business.domain.Automovel;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Venda;

public interface Operacoes {
	
	public double getSaldo(String clienteCadastro) throws ValoresException;
	public String getCliente(Loja loja);
	public ArrayList<Automovel> criarAutomoveis();
	public void aplicarDescontoCarros(int desconto);
	public void aplicarDescontoMotos(int desconto);
	public void aplicarDescontoAno(int desconto, int ano);
	public void aplicarDescontoPlaca(int desconto, String placa);
	public Venda efetuarVenda(Loja loja);
	public String funcionarioDoMes();
}
