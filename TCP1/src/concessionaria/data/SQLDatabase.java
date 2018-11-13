package concessionaria.data;

import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import concessionaria.business.ValoresException;
import concessionaria.business.domain.Carro;
import concessionaria.business.domain.Cliente;
import concessionaria.business.domain.Funcionario;
import concessionaria.business.domain.Loja;
import concessionaria.business.domain.Moto;

public class SQLDatabase {
	private Statement stm;
    private ResultSet rs;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "192.168.25.100:3306";
    private final String BANCO = "trabalho";
    private final String URL = "jdbc:mysql://"+SERVER+"/"+BANCO;
    private final String USER = "trabalho";
    private final String SENHA = "Trabalho";
    private final String GET_FUNCIONARIOS = "Trabalho";
    private final String GET_CLIENTES = "Trabalho";
    private final String GET_CARROS = "Trabalho";
    private final String GET_MOTOS = "Trabalho";
    private final String GET_LOJAS = "Trabalho";
    private final String NOME = "NOME";
    private final String IDADE = "IDADE";
    private final String PORTAS = "PORTAS";
    private final String RODAS = "RODAS";
    private final String ANO = "ANO";
    private final String VALOR = "VALOR";
    private final String PLACA = "PLACA";
    private Connection con;
    
    private final Map<String,Funcionario> funcionarios;
	private final Map<String, Cliente> clientes;
	private final Map<String, Carro> carros;
	private final Map<String, Moto> motos;
	private final Map<Integer, Loja> lojas;
	
	public SQLDatabase() {
		this(true);
	}
	
	public SQLDatabase(boolean iniciar) {
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
	
    private void conexao(){
        System.setProperty("jdbc.Drivers", DRIVER);
        try {
            con = DriverManager.getConnection(URL, USER, SENHA);
        } catch (SQLException ex) {
        	System.out.println("Erro ao conectar com o banco de dados!\n" + ex.getMessage());
        }
    }
    
    private void executaSQL(String SQL){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
    }
    
    private void desconecta (){
        try {
            con.close();
        } catch (SQLException ex) {
        	System.out.println("Erro ao encerrar a conexão com o banco de dados\n" + ex.getMessage());
        }
    }
    
    private void iniciarDados() {
    	getSQLLojas();
    	getSQLFuncionarios();
    	getSQLClientes();
    	getSQLCarros();
    	getSQLMotos();
    }
    
    private void getSQLLojas() {
    	conexao();
    	executaSQL(GET_LOJAS);
    	try {
    		int oldID = 0;
			if(rs.first()) {
				do {
					Loja l = new Loja(++oldID, rs.getString(NOME));
					save(l);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	desconecta();
    }
    
    private void getSQLFuncionarios() {
    	conexao();
    	executaSQL(GET_FUNCIONARIOS);
    	try {
			if(rs.first()) {
				do {
					Funcionario f = new Funcionario(rs.getString(NOME), rs.getInt(IDADE));
					save(f);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	desconecta();
    }
    
    private void getSQLClientes() {
    	conexao();
    	executaSQL(GET_CLIENTES);
    	try {
    		int oldID = 0;
			if(rs.first()) {
				do {
					Cliente c = new Cliente(rs.getString(NOME), rs.getInt(IDADE), ++oldID);
					save(c);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	desconecta();
    }
    
    private void getSQLCarros() {
    	conexao();
    	executaSQL(GET_CARROS);
    	try {
			if(rs.first()) {
				do {
					Carro c = new Carro(rs.getString(NOME), rs.getInt(ANO), rs.getInt(PORTAS), rs.getDouble(VALOR), rs.getString(PLACA));
					save(c);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	catch (ValoresException e) {
    		System.out.println(e.getMessage());
		}
    	desconecta();
    }
    
    private void getSQLMotos() {
    	conexao();
    	executaSQL(GET_MOTOS);
    	try {
			if(rs.first()) {
				do {
					Moto m = new Moto(rs.getString(NOME), rs.getInt(ANO), rs.getInt(RODAS), rs.getDouble(VALOR), rs.getString(PLACA));
					save(m);
				} while (rs.next());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	catch (ValoresException e) {
    		System.out.println(e.getMessage());
		}
    	desconecta();
    }
}
