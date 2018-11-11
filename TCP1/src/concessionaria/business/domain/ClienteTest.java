package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import concessionaria.business.ValoresException;

public class ClienteTest {
	
	Cliente c1;
	Cliente c2;
	Loja l1;
	double delta = 0.001;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Cliente("Gilmar", 23, 1);
		c2 = new Cliente("Marlise", 20, 2);
		l1 = new Loja(1, "Loja");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		assertEquals(c1.getNome(), "Gilmar");
		assertEquals(c1.getIdade(), 23);
		assertEquals(c1.getCadastro(), 1);
		assertEquals(c1.getMontante(), 0.0, delta);
		assertEquals(c1.getCompras().size(), 0);
		assertEquals(c1.getVendas().size(), 0);
		assertEquals(c1.getTransferencias().size(), 0);
		assertEquals(c1.getMotos().size(), 0);
		assertEquals(c1.getCarros().size(), 0);
	}
	
	@Test
	public void setTest() {
		c1.setNome("Marlise");
		c1.setIdade(20);
		c1.setMontante(1.0);
		c1.setCadastro(2);
		assertEquals(c1.getNome(), "Marlise");
		assertEquals(c1.getIdade(), 20);
		assertEquals(c1.getMontante(), 1.0, delta);
		assertEquals(c1.getCadastro(), 2);
	}
	
	@Test
	public void compraTest() {
		c1.setMontante(30000.0);
		try {
			c1.compra(l1, 0.0);
			assertEquals(c1.getCompras().size(), 0);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.compra(l1,20000.0);
			assertEquals(c1.getCompras().size(), 1);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void vendaTest() {
		c1.setMontante(30000.0);
		try {
			c1.venda(l1, 0.0);
			assertEquals(c1.getVendas().size(), 0);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.venda(l1,20000.0);
			assertEquals(c1.getVendas().size(), 1);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void transferenciaTest() {
		c1.setMontante(30000.0);
		try {
			c1.transferencia(l1,c2, 0.0);
			assertEquals(c1.getTransferencias().size(), 0);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
		try {
			c1.transferencia(l1,c2,20000.0);
			assertEquals(c1.getTransferencias().size(), 1);
		}
		catch (ValoresException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void toStringTest() {
		assertEquals(c1.toString(), "Cadastro: 1\nNome: Gilmar\nIdade: 23\nSaldo: 0.0\n");
	}
	
	

}
