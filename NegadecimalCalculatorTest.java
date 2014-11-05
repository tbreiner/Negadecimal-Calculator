package Negadecimal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NegadecimalCalculatorTest {

	NegadecimalNumber ndn1;
	NegadecimalNumber ndn2;
	NegadecimalNumber answer;
	
	@Before
	public void setUp() {
		ndn1 = new NegadecimalNumber(256);
		ndn2 = new NegadecimalNumber(300);
		answer = new NegadecimalNumber(0);
	}
	
	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	
	
	@Test
	public void testDoArithmetic() {
		answer = new NegadecimalNumber(556);
		//NegadecimalCalculator.setCurrentNDN(ndn1);
		//assertEquals(answer, NegadecimalCalculator.doArithmetic('+', ndn2));
		
		/*setCurrentNDN(ndn2);
		 * answer = new NegadecimalNumber(44);
		assertEquals(answer, doArithmetic('-', ndn1));
		
		answer = new NegadecimalNumber(76800);
		assertEquals(answer, doArithmetic('*', ndn1);
		
		setCurrentNDN(answer);
		assertEquals(ndn1, doArithmetic(ndn2));
		
		setCurrentNDN(ndn2);
		answer = new NegadecimalNumber(44);
		assertEquals(answer, doArithmetic(ndn1);
		*/
		
	}

	@Test
	public void testFindSecondOperand() {
		fail("Not yet implemented");
	}

	@Test
	public void testREPL() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindOperatorIndex() {
		fail("Not yet implemented");
	}

	@Test
	public void testBadInputForSimple() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInput() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoDecimalInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testEvaluate() {
		fail("Not yet implemented");
	}

}
