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
		assertTrue(answer.equals(calc.doArithmetic('+', ndn2)));
		
		calc.currentNDN = ndn3;
		answer = new NegadecimalNumber(-200);
		assertTrue(answer.equals(calc.doArithmetic('+', ndn4)));
		
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(220);
		assertTrue(answer.equals(calc.doArithmetic('+', ndn4)));
		
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(44);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn1)));
		
		answer = new NegadecimalNumber(380);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn4)));
		
		calc.currentNDN = ndn3;
		answer = new NegadecimalNumber(-40);
		assertTrue(answer.equals(calc.doArithmetic('-', ndn4)));
		
		answer = new NegadecimalNumber(-30720);
		assertTrue(answer.equals(calc.doArithmetic('*', ndn1)));
		
		calc.currentNDN = answer;
		assertTrue(ndn1.equals(calc.doArithmetic('/', ndn3)));
		
		calc.currentNDN = ndn1;
		answer = new NegadecimalNumber(76800);
		assertTrue(answer.equals(calc.doArithmetic('*',  ndn2)));
		
		calc.currentNDN = answer;
		assertTrue(ndn2.equals(calc.doArithmetic('/', ndn1)));
		
		calc.currentNDN = ndn2;
		answer = new NegadecimalNumber(44);
		assertTrue(answer.equals(calc.doArithmetic('%', ndn1)));
		
		
	}

	@Test
	public void testFindSecondOperand() {
		assertEquals("982", calc.findSecondOperand(" 982"));
		assertEquals("714", calc.findSecondOperand("714"));
	}

	@Test
	public void testREPL() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testDoDecimalInteger() {
		assertEquals("125", calc.doDecimalInteger(" 85"));
		assertEquals("125", calc.doDecimalInteger("85"));
		assertEquals("125", calc.doDecimalInteger("ecimal85"));
		assertEquals("125", calc.doDecimalInteger("ecimal 85"));
	}

	@Test
	public void testEvaluate() {
		fail("Not yet implemented");
	}

	
	public void setCurrentNDN(NegadecimalNumber ndn) {
		calc.currentNDN = ndn;
		return;
	}
}
