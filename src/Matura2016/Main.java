package Matura2016;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		for(int i=1; i<=3; i++) {
			ArrayList<Ciphertext> list = getList(i);
			System.setOut(new PrintStream(new File("src\\Matura2016\\wyniki_6_"+i+".txt")));
			for(Ciphertext c:list) {
				if(i==1) System.out.println(c.cipher(107));
				if(i==2) System.out.println(c.decipher());
				if(i==3&&(!(c.isCorrect()))) System.out.println(c);
			}
		}
	}
		
	
	
	public static ArrayList<Ciphertext> getList(int number) throws IOException {
		Scanner reader = new Scanner(new File("src\\Matura2016\\dane_6_"+number+".txt"));
		ArrayList<Ciphertext> list = new ArrayList<>();
		while(reader.hasNext()) {
			if(number==1) list.add(new Ciphertext(reader.nextLine()));
			if(number==2) list.add(new Ciphertext(reader.next(), reader.nextInt()));
			if(number==3) list.add(new Ciphertext(reader.next(), reader.next()));
		}
		reader.close();
		return list;
	}

}
