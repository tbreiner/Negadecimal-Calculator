package Negadecimal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalNumberTest {
	NegadecimalNumber ndn1 = new NegadecimalNumber(52865);
	NegadecimalNumber ndn2 = new NegadecimalNumber(-4280);
	NegadecimalNumber ndn3 = new NegadecimalNumber("68945");

	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void testNegadecimalNumberString() {
		NegadecimalNumber ndn = new NegadecimalNumber("465");
		assertEquals(345, ndn.decnum);
		assertEquals("465",ndn.negDN);
		NegadecimalNumber ndn3 = new NegadecimalNumber("1326");
		assertEquals(-714, ndn3.decnum);
		assertEquals("1326",ndn3.negDN);
		try {
			NegadecimalNumber ndn4 = new NegadecimalNumber("");
					}
		catch (IllegalArgumentException e){
			
		}
			
		}
		
	

	@Test
	public void testNegadecimalNumberInt() {
		NegadecimalNumber ndn = new NegadecimalNumber(345);
		assertEquals("465",ndn.negDN);
		assertEquals(345, ndn.decnum);
		NegadecimalNumber ndn3 = new NegadecimalNumber(-714);
		assertEquals(-714, ndn3.decnum);
		assertEquals("1326",ndn3.negDN);

	}

	@Test
	public void testAdd() {
		NegadecimalNumber ndn1 = new NegadecimalNumber(52865);
		NegadecimalNumber ndn2 = new NegadecimalNumber(-4280);
		assertEquals(48585, (ndn1.add(ndn2)).decnum);
	}

	@Test
	public void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemainder() {
		fail("Not yet implemented");
	}

	@Test
	public void testNegate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecimalValue() {
		assertEquals(52865,ndn1.decimalValue());
		assertEquals(-4280,ndn2.decimalValue());
	}

	@Test
	public void testEqualsNegadecimalNumber() {
		assertFalse(ndn2.equals(ndn1));
		assertTrue(ndn3.equals(ndn1));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
