package concessionaria.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import concessionaria.business.domain.Loja;

public abstract class ConcessionariaInterface{

	protected final Map<String, InterfaceOperacoes> acoes;
	protected final Loja loja;
	
	
	protected ConcessionariaInterface(Loja loja) {
		this.acoes = new LinkedHashMap<>();
		this.loja = loja;
	}
	
	protected void adicionaAcao(String codigo, InterfaceOperacoes acao) {
		this.acoes.put(codigo, acao);
	}
	
	public Loja getLoja() {
		return loja;
	}
	
	public abstract void  criarMostrarInterface();
}
