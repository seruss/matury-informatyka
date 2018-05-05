package Matura2012;

public class Ciphertext {

	private String text;
	private String key;
	
	public Ciphertext(String text, String key) {
		this.text = text;
		this.key = key;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
	public String encode() {
		char[] textArray = text.toCharArray();
		char[] keyArray = key.toCharArray();
		for(int i=0; i<text.length(); i++) {
			textArray[i] = (char)((textArray[i]+keyArray[i%key.length()]-64)>90?
					(textArray[i]+keyArray[i%key.length()])-64-26:(textArray[i]+keyArray[i%key.length()]-64));
		}
		return String.valueOf(textArray);
	}
	
	public String decode() {
		char[] textArray = text.toCharArray();
		char[] keyArray = key.toCharArray();
		for(int i=0; i<text.length(); i++) {
			textArray[i] = (char)((textArray[i]-(keyArray[i%key.length()]-64))<65?
					(textArray[i]-(keyArray[i%key.length()]-64))+26:(textArray[i]-(keyArray[i%key.length()]-64)));
		}
		return String.valueOf(textArray);
	}

}

