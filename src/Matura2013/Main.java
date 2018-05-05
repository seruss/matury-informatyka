package Matura2013;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	
		ArrayList<Number> numbers = getList();
		ArrayList<Integer> numbers2 = new ArrayList<>();
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		for(Number n:numbers) {
			if(n.providesCondition(n.toString())) count1++;
			if(n.providesCondition(n.getDecimalString())) count2++;
			if(n.isAscending()) {
				count3++;
				numbers2.add(Integer.parseInt(n.toString()));
			}
		}
		
		System.out.println("Zadanie 1");
		System.out.println("Ilość liczb spełniająca dany warunek: "+count1);
		System.out.println();
		System.out.println("Zadanie 2");
		System.out.println("Ilość liczb w zapisie dziesiętnym spełniających warunek: "+count2);
		System.out.println();
		System.out.println("Zadanie 3");
		System.out.println("Ilość liczb spełniających warunek: "+count3);
		System.out.println("Największa: "+Collections.max(numbers2));
		System.out.println("Najmniejsza: "+Collections.min(numbers2));

	}

	public static ArrayList<Number> getList() throws IOException {
		ArrayList<Number> numbers = new ArrayList<>();
		Scanner reader = new Scanner(new File("src\\Matura2013\\dane.txt"));
		while(reader.hasNextLine()) {
			numbers.add(new Number(reader.nextLine()));
		}
		reader.close();
		return numbers;
	}
}
