package concessionaria.business.domain;

import java.util.ArrayList;
import java.util.List;

import concessionaria.business.ValoresException;

public class Cliente extends Pessoa {
	private double montante;
	private int cadastro;
	private List<Compra> compras;
	private List<Venda> vendas;
	private List<Transferencia> transferencias;
	private List<Carro> carros;
	private List<Moto> motos;
	
	public Cliente(String nome, int idade, int cadastro) {
		super(nome,idade);
		this.cadastro = cadastro;
		this.montante = 0.0;
		this.compras = new ArrayList<>();
		this.vendas = new ArrayList<>();
		this.transferencias = new ArrayList<>();
		this.carros = new ArrayList<>();
		this.motos = new ArrayList<>();
	}
	
	public int getCadastro() {
		return cadastro;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public List<Venda> getVendas() {
		return vendas;
	}
	public List<Transferencia> getTransferencias() {
		return transferencias;
	}
	public double getMontante() {
		return montante;
	}
	public List<Carro> getCarros() {
		return carros;
	}
	public List<Moto> getMotos() {
		return motos;
	}
	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}
	
	public List<Transacao> getTransacoes() {
		List<Transacao> transacoes = new ArrayList<>(compras.size()+vendas.size()+transferencias.size());
		transacoes.addAll(compras);
		transacoes.addAll(vendas);
		transacoes.addAll(transferencias);
		return transacoes;
	}
	
	public Compra compra(Loja loja, double valor) throws ValoresException{
		efetuarPagamento(valor);
		Compra compra = new Compra(this, valor, loja);
		this.compras.add(compra);
		return compra;
	}
	
	public Venda venda(Loja loja, double valor) throws ValoresException {
		efetuarVenda(valor);
		Venda venda = new Venda(this, valor, loja);
		this.vendas.add(venda);
		return venda;
	}
	
	public Transferencia transferencia(Loja loja, Cliente clienteDestino, double valor) throws ValoresException {
		
		efetuarPagamento(valor);
		Transferencia transferencia = new Transferencia(this, clienteDestino, valor, loja);
		clienteDestino.efetuarVenda(valor);
		clienteDestino.transferencias.add(transferencia);
		
		this.transferencias.add(transferencia);
		return transferencia;
	}
	
	private void efetuarPagamento(double valor) throws ValoresException {
		if(!isValidAmout(valor))
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		if(!hasEnoughBalance(valor))
			throw new ValoresException(ValoresException.VALOR_EXCEDIDO);
		
		this.montante -= valor;
	}
	
	private void efetuarVenda(double valor) throws ValoresException{
		if(!isValidAmout(valor)) {
			throw new ValoresException(ValoresException.VALOR_INVALIDO);
		}
		this.montante += valor;
	}
	
	public void setMontante(double montante) {
		this.montante = montante;
	}
	
	private boolean isValidAmout(double valor) {
		return valor > 0;
	}
	
	private boolean hasEnoughBalance(double valor) {
		return valor <= this.montante;
	}
	
	@Override
	public String toString() {
		return "Cadastro: "+getCadastro()+"\nNome: "+getNome()+"\nIdade: "+ getIdade()+"\nSaldo: "+getMontante()+"\n";
	}
}
