package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import concessionaria.business.ValoresException;

public class CarroTest {
	
	Carro c1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Carro("Logan", 2018, 4, 40000.0, "XXX0001");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		assertEquals(c1.getAno(), 2018);
		assertEquals(c1.getNome(), "Logan");
		assertEquals(c1.getPlaca(), "XXX0001");
		assertEquals(c1.getPortas(), 4);
		assertEquals(c1.getValor(), 40000.0, 0.001);
		assertEquals(c1.toString(), "Placa: XXX0001\nNome: Logan\nAno: 2018\nPortas: 4\nValor: 40000.0\n");
	}
	
	@Test
	public void setTest() {
		assertEquals(c1.toString(), "Placa: XXX0001\nNome: Logan\nAno: 2018\nPortas: 4\nValor: 40000.0\n");
		try {
			c1.setAno(2017);
		}
		catch(ValoresException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(c1.getAno(), 2017);
		try {
			c1.setNome("Versa");
		}
		catch(ValoresException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(c1.getNome(), "Versa");
		try {
			c1.setPortas(2);
		}
		catch(ValoresException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(c1.getPortas(), 2);
		try {
			c1.setPortas(1);
		}
		catch(ValoresException e) {
		}
		assertEquals(c1.getPortas(), 2);
		try {
			c1.emplacar("XXX0002");
		}
		catch(ValoresException e) {
		}
		assertEquals(c1.getPlaca(), "XXX0002");
		try {
			c1.emplacar("");
		}
		catch(ValoresException e) {
		}
		assertEquals(c1.getPlaca(), "XXX0002");
		try {
			c1.setValor(20000.0);
		}
		catch(ValoresException e) {
		}
		assertEquals(c1.getValor(), 20000.0, 0.001);
		try {
			c1.setValor(-1.1);
		} catch (ValoresException e) {
		}
		assertEquals(c1.getValor(), 20000.0, 0.001);
	}

}
