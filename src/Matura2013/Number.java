package Matura2013;

import java.util.stream.Stream;

public class Number {

	private String octalValue;
	private int decimalValue;
	
	public Number(String octalValue) {
		this.octalValue = octalValue;
		decimalValue = Integer.parseInt(octalValue, 8);
	}
	
	public String getDecimalString() {
		return Integer.toString(decimalValue);
	}
	
	@Override
	public String toString() {
		return octalValue;
	}
	
	public boolean providesCondition(String value) {
		if(value.charAt(0)==value.charAt(value.length()-1)) return true;
		return false;
	}
	
	public boolean isAscending() {
		int[] numbers = Stream.of(octalValue.split("")).mapToInt(Integer::parseInt).toArray();
		for(int i=0; i<numbers.length-1; i++) {
			if(numbers[i+1]<numbers[i]) return false;
		}
		return true;
	}
}
