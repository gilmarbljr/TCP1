package concessionaria.business.domain;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import concessionaria.business.ValoresException;

public class MotoTest {
	
	Moto m1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		m1 = new Moto("Twister",2018, 2, 20000.0, "XXX0001");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void constructorTest() {
		assertEquals(m1.toString(), "Placa: XXX0001\nNome: Twister\nAno: 2018\nRodas: 2\nValor: 20000.0\n");
		try {
			m1.setAno(2017);
		}
		catch(ValoresException e) {
			System.out.println(e.getMessage());
		}
		assertEquals(m1.getAno(), 2017);
		try {
			m1.setNome("Kawasaki");
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getNome(), "Kawasaki");
		try {
			m1.setRodas(3);
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getRodas(), 3);
		try {
			m1.setRodas(1);
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getRodas(), 3);
		try {
			m1.emplacar("XXX0002");
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getPlaca(), "XXX0002");
		try {
			m1.emplacar("");
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getPlaca(), "XXX0002");
		try {
			m1.setValor(15000.0);
		}
		catch(ValoresException e) {
		}
		assertEquals(m1.getValor(), 15000.0, 0.001);
		try {
			m1.setValor(-1.1);
		} catch (ValoresException e) {
		}
		assertEquals(m1.getValor(), 15000.0, 0.001);
	}

}
