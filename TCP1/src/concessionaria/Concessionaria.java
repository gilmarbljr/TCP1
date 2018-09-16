package concessionaria;

import concessionaria.business.impl.OperacoesImpl;
import concessionaria.data.Database;
import concessionaria.ui.ConcessionariaInterface;
import concessionaria.ui.text.LojaInterface;

public abstract class Concessionaria {
	
	protected final ConcessionariaInterface concessionariaInterface;
	
	public static void main(String[] args) {
		Concessionaria concessionaria = null;
		if(args != null && args.length == 0) {
			concessionaria = new ConcessionariaText();
		}
		concessionaria.showUI();
	}
	
	public Concessionaria() {
		Database database = new Database();
		
		OperacoesImpl impl = new OperacoesImpl(database);
		this.concessionariaInterface = new LojaInterface(database.getLoja(), impl);
	}
	
	public abstract void showUI();

}
