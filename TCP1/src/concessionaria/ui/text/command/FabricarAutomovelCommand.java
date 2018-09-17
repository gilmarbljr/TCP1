package concessionaria.ui.text.command;

import java.util.ArrayList;

import concessionaria.business.Operacoes;
import concessionaria.business.domain.Automovel;
import concessionaria.ui.ConcessionariaInterface;

public class FabricarAutomovelCommand extends Comando{
	
	private final Operacoes operacoes;

	public FabricarAutomovelCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		ArrayList<Automovel> automoveis = operacoes.criarAutomoveis();
		System.out.println();
		for (Automovel auto : automoveis) {
			System.out.println(auto.toString());
			System.out.println();
		}
	}
}
