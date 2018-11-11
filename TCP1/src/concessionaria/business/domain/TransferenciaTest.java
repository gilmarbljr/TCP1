package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TransferenciaTest {
	Cliente c1;
	Cliente c2;
	Loja l1;
	Transferencia t1;

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
		t1 = new Transferencia(c1,c2,20000.0,l1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(t1.toString(),"Cliente: Gilmar\nCliente Destino: Marlise\nValor: 20000.0\nLoja: Loja\n");
	}

}
