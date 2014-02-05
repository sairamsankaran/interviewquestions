package com.sankaran.sairam;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.FoundIndex;

public class ArithmeticProgression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner intScanner = null;
		Scanner arrayScanner = null;
		int commonDifference = 0;
		try {
			intScanner = new Scanner(System.in);

			int arraySize = intScanner.nextInt();
			if (arraySize < 3) {
				System.out.println("Not enough ...");
				return;
			}
			intScanner.nextLine();
			arrayScanner = new Scanner(intScanner.nextLine());
			
			int [] progressionArray = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				if (arrayScanner.hasNextInt()) {
					progressionArray[i] = arrayScanner.nextInt();
				} else {
					System.out.println("You didn't provide enough numbers");
					break;
				}
			}
			System.out.println(Arrays.toString(progressionArray));
			Boolean found = false;
			int start = 0;
			int end = 1;
			while (!found) {
				commonDifference = progressionArray[end] - progressionArray[start] - commonDifference;
				start++;
				end++;
				if(commonDifference == 0){
					commonDifference = progressionArray[end] - progressionArray[start];
					found = true;
				}
			}
			System.out.println(commonDifference);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (intScanner != null) {
				intScanner.close();
			}
			if (arrayScanner != null) {
				arrayScanner.close();
			}
		}
	}
}
