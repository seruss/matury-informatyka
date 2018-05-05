package Matura2015;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Number> numbers = getList();
		
		int moreZerosCount = 0;
		int divByTwoCount = 0;
		int divByEightCount = 0;
		int smallestNumberVerse = 0;
		int biggestNumberVerse = 0;
		Number min = Collections.min(numbers);
		Number max = Collections.max(numbers);
		
		int i=1;
		for(Number n:numbers) {
			if(n.hasMoreZeros()) moreZerosCount++;
			if(n.isDivByTwo()) divByTwoCount++;
			if(n.isDivByEight()) divByEightCount++;
			if(n==min) smallestNumberVerse = i;
			if(n==max) biggestNumberVerse = i;
			i++;
		}
		
		System.setOut(new PrintStream(new File("src\\Matura2015\\wyniki4.txt")));
		System.out.println("Zadanie 1");
		System.out.println("Ilość liczb mających w zapisie więcej zer niż jedynek: "+moreZerosCount);
		System.out.println();
		System.out.println("Zadanie 2");
		System.out.println("Ilość liczb podzielnych przez 2: "+divByTwoCount);
		System.out.println("Ilość liczb podzielnych przez 2: "+divByEightCount);
		System.out.println();
		System.out.println("Zadanie 3");
		System.out.println("Najmniejsza liczba znajduje się w "+smallestNumberVerse+" wierszu.");
		System.out.println("Największa liczba znajduje się w "+biggestNumberVerse+" wierszu.");
		
		}

	public static ArrayList<Number> getList() throws IOException {
		Scanner reader = new Scanner(new File("src\\Matura2015\\liczby.txt"));
		ArrayList<Number> numbers = new ArrayList<>();
		while(reader.hasNextLine()) {
			numbers.add(new Number(reader.nextLine()));
		}
		reader.close();
		return numbers;
	}
}
