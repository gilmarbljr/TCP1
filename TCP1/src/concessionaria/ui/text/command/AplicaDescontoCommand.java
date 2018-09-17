package concessionaria.ui.text.command;

import concessionaria.business.Operacoes;
import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.text.UIUtils;

public class AplicaDescontoCommand extends Comando{

	private final Operacoes operacoes;
	
	public AplicaDescontoCommand(ConcessionariaInterface concessionariaInterface, Operacoes operacoes) {
		super(concessionariaInterface);
		this.operacoes = operacoes;
	}

	@Override
	public void execute() throws Exception {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print("Digite o desconto: ");
		int desconto = uiUtils.readInteger();
		if(desconto > 0) {
			System.out.print("\n0 - Cancelar\n1 - Todos os carros\n2 - Todas as motos\n3 - Veiculos por ano\n4 - Por placa\nDigite a opção para aplicar o desconto:");
			int key = uiUtils.readInteger();
			System.out.println();
			switch (key) {
			case 0:
				break;
			case 1:
				operacoes.aplicarDescontoCarros(desconto);
				break;
			case 2:
				operacoes.aplicarDescontoMotos(desconto);
				break;
			case 3:
				System.out.print("Digite o ano: ");
				int ano = uiUtils.readInteger();
				System.out.println();
				if (ano > 0) {
					operacoes.aplicarDescontoAno(desconto,ano);
				}
				break;
			case 4:
				System.out.print("Digite a placa: ");
				String placa = uiUtils.readString();
				System.out.println();
				if(placa != null && !placa.equals("")) {
					operacoes.aplicarDescontoPlaca(desconto,placa);
				}
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Aplicar Descontos em Automoveis";
	}
}
