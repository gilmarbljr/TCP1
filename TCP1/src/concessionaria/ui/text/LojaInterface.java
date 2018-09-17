package concessionaria.ui.text;

import concessionaria.business.Operacoes;
import concessionaria.business.OperacoesGerenciamento;
import concessionaria.business.domain.Loja;
import concessionaria.ui.text.command.AdicionaClientesCommand;
import concessionaria.ui.text.command.AtualizaDadosCommand;
import concessionaria.ui.text.command.FabricarAutomovelCommand;
import concessionaria.ui.text.command.SaldoConcessionariaCommand;

public class LojaInterface extends ConcessionariaTextInterface{
	
	public LojaInterface(Loja loja, Operacoes impl, OperacoesGerenciamento gerenciamento) {
		super(loja);
		this.adicionaAcao("1", new SaldoConcessionariaCommand(this, impl));
		this.adicionaAcao("2", new FabricarAutomovelCommand(this, impl));
		this.adicionaAcao("3", new AdicionaClientesCommand(this, gerenciamento));
		this.adicionaAcao("4", new AtualizaDadosCommand(this, gerenciamento));
	}
}
