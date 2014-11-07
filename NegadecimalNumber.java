package Negadecimal;

public class NegadecimalNumber {
		int decnum;
		String negDN = "";
		
		public NegadecimalNumber(String s) {
				
				if (s.isEmpty()) {
					throw new IllegalArgumentException("Must not be an empty String");
				}
				if (!isCorrectInput(s)){
					throw new IllegalArgumentException("Not an acceptable input");
				}
				int num = Integer.parseInt(s);
				int remainder = 0;
				int total = 0;
				int p = 1;
				negDN = s;				
			
				while (num > 0) {
				remainder = num % 10;
				total += remainder * p;
				num = num/10;
				p *= -10;
			}
			decnum = total;
		}
		public NegadecimalNumber(int n) {
			decnum = n;
			int remainder = 0;
					
			while (n != 0) {
				remainder = n % -10;
				n = n/-10;
				if (remainder  < 0) {
					remainder += 10;
					n += 1;
				}
				negDN = Integer.toString(remainder) + negDN;
				}
			}
		
		public NegadecimalNumber add(NegadecimalNumber ndn){
			NegadecimalNumber x = new NegadecimalNumber(this.decnum + ndn.decnum);
			return x;
		}
		public NegadecimalNumber subtract(NegadecimalNumber ndn) {
			NegadecimalNumber x = new NegadecimalNumber(this.decnum - ndn.decnum);
			return x;
			
		}
		public NegadecimalNumber multiply(NegadecimalNumber ndn) {
			NegadecimalNumber x = new NegadecimalNumber(this.decnum * ndn.decnum);
			return x;
	
		}
		public NegadecimalNumber divide(NegadecimalNumber ndn) {
			if (ndn.decnum == 0) {
				throw new IllegalArgumentException("Cannot divide by zero");
			}else{	
				NegadecimalNumber x = new NegadecimalNumber(this.decnum / ndn.decnum);
				return x;
			}
		}
		public NegadecimalNumber remainder(NegadecimalNumber ndn) {
			NegadecimalNumber x = new NegadecimalNumber(this.decnum % ndn.decnum);
			return x;
			
		}
		public NegadecimalNumber negate() {
			NegadecimalNumber x = new NegadecimalNumber(0 - this.decnum);
			return x;

		}
		public int decimalValue() {
			return this.decnum;
			
		}
		/**
		 * Determines if this NegadecimalNumber equals the other.
		 * this NegadecimalNumber is equal to other if other is an instance of 	
		 * NegadecimalNumber and both have equal decimalNumber fields.
		 * @param other the Object to compare equality with.
		 * @return true if this NegadecimalNumber is equal to the 
		 * passed in object, else false.
		 */
		@Override
		public boolean equals(Object other) {
			//Check if other is an instance of NegadecimalNumber
			if (!(other instanceof NegadecimalNumber)) {
				return false;
			}			
			//Cast other to a NegadecimalNumber
			NegadecimalNumber that = (NegadecimalNumber) other;
			
			//Check if the decimalNumber fields are equal.
			return this.decnum == that.decnum;
		}

		public String toString() {
			return this.negDN;
			
		}
		public boolean isCorrectInput(String s) {
			for (int i=0; i<s.length(); i++) {
				if (i==0 && s.charAt(i) == '-') continue;
				if (!Character.isDigit(s.charAt(i))) return false;
			}
			return true;
			}
		}


