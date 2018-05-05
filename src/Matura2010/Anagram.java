package Matura2010;

import java.util.Arrays;

public class Anagram {

	private String[] words;
	
	public Anagram(String[] words) {
		this.words = words;
	}
	
	@Override
	public String toString() {
		return String.join(" ", words);
	}
	
	public boolean hasSameLength() {
		for(String s:words) {
			if(words[0].length()!=s.length()) return false;
		}
		return true;
	}
	
	public boolean isAnagram() {
		char[] firstWord = words[0].toCharArray();
		Arrays.sort(firstWord);
		for(String s:words) {
			char[] word = s.toCharArray();
			Arrays.sort(word);
			if(!(String.valueOf(firstWord).equals(String.valueOf(word)))) return false;
		}
		return true;
	}
}
