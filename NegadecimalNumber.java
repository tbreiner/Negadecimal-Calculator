package Negadecimal;

public class NegadecimalNumber {
		int decnum;
		String negDN = "";
		
		public NegadecimalNumber(String s) {
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
			
		}
		public NegadecimalNumber multiply(NegadecimalNumber ndn) {
			
		}
		public NegadecimalNumber divide(NegadecimalNumber ndn) {
			
		}
		public NegadecimalNumber remainder(NegadecimalNumber ndn) {
			
		}
		public NegadecimalNumber negate() {
			
		}
		public int decimalValue() {
			return this.decnum;
			
		}
		public boolean equals(NegadecimalNumber ndn) {
			
		}
		public String toString() {
			return this.negDN;
			
		}
}

