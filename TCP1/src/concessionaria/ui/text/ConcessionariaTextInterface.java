package concessionaria.ui.text;

import concessionaria.business.domain.Loja;
import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.InterfaceOperacoes;
import concessionaria.ui.text.command.Comando;

public abstract class ConcessionariaTextInterface extends ConcessionariaInterface {

	protected ConcessionariaTextInterface(Loja loja) {
		super(loja);
	}

	public static final String FECHAR = "0";
	
	@Override
	public void criarMostrarInterface() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		String comandoChave = null;
		do{
			System.out.println();
			System.out.print(getMenu());
			comandoChave = uiUtils.readString();
			Comando comando = (Comando) acoes.get(comandoChave);
			if(comando != null) {
				try {
					comando.execute();
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		}
		while(!FECHAR.equals(comandoChave));
		System.out.println();
	}
	
	private String getMenu() {
		StringBuffer string = new StringBuffer();
		string.append("0 - Sair\n");
		for (String chave : acoes.keySet()) {
			InterfaceOperacoes interfaceOperacoes = acoes.get(chave);
			string.append(chave)
			.append(" - ")
			.append(interfaceOperacoes.toString()).append("\n");
		}
		string.append("Escolha a acao: ");
		return string.toString();
	}

}
