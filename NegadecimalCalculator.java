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

//	public String findSecondOperand(String s) {
//		//parses the user input to find the ndn operand
//		//returns the operand as a string
//		//if the char after the operator is a space, don't include it
//		int index = 0;
//		if (s.charAt(0) == ' ') index++;	
//		return s.substring(index);
//	}

	public void REPL() {
		while (true) {
			String command = this.getInput();	//takes user input string
			display = this.evaluate(command);	//evaluates command and prints result
			if (display == "Quit calculator.") break;
			printDisplay();
		}
		return;
	}

	/*public int findOperatorIndex(String s) {
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
	*/
/*
	public boolean badInputForSimple(String s) {
		//makes sure that there is no excess input after ?, ~, or ndn
		String afterOperator = s.substring(index + 1); 	//saves string after operator
		return (afterOperator.length() != 0);
	}
	*/	
		
	public String getInput() {
		Scanner keyboard = new Scanner(System.in);
<<<<<<< HEAD
		System.out.println("Valid commands are: +, -, *, /, %, followed by a negadecimal number.\n" +
				"~ : gets the negation of current negadecimal number in display \n?: gets " +
				"value of current number \ndecimal XX: inputs a decimal number to be converted to " +
				"negadecimal\n You must enter (c)lear to clear display and (q)uit to quit calculator. " +
				"You can enter a negadecimal number directly.\n\nEnter a command: ");
		String line = keyboard.nextLine();
		if (line.isEmpty()) {
			System.out.println("Error");
			getInput();
		}
		if (display == "Error" && !line.equalsIgnoreCase("c") && !line.equalsIgnoreCase("clear")) {
			System.out.println("You must enter a 'Clear' command to clear the display\n");
			getInput();
=======
		System.out.println("Valid commands are: +, -, *, /, %, ~, ?, decimal, clear and quit." +
				"\nOr you can enter a negadecimal number directly.\nEnter a command: ");
		String line = keyboard.nextLine();
		if (line.isEmpty()) {
			this.getInput();
>>>>>>> FETCH_HEAD
		}
		return line;
	}

	public String doDecimalInteger(String restOfInput) {
		restOfInput = restOfInput.trim();
		if (restOfInput.isEmpty()) return "Error";
		if (restOfInput.length() >= 6) {
			if ("ecimal".equals(restOfInput.substring(0, 6))) {
				restOfInput = restOfInput.substring(6);
				restOfInput = restOfInput.trim();
			}
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
<<<<<<< HEAD
		s.trim();
		char operator = s.charAt(0);//get first character of input string to identify operation
		String restOfInput = s.substring(1);// everything following first character is considered operand
=======
		char operator = s.charAt(0);
		String restOfInput = s.substring(1);
>>>>>>> FETCH_HEAD
		
		//if input is only numeric, replaces display with this new ndn
		if (Character.isDigit(operator)) {
			try {
				NegadecimalNumber inputNDN = new NegadecimalNumber(s);
				currentNDN = inputNDN;	//updates global currentNDN
			} catch (IllegalArgumentException e) {
				return "Error";
			}
			return cleanUpNumber(currentNDN.negDN);	//returns string version of NDN to print
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
<<<<<<< HEAD
		if ((operator == 'c')||( operator == 'C')) {
			if (!restOfInput.isEmpty() && !"lear".equalsIgnoreCase(restOfInput)) {
=======
		if (operator == 'c') {
			if (!restOfInput.isEmpty() && !"lear".equals(restOfInput)) {
>>>>>>> FETCH_HEAD
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
		List <String> operators = new ArrayList(Arrays.asList("+","-","*","%","/"));
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
		
		
	public String cleanUpNumber(String restOfInput){
		String s = restOfInput;
		s.trim();
		while (s.startsWith("0") && (s.length() > 0) ){
			s = s.substring(1);
		}
		return s;
	}

}






