package concessionaria.ui.text.command;

import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.InterfaceOperacoes;

public abstract class Comando implements InterfaceOperacoes {
	
	protected final ConcessionariaInterface concessionariaInterface;
	
	public Comando(ConcessionariaInterface concessionariaInterface) {
		this.concessionariaInterface = concessionariaInterface;
	}

}