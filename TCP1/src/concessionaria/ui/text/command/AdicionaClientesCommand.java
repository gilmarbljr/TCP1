package concessionaria.ui.text.command;

import concessionaria.business.OperacoesGerenciamento;
import concessionaria.business.domain.Cliente;
import concessionaria.ui.ConcessionariaInterface;

public class AdicionaClientesCommand extends Comando{
	
	private final OperacoesGerenciamento gerenciamento;
	
	public AdicionaClientesCommand(ConcessionariaInterface concessionariaInterface, OperacoesGerenciamento gerenciamento) {
		super(concessionariaInterface);
		this.gerenciamento = gerenciamento;
	}

	@Override
	public void execute() throws Exception {
		Cliente cliente = gerenciamento.adicionaCliente();
		System.out.println("\nCliente cadastrado com sucesso!\n"+cliente.toString());
	}

}
