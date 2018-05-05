package Matura2017;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//System.setOut(new PrintStream(new File("src\\Matura2017\\wyniki6.txt")));
		
		Picture picture = getPicture();
		
		System.out.println("Zadanie 1");
		System.out.println("Najjaśnieszy piksel: "+picture.getBiggestValue());
		System.out.println("Najciemniejszy piksel: "+picture.getSmallestValue());
		System.out.println();
		System.out.println("Zadanie 2");
		System.out.println("Najmniejsza liczba wierszy, które trzeba usunąć: "+picture.getFaultyVerseCount());
		System.out.println();
		System.out.println("Zadanie 3");
		System.out.println("Liczba kontrastujących pikseli: "+picture.getContrastingPixelsCount());
		System.out.println();
		System.out.println("Zadanie 4");
		System.out.println("Najdłuższa linia pionowa: "+picture.getLongestColumn());
		
	}
	
	public static Picture getPicture() throws IOException {
		Scanner reader = new Scanner(new File("src\\Matura2017\\dane.txt"));
		int[][] data = new int[200][320];
		for(int i=0; i<200; i++) {
			for(int j=0; j<320; j++) {
				data[i][j] = reader.nextInt();
			}
		}
		reader.close();
		return new Picture(data);
	}

}
