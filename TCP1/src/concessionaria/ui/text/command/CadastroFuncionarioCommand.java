package concessionaria.ui.text.command;

import concessionaria.business.OperacoesGerenciamento;
import concessionaria.business.domain.Funcionario;
import concessionaria.ui.ConcessionariaInterface;

public class CadastroFuncionarioCommand extends Comando {
	
	private final OperacoesGerenciamento gerenciamento;
	
	public CadastroFuncionarioCommand(ConcessionariaInterface concessionariaInterface, OperacoesGerenciamento gerenciamento) {
		super(concessionariaInterface);
		this.gerenciamento = gerenciamento;
	}

	@Override
	public void execute() throws Exception {
		Funcionario funcionario = gerenciamento.cadastrarFuncionario();
		if(funcionario instanceof Funcionario) {
			System.out.println("\nFuncionario cadastrado com sucesso!\n"+funcionario.toString());
		}
		else {
			System.out.println("\nErro ao cadastrar novo funcionario!");
		}
	}
	
	@Override
	public String toString() {
		return "Cadastrar Novo Funcionario";
	}

}
