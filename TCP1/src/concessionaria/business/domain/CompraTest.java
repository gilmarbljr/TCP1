package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CompraTest {
	
	Compra c1;
	Cliente cliente;
	Loja l1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Gilmar", 23, 1);
		l1 = new Loja(1, "Loja");
		c1 = new Compra(cliente, 20000.0, l1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(c1.toString(), "Cliente: Gilmar\nValor: 20000.0\nLoja: Loja\n");
	}

}
