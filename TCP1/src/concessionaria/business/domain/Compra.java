package concessionaria.business.domain;

public class Compra extends Transacao{

	public Compra(Cliente cliente, double montante, Loja loja) {
		super(cliente, montante, loja);
	}

}
