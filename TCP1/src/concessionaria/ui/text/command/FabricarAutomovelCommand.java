package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.ui.ConcessionariaInterface;

public class FabricarAutomovelCommand extends Comando{
	
	private final Operacoes operacoes;

	public FabricarAutomovelCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		operacoes.criarAutomoveis();
	}

}
