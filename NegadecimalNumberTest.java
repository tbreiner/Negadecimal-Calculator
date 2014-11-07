/** Theresa Breiner and Sara Weinstein
 * CIT 591 Homework 9
 * This file tests our NegadecimalNumber class.
 */
package Negadecimal;

import static org.junit.Assert.*;
//import org.junit.Rule;
//import org.junit.rules.ExpectedException;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalNumberTest {
	NegadecimalNumber ndn1;
	NegadecimalNumber ndn2;
	NegadecimalNumber ndn3;
	NegadecimalNumber small;
	NegadecimalNumber big;
	NegadecimalNumber answer;
	NegadecimalNumber smallNeg;
	

	@Before
	public void setUp() {	
		ndn1 = new NegadecimalNumber(52865);
		ndn2 = new NegadecimalNumber(-4280);
		ndn3 = new NegadecimalNumber("68945");
		small = new NegadecimalNumber(65);
		big = new NegadecimalNumber(400);
		smallNeg = new NegadecimalNumber(-25);
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
		assertTrue(answer.equals(ndn1.add(ndn2)));	//positive and negative
		assertTrue(answer.equals(ndn2.add(ndn1)));	//negative and positive
		answer = new NegadecimalNumber(465);
		assertTrue(answer.equals(small.add(big)));	// positive and positive
		answer = new NegadecimalNumber(-8560);
		assertTrue(answer.equals(ndn2.add(ndn2)));	//negative and negative
	}

	@Test
	public void testSubtract() {
		answer = new NegadecimalNumber(335);
		assertTrue(answer.equals(big.subtract(small))); // big positive, small negative
		answer = new NegadecimalNumber(-335);
		assertTrue(answer.equals(small.subtract(big)));	//small positive, big positive
		answer = new NegadecimalNumber(90);
		assertTrue(answer.equals(small.subtract(smallNeg))); 	//big pos, small neg
		answer = new NegadecimalNumber(-90);
		assertTrue(answer.equals(smallNeg.subtract(small)));	//small neg, big pos
		answer = new NegadecimalNumber(-4255);
		assertTrue(answer.equals(ndn2.subtract(smallNeg)));		//big neg, small neg
		answer = new NegadecimalNumber(4255);
		assertTrue(answer.equals(smallNeg.subtract(ndn2)));		//small neg, big neg
	}

	@Test
	public void testMultiply() {
		answer = new NegadecimalNumber(26000);
		assertTrue(answer.equals(small.multiply(big)));		//two positives
		answer = new NegadecimalNumber(-1625);
		assertTrue(answer.equals(small.multiply(smallNeg)));	//one pos, one neg
		answer = new NegadecimalNumber(625);
		assertTrue(answer.equals(smallNeg.multiply(smallNeg)));	// two negatives
	}

	@Test
	public void testDivide() {
		answer = new NegadecimalNumber(6);
		assertTrue(answer.equals(big.divide(small)));	// big positive, small positive
		answer = new NegadecimalNumber(0);
		assertTrue(answer.equals(small.divide(big)));	//small pos, big pos
		answer = new NegadecimalNumber(0);
		assertTrue(answer.equals(smallNeg.divide(ndn2)));	//small neg, big neg -25 / -4280 = 0 in java
		answer = new NegadecimalNumber(171);
		assertTrue(answer.equals(ndn2.divide(smallNeg)));	//big neg, small neg
		answer = new NegadecimalNumber(-16);
		assertTrue(answer.equals(big.divide(smallNeg)));	//big pos, small neg
		answer = new NegadecimalNumber(0);
		assertTrue(answer.equals(smallNeg.divide(big)));	//small neg, big pos
	}

	@Test
	public void testRemainder() {
		answer = new NegadecimalNumber(10);
		assertTrue(answer.equals(big.remainder(small))); // big pos, small pos
		ndn1 = new NegadecimalNumber("1285");
		ndn2 = new NegadecimalNumber("35");
		answer = new NegadecimalNumber("0");
		assertTrue(answer.equals(ndn1.remainder(ndn2))); // equals 0
		answer = new NegadecimalNumber(65);
		assertTrue(answer.equals(small.remainder(big)));	//small pos, big pos
		answer = new NegadecimalNumber(-25);
		assertTrue(answer.equals(smallNeg.remainder(big)));	//small neg, big pos
		
	}

	@Test
	public void testNegate() {
		answer = new NegadecimalNumber(-400);
		assertTrue(answer.equals(big.negate()));
		
		NegadecimalNumber negated = new NegadecimalNumber(400);
		assertTrue(negated.equals(answer.negate()));
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
	
/*Exception Tests*/	
	
	@Test(expected = IllegalArgumentException.class) 
	public void testNegadecimalConstructorWithBadString() {
		new NegadecimalNumber("hello");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegadecimalConstructorWithEmptyString() {
		new NegadecimalNumber("");
	}
		
	@Test(expected = IllegalArgumentException.class)
	public void testDivideByZeroError() {
		ndn1.divide(answer); 	//answer setup to 0
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegadecimalConstructorWithMixedInput() {
		new NegadecimalNumber("hello45");
	}
}
