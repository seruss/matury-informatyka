package Matura2017;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Picture {
	
	private int[][] data = new int[200][320];
	
	public Picture(int[][] data) {
		this.data = data;
	}
	
	public int[][] getData() {
		return data;
	}
	
	public int getBiggestValue() {
		return Arrays.stream(data).flatMapToInt(x -> Arrays.stream(x)).max().getAsInt();
	}
	
	public int getSmallestValue() {
		return Arrays.stream(data).flatMapToInt(x -> Arrays.stream(x)).min().getAsInt();
	}
	
	public int getFaultyVerseCount() {
		int count = 0;
		for(int j=0; j<200; j++) {
			for(int i=0; i<160; i++) {
				if(data[j][i]!=data[j][320-1-i]) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	public int getContrastingPixelsCount() {
		int[][] contrasting = new int[200][320];
		for(int i=0; i<200; i++) {
			for(int j=0; j<320-1; j++) {
				if(Math.abs(data[i][j]-data[i][j+1])>128) {
					contrasting[i][j] = 1;
					contrasting[i][j+1] = 1;
				}
			}
		}
		for(int i=0; i<320; i++) {
			for(int j=0; j<200-1; j++) {
				if(Math.abs(data[j][i]-data[j+1][i])>128) {
					contrasting[j][i] = 1;
					contrasting[j+1][i] = 1;
				}
			}
		}
		return Arrays.stream(contrasting).flatMapToInt(x -> Arrays.stream(x)).sum(); 
	}
	
	public int getLongestColumn() {
		int biggestCount = 1;
		for(int i=0; i<320; i++) {
			int count = 1;
			for(int j=0; j<200-1; j++) {
				if(data[j][i]==data[j+1][i]) {
					count++;
					if(count>biggestCount) biggestCount = count;
				}
				else count = 1;
			}
		}
	return biggestCount;
	}
	
	public void show() {
		BufferedImage image = new BufferedImage(320,200, 1);
		for(int i=0; i<320; i++) {
			for(int j=0; j<200; j++) {
				Color rgb = new Color(data[j][i],data[j][i],data[j][i]);
				image.setRGB(i, j, rgb.getRGB());
			}
		}
		JFrame frame = new JFrame();
		frame.setSize(320,200);
		frame.setLocation(400, 200);
		frame.add(new JLabel(new ImageIcon(image)));
		frame.setVisible(true);
	}
	
}
