package Matura2014;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Writing> writings = getList();
		
		int primeCount = 0;
		for(Writing w:writings) {
			if(w.isPrimeWriting()) primeCount++;
		}
		
		System.out.println("Zadanie 1");
		System.out.println("W pliku znajduje się "+primeCount+" napisów pierwszych.");
		System.out.println();
		
		System.out.println("Zadanie 2");
		for(Writing w:writings) {
			if(w.isAscending()) System.out.println(w);
		}
		System.out.println();
		
		System.out.println("Zadanie 3");
		for(int i=0; i<1000; i++) {
			for(int j=i+1; j<1000; j++) {
				if(writings.get(i).compareTo(writings.get(j))==0) {
					System.out.println(writings.get(i));
				}
			}
		}
		
	}

	private static ArrayList<Writing> getList() throws IOException {
		Scanner reader = new Scanner(new File("src\\Matura2014\\NAPIS.txt"));
		ArrayList<Writing> list = new ArrayList<>();
		while(reader.hasNextLine()) {
			list.add(new Writing(reader.nextLine()));
		}
		reader.close();
		return list;
	}
}
