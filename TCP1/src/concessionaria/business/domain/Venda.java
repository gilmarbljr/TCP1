package concessionaria.business.domain;

public class Venda extends Transacao{

	public Venda(Cliente cliente, double montante, Loja loja) {
		super(cliente, montante, loja);
	}

}
