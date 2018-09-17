package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.business.domain.Loja;
import concessionaria.ui.ConcessionariaInterface;

public class SaldoConcessionariaCommand extends Comando{
	
	private final Operacoes operacoes;

	public SaldoConcessionariaCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		Loja loja = concessionariaInterface.getLoja();
		String clienteLoja = operacoes.getCliente(loja);
		Double saldo = operacoes.getSaldo(clienteLoja);
		System.out.println("Saldo: "+ saldo);
	}
	
	@Override
	public String toString() {
		return "Exibir Saldo da Loja";
	}

}
