package concessionaria.business.domain;

public class Venda extends Transacao{

	public Venda(Cliente cliente, double montante, Loja loja) {
		super(cliente, montante, loja);
	}
	
	@Override
	public String toString() {
		return "Cliente: "+getCliente().getNome()+"\nLoja: "+getLoja().getNome()+"\nData: "+getDate().toString()+"\nValor: "+getMontante();
	}

}
