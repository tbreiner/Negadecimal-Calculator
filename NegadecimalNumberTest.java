package Negadecimal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalNumberTest {
	NegadecimalNumber ndn1;
	NegadecimalNumber ndn2;
	NegadecimalNumber ndn3;
	NegadecimalNumber small;
	NegadecimalNumber big;
	NegadecimalNumber answer;
	

	@Before
	public void setUp() {	
		ndn1 = new NegadecimalNumber(52865);
		ndn2 = new NegadecimalNumber(-4280);
		ndn3 = new NegadecimalNumber("68945");
		small = new NegadecimalNumber(65);
		big = new NegadecimalNumber(400);
		answer = new NegadecimalNumber(0);
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
		assertEquals(48585, (ndn1.add(ndn2)).decnum);
		
		answer = new NegadecimalNumber(48585);
		assertTrue(answer.equals(ndn1.add(ndn2)));
		
		answer = new NegadecimalNumber(465);
		assertTrue(answer.equals(small.add(big)));
	}

	@Test
	public void testSubtract() {
		answer = new NegadecimalNumber(335);
		assertTrue(answer.equals(big.subtract(small)));
	}

	@Test
	public void testMultiply() {
		answer = new NegadecimalNumber(26000);
		assertTrue(answer.equals(small.multiply(big)));
	}

	@Test
	public void testDivide() {
		answer = new NegadecimalNumber(6);
		assertTrue(answer.equals(big.divide(small)));
	}

	@Test
	public void testRemainder() {
		answer = new NegadecimalNumber(10);
		assertTrue(answer.equals(big.remainder(small)));
	}

	@Test
	public void testNegate() {
		answer = new NegadecimalNumber(-400);
		assertTrue(answer.equals(big.negate()));
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
		answer = new NegadecimalNumber(345);
		assertEquals("465", answer.toString());
	}

}
