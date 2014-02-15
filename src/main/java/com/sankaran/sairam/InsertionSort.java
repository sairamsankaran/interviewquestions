package com.sankaran.sairam;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner intScanner = null;
		Scanner arrayScanner = null;
		int [] inputArray = null;
		try {
			intScanner = new Scanner(System.in);

			int arraySize = intScanner.nextInt();
			if (arraySize < 3) {
				System.out.println("Not enough ...");
				return;
			}
			intScanner.nextLine();
			arrayScanner = new Scanner(intScanner.nextLine());
			
			inputArray = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				if (arrayScanner.hasNextInt()) {
					inputArray[i] = arrayScanner.nextInt();
				} else {
					System.out.println("You didn't provide enough numbers");
					break;
				}
			}
			System.out.println("Input array: " + Arrays.toString(inputArray));
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
		
		// sorting begins
		for (int i = 1, j, key; i < inputArray.length; i++) {
			key = inputArray[i];
			j = i - 1;
			while (j >= 0 && inputArray[j] > key) {
				inputArray[j+1] = inputArray[j];
				inputArray[j] = key;
				j = j - 1;
			}
		}
		System.out.println("Sorted array: " + Arrays.toString(inputArray));
	}
}
