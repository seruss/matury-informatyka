package Matura2010;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Anagram> anagrams = getList();
		
		System.setOut(new PrintStream(new File("src\\Matura2010\\odp_4a.txt")));
		for(Anagram a:anagrams) {
			if(a.hasSameLength()) System.out.println(a);
		}
		
		System.setOut(new PrintStream(new File("src\\Matura2010\\odp_4b.txt")));
		for(Anagram a:anagrams) {
			if(a.isAnagram()) System.out.println(a);
		}
	}
	
	public static ArrayList<Anagram> getList() throws IOException {
		ArrayList<Anagram> anagrams = new ArrayList<>();
		Scanner reader = new Scanner(new File("src\\Matura2010\\anagram.txt"));
		while(reader.hasNext()) {
			String[] words = new String[5];
			for(int i=0; i<5; i++) {
				words[i] = reader.next();
			}
			anagrams.add(new Anagram(words));
		}
		reader.close();
		return anagrams;
	}

}






