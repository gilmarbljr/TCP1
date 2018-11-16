package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.business.domain.Transferencia;
import concessionaria.ui.ConcessionariaInterface;

public class TransferenciaCommand extends Comando{
	
	private final Operacoes operacoes;

	public TransferenciaCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		Transferencia transferencia = operacoes.efetuarTransferencia(this.concessionariaInterface.getLoja());
		if (transferencia instanceof Transferencia) {
			System.out.println("\nTransferencia efetuada com sucesso!\n"+transferencia.toString());
		}
		else {
			System.out.println("\nErro ao efetuar a transferencia!\n");
		}
	}
	
	@Override
	public String toString() {
		return "Efetuar Transferência";
	}

}
