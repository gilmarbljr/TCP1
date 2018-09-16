package concessionaria.ui.text;

import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.InterfaceOperacoes;
import concessionaria.ui.text.command.Comando;

public abstract class ConcessionariaTextInterface extends ConcessionariaInterface {

	public static final String FECHAR = "Q";
	
	@Override
	public void criarMostrarInterface() {
		System.out.println(getMenu());
		String comandoChave = null;
		do{
			System.out.println();
			System.out.println(getMenu());
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
	}
	
	private String getMenu() {
		StringBuffer string = new StringBuffer();
		for (String chave : acoes.keySet()) {
			InterfaceOperacoes interfaceOperacoes = acoes.get(chave);
			string.append(chave)
			.append(" - ")
			.append(interfaceOperacoes.getClass()
								.getSimpleName()).append("\n");
		}
		string.append("Escolha a acao: ");
		return string.toString();
	}

}
