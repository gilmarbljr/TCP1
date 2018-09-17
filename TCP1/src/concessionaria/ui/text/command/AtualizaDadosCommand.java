package concessionaria.ui.text.command;

import concessionaria.business.OperacoesGerenciamento;
import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Moto;
import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.text.UIUtils;

public class AtualizaDadosCommand extends Comando {

	private final OperacoesGerenciamento gerenciamentoImpl;
	
	public AtualizaDadosCommand(ConcessionariaInterface concessionariaInterface, OperacoesGerenciamento gerenciamento) {
		super(concessionariaInterface);
		this.gerenciamentoImpl = gerenciamento;
		
	}
	@Override
	public void execute() throws Exception {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.println("Digite a opção a ser modificada:\n1 - Cliente\n2 - Carro\n3 - Moto\n4 - Saldo loja");
		int key = uiUtils.readInteger();
		switch (key) {
		case 1:
			Cliente cliente = gerenciamentoImpl.atualizaCliente();
			if(cliente instanceof Cliente)
				System.out.println("Cliente atualizado com sucesso!\n"+cliente.toString());
			break;
		case 2:
			Carro carro = gerenciamentoImpl.atualizaCarro();
			if (carro instanceof Carro)
				System.out.println("Carro atualizado com sucesso!\n"+carro.toString());
			break;
		case 3:
			Moto moto = gerenciamentoImpl.atualizaMoto();
			if (moto instanceof Moto)
				System.out.println("Moto atualizada com sucesso!\n"+moto.toString());
			break;
		case 4:
			Cliente loja = gerenciamentoImpl.atualizaSaldoLoja();
			if (loja instanceof Cliente)
				System.out.println("Loja atualizada com sucesso!\n"+loja.toString());
			break;
		default:
			System.out.println("Opção invalida!");
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Atualizar Dados";
	}

}