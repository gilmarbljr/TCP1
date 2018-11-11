package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FuncionarioTest {
	
	Funcionario f1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		f1 = new Funcionario("Gilmar",23);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		assertEquals(f1.getNome(), "Gilmar");
		assertEquals(f1.getVendas(), 0);
		assertEquals(f1.getIdade(), 23);
	}
	
	@Test
	public void setTest() {
		f1.setNome("Marlise");
		f1.setIdade(24);
		f1.setVendas(15);
		assertEquals(f1.getNome(), "Marlise");
		assertEquals(f1.getVendas(), 15);
		assertEquals(f1.getIdade(), 24);
	}
	
	@Test
	public void incrementaTest() {
		assertEquals(f1.getVendas(), 0);
		f1.incrementaVendas();
		assertEquals(f1.getVendas(), 1);
		f1.incrementaVendas(4);
		assertEquals(f1.getVendas(), 5);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(f1.toString(), "Nome: Gilmar\nIdade: 23\nVendas: 0\n");
	}

}
