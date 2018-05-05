package Matura2012;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	
		ArrayList<Ciphertext> decodedWords = getList("tj", "klucze1");
		System.setOut(new PrintStream(new File("src\\Matura2012\\wynik4a.txt")));
		for(Ciphertext c:decodedWords) {
			System.out.println(c.encode());
		}
		ArrayList<Ciphertext> encodedWords = getList("sz", "klucze2");
		System.setOut(new PrintStream(new File("src\\Matura2012\\wynik4b.txt")));
		for(Ciphertext c:encodedWords) {
			System.out.println(c.decode());
		}

	}
	
	public static ArrayList<Ciphertext> getList(String file1, String file2) throws IOException {
		ArrayList<Ciphertext> list = new ArrayList<>();
		Scanner reader1 = new Scanner(new File("src\\Matura2012\\"+file1+".txt"));
		Scanner reader2 = new Scanner(new File("src\\Matura2012\\"+file2+".txt"));
		while(reader1.hasNextLine()&&reader2.hasNextLine()) {
			list.add(new Ciphertext(reader1.nextLine(), reader2.nextLine()));
		}
		reader1.close();
		reader2.close();
		return list;
	}

}
