/** Theresa Breiner and Sara Weinstein
 * CIT 591 Homework 9
 * This is our class for our NegadecimalCalculator.
 * It uses Negadecimal objects from our class NegadecimalNumber 
 * to manipulate user input numbers and display calculated values.
 */
package Negadecimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NegadecimalCalculator {

	String display = "0";
	NegadecimalNumber currentNDN = new NegadecimalNumber(0);
	
	public static void main(String[] args) {
		NegadecimalCalculator thisCalculator = new NegadecimalCalculator();
		thisCalculator.REPL();
	}
	
	public void printDisplay() {
		System.out.println("Display: " + display + "\n");
	}
	
	public NegadecimalNumber doArithmetic(char operator, NegadecimalNumber ndn) {
		//does appropriate arithmetic and returns the NDN answer
		if (operator == '+') return currentNDN.add(ndn);
		if (operator == '-') return currentNDN.subtract(ndn);
		if (operator == '*') return currentNDN.multiply(ndn);
		if (operator == '/') return currentNDN.divide(ndn);
		if (operator == '%') return currentNDN.remainder(ndn);
		if (operator == '~') return currentNDN.negate();
		throw new IllegalArgumentException("Error");
	}

	public void REPL() {
		while (true) {
			String command = this.getInput();	//takes user input string
			display = this.evaluate(command);	//evaluates command and prints result
			if (display == "Quit calculator.") {
				printDisplay();
				break;
			}
		}
		return;
	}

	public String getInput() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Valid commands are: +, -, *, /, %, followed by a negadecimal number.\n" +
				"~ : gets the negation of current negadecimal number in display \n?: gets " +
				"value of current number \ndecimal XX: inputs a decimal number to be converted to " +
				"negadecimal\n You must enter (c)lear to clear display and (q)uit to quit calculator. " +
				"You can enter a negadecimal number directly.\n");
		printDisplay();
		System.out.println("Enter a command: ");
		String nLine = keyboard.nextLine();
		if (display == "Error" && !nLine.equalsIgnoreCase("c") && !nLine.equalsIgnoreCase("clear")) {
			System.out.println("You must enter a 'Clear' command to clear the display\n");
			nLine = getInput();
		}
		if (nLine.isEmpty()) {
			return "Error";
		}
		return nLine;
	}
	public String doDecimalInteger(String restOfInput) {
		if (restOfInput.isEmpty()) return "Error";
		if (restOfInput.length() >= 6) {
			if ("ecimal".equalsIgnoreCase(restOfInput.substring(0, 6))) {
				restOfInput = restOfInput.substring(6);
			}
		restOfInput = restOfInput.trim();
		restOfInput = cleanUpNumber(restOfInput);
		}
		try {
			int operand = Integer.parseInt(restOfInput);
			currentNDN = new NegadecimalNumber(operand);
		} catch (IllegalArgumentException e) {
			return "Error";
		}
		return currentNDN.negDN;
	}
	public String evaluate(String s) {
		s = s.trim();
		if (s.length() <= 0) return "Error";
		char operator = s.charAt(0);//get first character of input string to identify operation
		String restOfInput = s.substring(1);// everything following first character is considered operand
		restOfInput = restOfInput.trim();
		
		//if input is only numeric, replaces display with this new ndn
		if (Character.isDigit(operator)) {
			s = cleanUpNumber(s);
			try {
				currentNDN = new NegadecimalNumber(s); //updates global currentNDN
			} catch (IllegalArgumentException e) {
				return "Error";
			}
			return currentNDN.negDN;	//returns string version of NDN to print
		}

		//shows decimal value of displayed ndn
		//and redisplays ndn
		if (operator == '?') {
			if (!restOfInput.isEmpty()) return "Error";
			return currentNDN.negDN + " (decimal " + currentNDN.decnum + ")";
		}

		//replaces # in display with the negadecimal
		//equivalent of the user's dec number
		if (operator == 'd') {
			return doDecimalInteger(restOfInput);
			}

		//clears errors and replaces display with 0
		if ((operator == 'c')||( operator == 'C')) {
			if (!restOfInput.isEmpty() && !"lear".equalsIgnoreCase(restOfInput)) {
				return "Error";
			}else{
				currentNDN = new NegadecimalNumber("0");
				return currentNDN.negDN;
			}}

		//quits program
		if (operator == 'q') {
			if (!restOfInput.isEmpty() && !"uit".equals(restOfInput)) {
				return "Error";
			}
			return "Quit calculator.";
		}	

		//computes the negative of the display
		if (operator == '~') {
			if (!restOfInput.isEmpty()) return "Error";
			currentNDN = currentNDN.negate();	//negates and updates currentNDN
			return currentNDN.negDN;			//returns string version to print
		}
		// perform arithmetic operations
		List <Character> operators = new ArrayList<Character>(5);
		operators = (Arrays.asList('+','-','*','/','%'));
		if (operators.contains(operator)) {
			String secondOperand = cleanUpNumber(restOfInput);
			try {
				NegadecimalNumber newNDN = new NegadecimalNumber(secondOperand);
				currentNDN = doArithmetic(operator, newNDN);
			} catch (IllegalArgumentException e) {
				return "Error";
			} 
			return currentNDN.negDN;
		}
		return "Error";
	}
	
	public String cleanUpNumber(String someString){
		String s = someString;
		s = s.trim();
		while (s.startsWith("0") && (s.length() > 1) ){
			s = s.substring(1);
		}
		return s;
	}

}






