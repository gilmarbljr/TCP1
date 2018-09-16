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
	private final Loja loja;
	
	public Database() {
		this(true);
	}
	
	public Database(boolean iniciar) {
		this.funcionarios = new HashMap<>();
		this.clientes = new HashMap<>();
		this.carros = new HashMap<>();
		this.motos = new HashMap<>();
		this.loja = new Loja();
		
		
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
	public Loja getLoja() {
		return this.loja;
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
	
	public void iniciarDados() {
	}
}
