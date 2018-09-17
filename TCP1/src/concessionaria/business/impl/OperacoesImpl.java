package concessionaria.business.impl;

import java.util.ArrayList;
import java.util.Date;

import concessionaria.business.Operacoes;
import concessionaria.business.ValoresException;
import concessionaria.business.domain.Automovel;
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
	
	public ArrayList<Automovel> criarAutomoveis() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		
		ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
		System.out.println("Digite o tipo:\n1 - Carro\n2 - Moto");
		int tipo = uiUtils.readInteger();
		switch (tipo) {
		case 1:
			automoveis.addAll(criarCarros());
			break;
		case 2:
			automoveis.addAll(criarMotos());
		default:
			System.out.println("Veiculo nao cadastrado!");
			break;
		}
		
		return automoveis;
	}
	
	private ArrayList<Carro> criarCarros() {
		UIUtils uiUtil = UIUtils.INSTANCE;
		System.out.println("Digite o nome do carro: ");
		String nome = uiUtil.readString();
		@SuppressWarnings("deprecation")
		int ano = (new Date(System.currentTimeMillis())).getYear();
		System.out.println("Digite a quantidade de veiculos: ");
		int quantidade = uiUtil.readInteger();
		ArrayList<Carro> carros = new ArrayList<>(quantidade);
		System.out.println("Digite o numero de portas: ");
		int portas = uiUtil.readInteger();
		System.out.println("Digite o valor do carro: ");
		double valor = uiUtil.readDouble();
		for (int i = 0; i < quantidade; i++) {
			String placa = "LOJA"+(database.getAllCarros().size()+1);
			Carro carro = new Carro(nome, ano, portas,valor,placa);
			database.save(carro);
			carros.add(carro);
		}
		return carros;
	}
	
	private ArrayList<Moto> criarMotos() {
		UIUtils uiUtil = UIUtils.INSTANCE;
		System.out.println("Digite o nome da moto: ");
		String nome = uiUtil.readString();
		@SuppressWarnings("deprecation")
		int ano = (new Date(System.currentTimeMillis())).getYear();
		System.out.println("Digite a quantidade de veiculos: ");
		int quantidade = uiUtil.readInteger();
		ArrayList<Moto> motos = new ArrayList<>(quantidade);
		System.out.println("Digite o numero de rodas: ");
		int rodas = uiUtil.readInteger();
		System.out.println("Digite o valor da moto: ");
		double valor = uiUtil.readDouble();
		for (int i = 0; i < quantidade; i++) {
			String placa = "LOJA"+(database.getAllCarros().size()+1);
			Moto moto = new Moto(nome, ano, rodas,valor,placa);
			database.save(moto);
			motos.add(moto);
		}
		return motos;
	}
	
}
