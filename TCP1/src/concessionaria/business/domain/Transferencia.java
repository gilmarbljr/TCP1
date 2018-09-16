package concessionaria.business.domain;

public class Transferencia extends Transacao {
	
	private Cliente clienteDestino;

	public Transferencia(Cliente cliente, Cliente clienteDestino, double montante, Loja loja) {
		super(cliente, montante, loja);
		this.clienteDestino = clienteDestino;
	}

	public Cliente getClienteDestino() {
		return clienteDestino;
	}
}
