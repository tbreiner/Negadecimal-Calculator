package Negadecimal;

import java.util.Scanner;

public class NegadecimalCalculator {

	String display = "0";
	NegadecimalNumber currentNDN = new NegadecimalNumber(0);
	
	public static void main(String[] args) {
		NegadecimalCalculator thisCalculator = new NegadecimalCalculator();
		thisCalculator.REPL();
	}
	public String evaluate(String s) {
		int operatorIndex = findOperatorIndex(s);	//finds first non-space character
		char operator = s.charAt(operatorIndex);
		
		//replaces display with this new ndn
		if (Character.isDigit(operator)) {
			try {
				NegadecimalNumber inputNDN = new NegadecimalNumber(s);
			} catch (IllegalArgumentException e) {
				return "Invalid command.";
			}
			currentNDN = new NegadecimalNumber(s);	//updates global currentNDN
			return inputNDN.negDN;	//returns string version of NDN to print
		}

		
		//computes the negative of the display
		if (operator == '~') {
			if (badInputForSimple) {
				return "Invalid command.";
			}
			currentNDN = currentNDN.negate();	//negates and updates currentNDN
			return currentNDN.negDN;			//returns string version to print
		}

		//shows decimal value of displayed ndn
		//and redisplays ndn
		if (operator == '?') {
			if (badInputForSimple) {
				return "Invalid command.";
			}
			return currentNDN.negDN + "(decimal " + currentNDN.decnum + ")";
		}

		//replaces # in display with the negadecimal
		//equivalent of the user's dec number
		if (operator == 'd') {
			
		}

		//clears errors and replaces display with 0
		if (operator == 'c') {

		}

		//quits program
		if (operator == 'q') {
			
		}	
		//adds given ndn to the current display
		if (operator == '+') {

		}

		//subtracts ndn from the current display
		if (operator == '-') {

		}

		//multiplies the current display by ndn
		if (operator == '*') {

		}

		//divides the current display by ndn.
		//displays Error if ndn is 0.
		if (operator == '/') {

		}

		//gives remainder when dividing display by ndn
		if (operator == '%') {

		}


	}
	
	public void REPL() {
		String command = this.getInput();	//takes user input string
		System.out.println(this.evaluate(command));	//evaluates command and prints result
		


	}
	public int findOperatorIndex(String s) {
		int i = 0;
		char operator = ' ';
		while (operator == ' ') {			//keeps looking through string until finds non-space
			operator = s.charAt(i);
			i++;
		}
		return i;
	}

	public boolean badInputForSimple(String s, int index) {
		String afterOperator = s.substring(index + 1); 	//saves string after operator
		return (afterOperator.length() != 0);
	}
		
		
	public String getInput() {
		Scanner scanner = new Scanner(System.in));
		return scanner.next();
	}
}



