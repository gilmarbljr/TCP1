package concessionaria.business.impl;

import java.util.ArrayList;
import java.util.Date;

import concessionaria.business.Operacoes;
import concessionaria.business.ValoresException;
import concessionaria.business.domain.Venda;
import concessionaria.business.domain.Automovel;
import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Funcionario;
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
			try {
				Carro carro = new Carro(nome, ano, portas,valor,placa);
				database.save(carro);
				carros.add(carro);
			} catch (Exception e) {
				// TODO: handle exception
			}
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
			try {
				Moto moto = new Moto(nome, ano, rodas,valor,placa);
				database.save(moto);
				motos.add(moto);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return motos;
	}

	@Override
	public void aplicarDescontoCarros(int desconto) {
		for(Carro carro : database.getAllCarros()) {
			descontar(carro, desconto);
			System.out.println(carro.toString());
			System.out.println();
		}
	}

	@Override
	public void aplicarDescontoMotos(int desconto) {
		for(Moto moto : database.getAllMotos()) {
			descontar(moto,desconto);
			System.out.println(moto.toString());
			System.out.println();
		}		
	}

	@Override
	public void aplicarDescontoAno(int desconto, int ano) {
		for(Carro carro : database.getAllCarros()) {
			if(carro.getAno() == ano) {
				descontar(carro,desconto);
				System.out.println(carro.toString());
				System.out.println();
			}
		}
		for(Moto moto : database.getAllMotos()) {
			if(moto.getAno() == ano) {
				descontar(moto, desconto);
				System.out.println(moto.toString());
				System.out.println();
			}
		}
	}

	@Override
	public void aplicarDescontoPlaca(int desconto, String placa) {
		for(Carro carro : database.getAllCarros()) {
			if(carro.getPlaca().equals(placa)) {
				descontar(carro,desconto);
				System.out.println(carro.toString());
				System.out.println();
			}
		}
		for(Moto moto : database.getAllMotos()) {
			if(moto.getPlaca().equals(placa)) {
				descontar(moto, desconto);
				System.out.println(moto.toString());
				System.out.println();
			}
		}
	}
	
	private void descontar(Automovel auto,int desconto) {
		try {
			auto.setValor(auto.getValor()*((100.0 - desconto)/100.0));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Venda efetuarVenda(Loja loja) {
		UIUtils uiUtils = UIUtils.INSTANCE;
		Venda venda = null;
		Cliente clienteLoja = database.getCliente(loja.getNome());
		if (clienteLoja instanceof Cliente) {
			System.out.print("Informe o vendedor: ");
			String vendedor = uiUtils.readString();
			Funcionario funcionario = database.getFuncionario(vendedor);
			if (funcionario instanceof Funcionario) {
				System.out.print("Informe o comprador: ");
				String comprador = uiUtils.readString();
				Cliente cliente = database.getCliente(comprador);
				if (cliente instanceof Cliente) {
					Automovel auto = selecionarAutomovel(cliente);
					try {
						cliente.compra(loja, auto.getValor());
						venda = new Venda(cliente, auto.getValor(), loja);
						clienteLoja.venda(loja, auto.getValor());
						funcionario.incrementaVendas();
					} catch (ValoresException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		return venda;
	}
	
	private Automovel selecionarAutomovel(Cliente cliente) {
		UIUtils uiUtils = UIUtils.INSTANCE;
		ArrayList<Automovel> autos = new ArrayList<>();
		for (Carro carro : database.getAllCarros()) {
			if (cliente.getMontante() >= carro.getValor()) {
				autos.add(carro);
			}
		}
		for(Moto moto : database.getAllMotos()) {
			if(cliente.getMontante() >= moto.getValor()) {
				autos.add(moto);
			}
		}
		
		int opcao = 0;
		System.out.println("\n0 - Cancelar");
		for (Automovel auto : autos) {
			System.out.println(++opcao + " - "+auto.getNome()+" "+auto.getAno()+" "+auto.getValor()+"");
		}
		System.out.print("Digite a opcao de compra: ");
		opcao = uiUtils.readInteger();
		return autos.get(opcao-1);
	}
	
}
