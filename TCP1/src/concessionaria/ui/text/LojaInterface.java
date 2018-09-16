package concessionaria.ui.text;

import concessionaria.business.Operacoes;
import concessionaria.business.domain.Loja;
import concessionaria.ui.text.command.FabricarAutomovelCommand;
import concessionaria.ui.text.command.SaldoConcessionariaCommand;

public class LojaInterface extends ConcessionariaTextInterface{
	
	public LojaInterface(Loja loja, Operacoes impl) {
		super(loja);
		this.adicionaAcao("1", new SaldoConcessionariaCommand(this, impl));
		this.adicionaAcao("2", new FabricarAutomovelCommand(this, impl));
	}
}
