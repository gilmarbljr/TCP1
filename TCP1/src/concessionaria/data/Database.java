package concessionaria.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Funcionario;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Moto;

public class Database {
	private final Map<String,Funcionario> funcionarios;
	private final Map<String, Cliente> clientes;
	private final Map<String, Carro> carros;
	private final Map<String, Moto> motos;
	private final Map<Integer, Loja> lojas;
	
	public Database() {
		this(true);
	}
	
	public Database(boolean iniciar) {
		this.funcionarios = new HashMap<>();
		this.clientes = new HashMap<>();
		this.carros = new HashMap<>();
		this.motos = new HashMap<>();
		this.lojas = new HashMap<>();
		
		
		if(iniciar) {
			iniciarDados();
		}
	}
	
	public Collection<Funcionario> getAllFuncionarios(){
		return this.funcionarios.values();
	}
	public Collection<Cliente> getAllClientes(){
		return this.clientes.values();
	}
	public Collection<Carro> getAllCarros(){
		return this.carros.values();
	}
	public Collection<Moto> getAllMotos(){
		return this.motos.values();
	}
	public Collection<Loja> getAllLojas(){
		return this.lojas.values();
	}
	
	public Funcionario getFuncionario(String nome) {
		return funcionarios.get(nome);
	}
	public Cliente getCliente(String nome) {
		return clientes.get(nome);
	}
	public Carro getCarro(String placa) {
		return carros.get(placa);
	}
	public Moto getMoto(String placa) {
		return motos.get(placa);
	}
	public Loja getLoja(int id) {
		return lojas.get(id);
	}
	
	public void save(Funcionario funcionario) {
		this.funcionarios.put(funcionario.getNome(),funcionario);
	}
	public void save(Cliente cliente) {
		this.clientes.put(cliente.getNome(),cliente);
	}
	public void save(Carro carro) {
		this.carros.put(carro.getPlaca(),carro);
	}
	public void save(Moto moto) {
		this.motos.put(moto.getPlaca(),moto);
	}
	
	public void save(Loja loja) {
		this.lojas.put(loja.getId(), loja);
	}
	
	public void removeCliente(String nome) {
		this.clientes.remove(nome);
	}
	public void removeCarro(String placa) {
		this.carros.remove(placa);
	}
	public void removeMoto(String placa) {
		this.motos.remove(placa);
	}
	public void removeFuncionario(String nome) {
		this.funcionarios.remove(nome);
	}
	public void removeLoja(int id) {
		this.lojas.remove(id);
	}
	
	public void iniciarDados() {
		try {
			
			// Lojas
			int oldID = 0;
			Loja l1 = new Loja(++oldID, "Loja Principal");
			save(l1);
			
			//Clientes
			oldID = 0;
			Cliente c1 = new Cliente(l1.getNome(), 0, ++oldID);
			save(c1);
			
			//Carros
			oldID = 0;
			int portas = 4;
			int ano = 2018;
			int valor = 10000;
			Carro ca1 = new Carro("Uno", ano, portas, valor,"LOJA"+ (++oldID));
			save(ca1);
			Carro ca2 = new Carro("Palio", ano, portas, valor,"LOJA" + (++oldID));
			save(ca2);
			Carro ca3 = new Carro("Versa", ano, portas, valor,"LOJA" + (++oldID));
			save(ca3);
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
