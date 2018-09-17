package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.business.domain.Venda;
import concessionaria.ui.ConcessionariaInterface;

public class VendaCommand extends Comando{

	private final Operacoes operacoes;
	
	public VendaCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		Venda venda = operacoes.efetuarVenda(this.concessionariaInterface.getLoja());
		if (venda instanceof Venda) {
			System.out.println("\nVenda efetuada com sucesso!\n"+venda.toString());
		}
		else {
			System.out.println("\nErro ao efetuar a compra!\n");
		}
	}
	
	@Override
	public String toString() {
		return "Efetuar Venda";
	}
}
