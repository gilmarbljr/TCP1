package concessionaria.business.impl;

import concessionaria.business.domain.Funcionario;
import concessionaria.business.OperacoesGerenciamento;
import concessionaria.business.ValoresException;
import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Moto;
import concessionaria.data.Database;
import concessionaria.ui.text.UIUtils;

public class OperacoesGerenciamentoImpl implements OperacoesGerenciamento{
	private final Database database;
	
	public OperacoesGerenciamentoImpl(Database database) {
		this.database = database;
	}

	@Override
	public Cliente adicionaCliente() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.println("Informe os dados do cliente abaixo");
		System.out.print("Nome: ");
		String nome = uiUtils.readString();
		System.out.print("Idade: ");
		int idade = uiUtils.readInteger();
		
		Cliente cliente = new Cliente(nome, idade, (database.getAllClientes().size()+1));
		database.save(cliente);
		
		return cliente;
	}
	
	public Cliente atualizaCliente() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print("Digite o nome do cliente a ser modificado: ");
		String nome = uiUtils.readString();
		Cliente cliente = database.getCliente(nome);
		if(cliente instanceof Cliente) {
			database.removeCliente(nome);
			System.out.println("Digite a opção a ser modificada:\n1 - Nome\n2 - Idade\n3 - Saldo\n0 - Cancelar");
			int opcao = uiUtils.readInteger();
			switch (opcao) {
			case 1:
				System.out.print("Digite o nome: ");
				String novoNome = uiUtils.readString();
				if(novoNome != null && !novoNome.equals(""))
					cliente.setNome(novoNome);
				break;
			case 2:
				System.out.print("Digite a idade: ");
				int idade = uiUtils.readInteger();
				if(idade > 0)
					cliente.setIdade(idade);
				break;
			case 3:
				System.out.print("Digite o saldo: ");
				double saldo = uiUtils.readDouble();
				cliente.setMontante(saldo);
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
			database.save(cliente);
		}
		else {
			System.out.println("\nCliente não cadastrado!");
		}
		return cliente;
	}

	@Override
	public Carro atualizaCarro() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print("Digite a placa do automovel: ");
		String placa = uiUtils.readString();
		Carro carro = database.getCarro(placa);
		if(carro instanceof Carro) {
			database.removeCarro(placa);
			System.out.println("Digite a opção a ser modificada:\n1 - Placa\n2 - Nome\n3 - Ano\n4 - Portas\n5 - Valor\n0 - Cancelar");
			int opcao = uiUtils.readInteger();
			switch (opcao) {
			case 1:
				System.out.print("Digite a nova placa: ");
				String novaPlaca = uiUtils.readString();
				try {
					carro.emplacar(novaPlaca);
				} catch (ValoresException e) {
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.print("Digite o novo nome: ");
				String nome = uiUtils.readString();
				try {
					carro.setNome(nome);
				} catch (ValoresException e) {
					// TODO: handle exception
				}
				break;
			case 3:
				System.out.print("Digite o ano: ");
				int ano = uiUtils.readInteger();
				try {
					carro.setAno(ano);
				} catch (ValoresException e) {
					// TODO: handle exception
				}
				
				break;
			case 4:
				System.out.print("Digite o numero de portas: ");
				int portas = uiUtils.readInteger();
				try {
					carro.setPortas(portas);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 5:
				System.out.print("Digite o novo valor: ");
				double valor = uiUtils.readDouble();
				try {
					carro.setValor(valor);
				} catch (Exception e) {
					// TODO: handle exception
				}
			default:
				System.out.println("Opcão invalida!");
				break;
			}
			database.save(carro);
		}
		else {
			System.out.println("Carro não cadastrado!");
		}
		return carro;
	}
	
	public Moto atualizaMoto() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print("Digite a placa do automovel: ");
		String placa = uiUtils.readString();
		Moto moto = database.getMoto(placa);
		if (moto instanceof Moto) {
			database.removeMoto(placa);
			System.out.println("Digite a opção a ser modificada:\n1 - Placa\n2 - Nome\n3 - Ano\n4 - Rodas\n5 - Valor\n0 - Cancelar");
			int opcao = uiUtils.readInteger();
			switch (opcao) {
			case 1:
				System.out.print("Digite a nova placa: ");
				String novaPlaca = uiUtils.readString();
				try {
					moto.emplacar(novaPlaca);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.print("Digite o novo nome: ");
				String nome = uiUtils.readString();
				try {
					moto.setNome(nome);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 3:
				System.out.print("Digite o ano: ");
				int ano = uiUtils.readInteger();
				try {
					moto.setAno(ano);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 4:
				System.out.print("Digite o numero de rodas: ");
				int rodas = uiUtils.readInteger();
				try {
					moto.setRodas(rodas);
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
			case 5:
				System.out.print("Digite o novo valor: ");
				double valor = uiUtils.readDouble();
				try {
					moto.setValor(valor);
				} catch (Exception e) {
					// TODO: handle exception
				}
			default:
				System.out.println("Opcão invalida!");
				break;
			}
			database.save(moto);
		}
		else {
			System.out.println("Moto não cadastrada!");
		}
		return moto;
	}

	@Override
	public Loja atualizaLoja() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		System.out.print("Digite o nome da loja: ");
		int id = uiUtils.readInteger();
		Loja loja = database.getLoja(id);
		if (loja instanceof Loja) {
			database.removeLoja(id);
			System.out.print("Digite o novo nome da loja: ");
			String novoNome = uiUtils.readString();
			loja.setNome(novoNome);
			database.save(loja);
		}
		else {
			System.out.println("Loja não cadastrada!");
		}
		return loja;
	}

	@Override
	public Cliente atualizaSaldoLoja() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		Cliente clienteLoja = null;
		System.out.print("Digite o nome da loja: ");
		int id = uiUtils.readInteger();
		Loja loja = database.getLoja(id);
		if (loja instanceof Loja) {
			System.out.print("Valor adicionado ao saldo: ");
			double valor = uiUtils.readDouble();
			clienteLoja = database.getCliente(loja.getNome());
			if (clienteLoja instanceof Cliente)
				clienteLoja.setMontante(clienteLoja.getMontante()+valor);
		}
		else {
			System.out.println("Loja não cadastrada!");
		}
		return clienteLoja;
	}

	@Override
	public Funcionario cadastrarFuncionario() {
		UIUtils uiUtils = UIUtils.INSTANCE;
		Funcionario funcionario = null;
		System.out.print("Digite o nome do funcionario: ");
		String nome = uiUtils.readString();
		if(nome != null && !nome.equals("")) {
			System.out.print("Digite a idade: ");
			int idade = uiUtils.readInteger();
			if(idade > 0) {
				funcionario = new Funcionario(nome, idade);
				database.save(funcionario);
			}
		}
		return funcionario;
	}
}
