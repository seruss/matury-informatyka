package Matura2014;

public class Writing implements Comparable<Writing> {

	private String value;
	
	public Writing(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public int compareTo(Writing w) {
		return value.compareTo(w.getValue());
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public boolean isPrimeWriting() {
		int sum = value.chars().sum();
		if(isPrime(sum)) return true;
		return false;
	}
	
	public boolean isAscending() {
		char[] letters = value.toCharArray();
		for(int i=0; i<value.length()-1; i++) {
			if(letters[i]>=letters[i+1]) return false;
		}
		return true;
	}
	
	private boolean isPrime(int number) {
		if(number==1) return false;
		if(number==2||number==3) return true;
		for(int i=2; i<number/2; i++) {
			if(number%i==0) return false;
		}
		return true;
	}
}
