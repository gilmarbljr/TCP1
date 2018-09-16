package concessionaria.business.impl;

import java.util.Date;

import concessionaria.business.Operacoes;
import concessionaria.business.ValoresException;
import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Moto;
import concessionaria.data.Database;
import concessionaria.ui.text.UIUtils;

public class OperacoesImpl implements Operacoes {
	private final Database database;
	
	public OperacoesImpl(Database database) {
		this.database = database;
	}

	@Override
	public double getSaldo(String clienteCadastro) throws ValoresException {
		return database.getCliente(clienteCadastro).getMontante();
	}

	@Override
	public String getCliente(Loja loja) {
		return database.getCliente(loja.getNome()).getNome();
	}
	
	public void criarAutomoveis() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.println("Digite o tipo:\n1 - Carro\n2 - Moto");
		int tipo = uiUtils.readInteger();
		switch (tipo) {
		case 1:
			criarCarros();
			showCarros();
			break;
		case 2:
			criarMotos();
			showMotos();
		default:
			System.out.println("Veiculo nao cadastrado!");
			break;
		}
	}
	
	private void criarCarros() {
		UIUtils uiUtil = UIUtils.INSTANCE;
		System.out.println("Digite o nome do carro: ");
		String nome = uiUtil.readString();
		int ano = (new Date(System.currentTimeMillis())).getYear();
		System.out.println("Digite a quantidade de veiculos: ");
		int quantidade = uiUtil.readInteger();
		System.out.println("Digite o numero de portas: ");
		int portas = uiUtil.readInteger();
		System.out.println("Digite o valor do carro: ");
		double valor = uiUtil.readDouble();
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite a placa do veiculo: ");
			String placa = uiUtil.readString();
			Carro carro = new Carro(nome, ano, portas,valor,placa);
			database.save(carro);
		}
	}
	
	private void criarMotos() {
		UIUtils uiUtil = UIUtils.INSTANCE;
		System.out.println("Digite o nome da moto: ");
		String nome = uiUtil.readString();
		int ano = (new Date(System.currentTimeMillis())).getYear();
		System.out.println("Digite a quantidade de veiculos: ");
		int quantidade = uiUtil.readInteger();
		System.out.println("Digite o numero de rodas: ");
		int rodas = uiUtil.readInteger();
		System.out.println("Digite o valor da moto: ");
		double valor = uiUtil.readDouble();
		for (int i = 0; i < quantidade; i++) {
			System.out.println("Digite a placa do veiculo: ");
			String placa = uiUtil.readString();
			Moto moto = new Moto(nome, ano, rodas,valor,placa);
			database.save(moto);
		}
	}
	
	public void showCarros() {
		for (Carro carro : database.getAllCarros()) {
			System.out.println("Carro: "+ carro.getNome()+ "\nplaca: "+carro.getPlaca()+"\n");
		}
	}
	
	public void showMotos() {
		for (Moto mt : database.getAllMotos()) {
			System.out.println(mt.getNome() + "\nplaca: " + mt.getPlaca()+"\n");
		}
	}
	
}
