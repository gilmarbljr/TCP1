package concessionaria.business.impl;

import concessionaria.business.Operacoes;
import concessionaria.data.Database;

public class OperacoesImpl implements Operacoes {
	private final Database database;
	
	public OperacoesImpl(Database database) {
		this.database = database;
	}
}
