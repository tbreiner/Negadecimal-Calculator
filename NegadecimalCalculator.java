package Negadecimal;

import java.util.Scanner;

public class NegadecimalCalculator {

	String display = "0";
	NegadecimalNumber currentNDN = new NegadecimalNumber(0);
	
	public static void main(String[] args) {
		NegadecimalCalculator thisCalculator = new NegadecimalCalculator();
		thisCalculator.printDisplay();
		thisCalculator.REPL();
	}
	public void setCurrentNDN(NegadecimalNumber ndn) {
		currentNDN = ndn;
		return;
	}
	public void printDisplay() {
		System.out.println("Display: " + display);
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

	public String findSecondOperand(String s) {
		//parses the user input to find the ndn operand
		//returns the operand as a string
		//if the char after the operator is a space, don't include it
		int index = 0;
		if (s.charAt(0) == ' ') index++;	
		return s.substring(index);
	}

	public void REPL() {
		while (true) {
			String command = this.getInput();	//takes user input string
			display = this.evaluate(command);	//evaluates command and prints result
			if (display == "Quit calculator.") break;
			printDisplay();
		}
		return;
	}

	public int findOperatorIndex(String s) {
		char operator = ' ';
		for (int i=0; i < s.length(); i++){	//keeps looking through string until finds non-space
			operator = s.charAt(i);
			if (operator != ' ') {
				return i;
			}
		}
		if (operator == ' ') {
			throw new IllegalArgumentException();
		}
		return -1;
	}

	public boolean badInputForSimple(String s, int index) {
		String afterOperator = s.substring(index + 1); 	//saves string after operator
		return (afterOperator.length() != 0);
	}
		
		
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Valid commands are: +, -, *, /, %, ~, ?, decimal, clear and quit." +
				"\nOr you can enter a negadecimal number directly.\nEnter a command: ");
		return scanner.next();
		
	}

	public String doDecimalInteger(String s, int index, String restOfInput) {
		if (restOfInput.substring(0, 5) == "ecimal") {
				index += 6;
			}
			try {
				int operand = Integer.parseInt(findSecondOperand(s));
				currentNDN = new NegadecimalNumber(operand);
			} catch (IllegalArgumentException e) {
				return "Error";
			}
			return currentNDN.negDN;
	}

	public String evaluate(String s) {
		int operatorIndex = 0;
		try {
			operatorIndex = findOperatorIndex(s);	//finds first non-space character
		} catch (IllegalArgumentException e) {
			return "Must enter something!";
		}
			
		char operator = s.charAt(operatorIndex);
		String restOfInput = s.substring(operatorIndex + 1);

		
		//replaces display with this new ndn
		if (Character.isDigit(operator)) {
			try {
				NegadecimalNumber inputNDN = new NegadecimalNumber(s);
				currentNDN = inputNDN;	//updates global currentNDN
			} catch (IllegalArgumentException e) {
				return "Error";
			}
			return currentNDN.negDN;	//returns string version of NDN to print
		}

		//shows decimal value of displayed ndn
		//and redisplays ndn
		if (operator == '?') {
			if (badInputForSimple(s, operatorIndex)) return "Error";
			return currentNDN.negDN + " (decimal " + currentNDN.decnum + ")";
		}

		//replaces # in display with the negadecimal
		//equivalent of the user's dec number
		if (operator == 'd') {
			return doDecimalInteger(s, operatorIndex, restOfInput);
			}

		//clears errors and replaces display with 0
		if (operator == 'c') {
			if (restOfInput != "" && restOfInput != "lear") {
				return "Error";
			}
			currentNDN = new NegadecimalNumber(0);
			return currentNDN.negDN;
		}

		//quits program
		if (operator == 'q') {
			if (restOfInput != "" && restOfInput != "uit") {
				return "Error";
			}
			return "Quit calculator.";
		}	

		//computes the negative of the display
		if (operator == '~') {
			if (badInputForSimple(s, operatorIndex)) {
				return "Error";
			}
			currentNDN = currentNDN.negate();	//negates and updates currentNDN
			return currentNDN.negDN;			//returns string version to print
		}

		String secondOperand = findSecondOperand(restOfInput);
		try {
			NegadecimalNumber newNDN = new NegadecimalNumber(secondOperand);
			currentNDN = doArithmetic(operator, newNDN);
		} catch (IllegalArgumentException e) {
			return "Error";
		}
		return currentNDN.negDN;
	}
}



