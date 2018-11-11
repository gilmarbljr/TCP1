package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LojaTest {
	
	Loja l1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		l1 = new Loja(1,"Loja");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		assertEquals(l1.getNome(), "Loja");
		assertEquals(l1.getId(), 1);
	}
	
	@Test
	public void setTest() {
		l1.setNome("Lojinha");
		l1.setId(2);
		assertEquals(l1.getNome(), "Lojinha");
		assertEquals(l1.getId(), 2);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(l1.toString(), "Loja - Loja 1\n");
	}

}
