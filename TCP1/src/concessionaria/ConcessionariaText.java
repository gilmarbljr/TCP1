package concessionaria;

import concessionaria.business.domain.Loja;
import concessionaria.business.impl.OperacoesGerenciamentoImpl;
import concessionaria.business.impl.OperacoesImpl;
import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.text.LojaInterface;
import concessionaria.ui.text.UIUtils;

public class ConcessionariaText extends Concessionaria {

	private String getMenu() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < concessionariaInterfaces.size(); i++) {
			ConcessionariaInterface ci = concessionariaInterfaces.get(i);
			sb.append(i + 1).append(" - ");
			if (ci instanceof LojaInterface) {
				sb.append(((Loja) ci.getLoja()).getNome());
				sb.append("\n");
			}
		}
		sb.append("Escolha um interface de loja (ou 0 para sair): ");
		return sb.toString();
	}
	
	@Override
	public void showUI() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.println(getMenu());
		Integer option = uiUtils.readInteger();
		while (option != 0) {
			if (option > 0 && option <= concessionariaInterfaces.size()) {
				this.concessionariaInterfaces.get(option - 1).criarMostrarInterface();
			}
			System.out.print(getMenu());
			option = uiUtils.readInteger();
		}
		System.out.println("Bye!\n");
	}

	@Override
	public ConcessionariaInterface createLojaInterface(Loja loja, OperacoesImpl impl, OperacoesGerenciamentoImpl gerenciamentoImpl) {
		return new LojaInterface(loja, impl,gerenciamentoImpl);
	}

}
