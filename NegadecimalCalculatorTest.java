/** Theresa Breiner and Sara Weinstein
 * CIT 591 Homework 9
 * This file tests our NegadecimalCalculator class.
 */

package Negadecimal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalCalculatorTest {

	NegadecimalNumber ndn1;
	NegadecimalNumber ndn2;
	NegadecimalNumber ndn3; 	//keep it negative
	NegadecimalNumber ndn4; 	//keep it negative
	NegadecimalNumber answer;
	NegadecimalCalculator calc;
	
	@Before
	public void setUp() {
		calc = new NegadecimalCalculator();
		ndn1 = new NegadecimalNumber(256);
		ndn2 = new NegadecimalNumber(300);
		answer = new NegadecimalNumber(0);
		
		ndn3 = new NegadecimalNumber(-120);
		ndn4 = new NegadecimalNumber(-80);
	}
	
	@Test
	public void testDoArithmetic() {
		calc.currentNDN = ndn1;
		answer = new NegadecimalNumber(556);
		assertTrue(answer.equals(calc.doArithmetic('+', ndn2)));	//add two positives
		calc.currentNDN = ndn3;
		answer = new NegadecimalNumber(-200);
		assertTrue(answer.equals(calc.doArithmetic('+', ndn4))); // add two negatives
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(220);
		assertTrue(answer.equals(calc.doArithmetic('+', ndn4))); // pos + neg
		
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(44);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn1))); // big pos - small pos
		answer = new NegadecimalNumber(380);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn4))); // pos - neg
		calc.currentNDN = ndn3;
		answer = new NegadecimalNumber(-40);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn4))); // neg - neg
		
		answer = new NegadecimalNumber(-30720);
		assertTrue(answer.equals(calc.doArithmetic('*', ndn1))); // neg * pos
		
		calc.currentNDN = answer;
		assertTrue(ndn1.equals(calc.doArithmetic('/', ndn3))); // neg / neg
		
		calc.currentNDN = ndn1;
		answer = new NegadecimalNumber(76800);
		assertTrue(answer.equals(calc.doArithmetic('*',  ndn2))); // pos * pos
		
		calc.currentNDN = answer;
		assertTrue(ndn2.equals(calc.doArithmetic('/', ndn1))); // pos / pos
		
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(44);
		assertTrue(answer.equals(calc.doArithmetic('%', ndn1))); // big pos % small pos
		
		calc.currentNDN = answer;
		assertTrue(answer.equals(calc.doArithmetic('%', ndn1))); //small pos % big pos
		
		calc.currentNDN = ndn4;
		answer = new NegadecimalNumber(-80);
		assertTrue(answer.equals(calc.doArithmetic('%', ndn3))); // small neg % big neg
		
		calc.currentNDN = ndn3;
		answer = new NegadecimalNumber(-40);
		assertTrue(answer.equals(calc.doArithmetic('%', ndn4))); // big neg % small neg
		
		
	}
	
	@Test
	public void testDoDecimalInteger() {
		assertEquals("Error", calc.doDecimalInteger(""));
		assertEquals("125", calc.doDecimalInteger("85"));
		assertEquals("125", calc.doDecimalInteger("85"));
		assertEquals("125", calc.doDecimalInteger("ecimal85"));
		assertEquals("125", calc.doDecimalInteger("ecimal 85"));
		assertEquals("125", calc.doDecimalInteger("ECIMAL85"));
		assertEquals("Error", calc.doDecimalInteger("36ndn"));
		assertEquals("Error", calc.doDecimalInteger("ecimalandthen85"));
	}

	@Test
	public void testCleanUpNumber() {
		assertEquals("4", calc.cleanUpNumber("004"));
		assertEquals("4", calc.cleanUpNumber("  004"));
	}
	
	@Test
	public void testEvaluate() {
		assertEquals("13", calc.evaluate("    13"));
		assertEquals("13", calc.evaluate("00013"));
		assertEquals("13", calc.evaluate("  013"));
		
		calc.currentNDN = new NegadecimalNumber("13"); 	// = decimal -7
		assertEquals("18", calc.evaluate("+ 5"));		// = decimal 5, 18 = dec -2
		assertEquals("13", calc.evaluate("- 5"));		// -2 - 5 = -7
		assertEquals("58", calc.evaluate("* 6"));		// -7 * 6 = -42
		assertEquals("13", calc.evaluate("/ 6"));		// -42 / 6 = -7
		assertEquals("19", calc.evaluate("% 2"));		// -7 % 2 = -1
		assertEquals("1", calc.evaluate("~"));		// negated -1 = 1
		assertEquals("46", calc.evaluate("   +  45"));	// 1 + -35 = -34
		assertEquals("46 (decimal -34)", calc.evaluate("?"));	//decimal of "46" is -34
		assertEquals("Error", calc.evaluate("hello"));
		assertEquals("0", calc.evaluate("clear"));	
		assertEquals("Error", calc.evaluate("clears"));
		assertEquals("68", calc.evaluate("decimal -52"));
		assertEquals("68", calc.evaluate("   decimal   -52  "));
		assertEquals("68", calc.evaluate("  d  -52"));
		assertEquals("Error", calc.evaluate("d ecim al - 52"));
		assertEquals("Error", calc.evaluate("1200    5"));
		assertEquals("1200", calc.evaluate("1200   ")); 	// 1200 = dec -800
		assertEquals("1285", calc.evaluate(" +85"));		// -800 + -75 = -875
		assertEquals("175", calc.evaluate(" / 35")); 		// -875 / -25 = -35
		assertEquals("0", calc.evaluate("/ 1285"));
		assertEquals("197", calc.evaluate("decimal   17"));	// dec 17 = 197
		assertEquals("73", calc.evaluate("-124"));	// 17 - 84 = -67
		assertEquals("Error", calc.evaluate("random nonsense 4923"));
		assertEquals("Error", calc.evaluate("quitter"));
		assertEquals("Quit calculator.", calc.evaluate("q  "));
	}
}
