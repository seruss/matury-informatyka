package Matura2015;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Number implements Comparable<Number> {

	private String binaryString;
	private BigInteger value;
	private BigInteger zero = new BigInteger("0");
	
	public Number(String binaryString) {
		this.binaryString = binaryString;
		value = new BigInteger(binaryString, 2);
	}
	
	public BigInteger getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return binaryString;
	}
	
	@Override
	public int compareTo(Number n) {
		return value.compareTo(n.getValue());
	}
	
	public boolean hasMoreZeros() {
		int ones = Stream.of(binaryString.split("")).mapToInt(Integer::parseInt).sum();
		int zeros = binaryString.length()-ones;
		if(zeros>ones) return true;
		return false;
	}
	
	public boolean isDivByTwo() {
		BigInteger two = new BigInteger("2");
		if(value.mod(two).equals(zero)) return true;
		return false;
	}
	
	public boolean isDivByEight() {
		BigInteger eight = new BigInteger("8");
		if(value.mod(eight).equals(zero)) return true;
		return false;
	}
	
	
}
