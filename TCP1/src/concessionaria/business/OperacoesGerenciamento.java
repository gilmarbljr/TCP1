package concessionaria.business;

import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Moto;

public interface OperacoesGerenciamento {
	public Cliente adicionaCliente();
	public Cliente atualizaCliente();
	public Carro atualizaCarro();
	public Moto atualizaMoto();
	public Loja atualizaLoja();
	public Cliente atualizaSaldoLoja();
}
