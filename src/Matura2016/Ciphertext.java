package Matura2016;

public class Ciphertext {

	private String text;
	private String cipheredText;
	private int key;
	
	public Ciphertext(String text) {
		this.text = text;
	}
	
	public Ciphertext(String cipheredText, int key) {
		this.cipheredText = cipheredText;
		this.key = key;
	}
	
	public Ciphertext(String text, String cipheredText) {
		this.text = text;
		this.cipheredText = cipheredText;
	}
	
	@Override
	public String toString() {
		if(text==null) return cipheredText+" "+key;
		if(cipheredText==null) return text+" "+key;
		if(key==0) return text+" "+cipheredText;
		return text+" "+cipheredText+" "+key;
	}
	
	public String cipher(int key) {
		int k = key%26;
		char[] letters = text.toCharArray();
		for(int i=0; i<text.length(); i++) {
			letters[i] = (char) ((int)(letters[i]+k)>90?letters[i]-26+k:letters[i]+k);
		}
		return String.valueOf(letters);
	}
	
	public String decipher() {
		int k = key%26;
		char[] letters = cipheredText.toCharArray();
		for(int i=0; i<letters.length; i++) {
			letters[i] = (char) ((int)(letters[i]-k)<65?letters[i]+26-k:letters[i]-k);
		}
		return String.valueOf(letters);
	}
	
	public boolean isCorrect() {
		char[] letters = text.toCharArray();
		char[] cipher = cipheredText.toCharArray();
		for(int i=0; i<text.length()-1; i++) {
			int key1 = letters[i]<cipher[i]?cipher[i]-letters[i]:cipher[i]-letters[i]+26;
			int key2 = letters[i+1]<cipher[i+1]?cipher[i+1]-letters[i+1]:cipher[i+1]-letters[i+1]+26;
			if(key1!=key2) return false;
		}
		return true;
	}
	
	
}
