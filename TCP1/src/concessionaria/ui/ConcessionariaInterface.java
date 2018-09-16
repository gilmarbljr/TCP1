package concessionaria.ui;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class ConcessionariaInterface {

	protected final Map<String, InterfaceOperacoes> acoes;
	
	
	protected ConcessionariaInterface() {
		this.acoes = new LinkedHashMap<>();
	}
	
	protected void adicionaAcao(String codigo, InterfaceOperacoes acao) {
		this.acoes.put(codigo, acao);
	}
	
	public abstract void  criarMostrarInterface();
}
