package Matura2011;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<Binary> numbers = getList();
		
		int evenCount = 0;
		int nineDigitCount = 0;
		int sum = 0;
		
		for(Binary b:numbers) {
			if(b.isEven()) evenCount++;
			if(b.hasNineDigits()) {
				nineDigitCount++;
				sum += b.getValue();
			}
		}
		
		Binary biggest = Collections.max(numbers);
		
		System.out.println("Zadanie 1");
		System.out.println("Ilość parzystych liczb w pliku: "+evenCount);
		System.out.println();
		System.out.println("Zadanie 2");
		System.out.println("Największa liczba w pliku: "+biggest);
		System.out.println("W systemie dzisiętnym: "+biggest.getValue());
		System.out.println();
		System.out.println("Zadanie 3");
		System.out.println("Ilość liczb mających 9 cyfr: "+nineDigitCount);
		System.out.println("Suma tych liczb w systemie dwójkowym: "+Integer.toBinaryString(sum));

	}
	
	public static ArrayList<Binary> getList() throws IOException {
		ArrayList<Binary> list = new ArrayList<>();
		Scanner reader = new Scanner(new File("src\\Matura2011\\liczby.txt"));
		while(reader.hasNextLine()) {
			list.add(new Binary(reader.nextLine()));
		}
		reader.close();
		return list;
	}

}
