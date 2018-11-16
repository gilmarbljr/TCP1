package concessionaria;

import java.util.List;
import java.util.ArrayList;

import concessionaria.business.domain.Loja;
import concessionaria.business.impl.OperacoesGerenciamentoImpl;
import concessionaria.business.impl.OperacoesImpl;
import concessionaria.data.SQLDatabase;
import concessionaria.ui.ConcessionariaInterface;

public abstract class Concessionaria {
	
	protected final List<ConcessionariaInterface> concessionariaInterfaces;
	
	public static void main(String[] args) {
		Concessionaria concessionaria = null;
		if(args != null && args.length == 0) {
			concessionaria = new ConcessionariaText();
		}
		concessionaria.showUI();
	}
	
	public Concessionaria() {
		SQLDatabase database = new SQLDatabase();
		
		OperacoesImpl impl = new OperacoesImpl(database);
		OperacoesGerenciamentoImpl gerenciamentoImpl = new OperacoesGerenciamentoImpl(database);
		
		this.concessionariaInterfaces = new ArrayList<>(database.getAllLojas().size());
		
		for (Loja loja : database.getAllLojas()) {
			if(loja instanceof Loja)
				concessionariaInterfaces.add(createLojaInterface(loja,impl,gerenciamentoImpl));
		}
	}
	
	public abstract void showUI();
	
	public abstract ConcessionariaInterface createLojaInterface(Loja loja, OperacoesImpl impl, OperacoesGerenciamentoImpl gerenciamentoImpl);

}
