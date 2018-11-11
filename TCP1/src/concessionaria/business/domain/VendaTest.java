package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendaTest {
	
	Venda v1;
	Cliente c1;
	Loja l1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Cliente("Gilmar", 23, 1);
		l1 = new Loja(1, "Loja");
		v1 = new Venda(c1, 20000.0, l1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(v1.toString(), "Cliente: Gilmar\nValor: 20000.0\nLoja: Loja\n");
	}

}
