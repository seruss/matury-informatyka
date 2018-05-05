package Matura2011;

public class Binary implements Comparable<Binary> {

	private String binaryString;
	private int value;
	
	public Binary(String binaryString) {
		this.binaryString = binaryString;
		value = Integer.parseInt(binaryString, 2);
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return binaryString;
	}
	
	@Override
	public int compareTo(Binary b) {
		return ((Integer)value).compareTo(b.getValue());
	}
	
	public boolean hasNineDigits() {
		if(binaryString.length()==9) return true;
		return false;
	}
	
	public boolean isEven() {
		if(value%2==0) return true;
		return false;
	}
}
