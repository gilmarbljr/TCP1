package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.ui.ConcessionariaInterface;

public class FuncionarioDoMesCommand extends Comando {
	
	private final Operacoes operacoes;

	public FuncionarioDoMesCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Funcionario do Mês: "+operacoes.funcionarioDoMes()+"\n");	
	}
	
	@Override
	public String toString() {
		return "Funcionario do Mês";
	}

}