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
			commonDifference = 2;
//			while (!found) {
//				commonDifference = progressionArray[end] - progressionArray[start] - commonDifference;
//				if(commonDifference == 0){
//					commonDifference = progressionArray[end] - progressionArray[start];
//					found = true;
//				}
//				start++;
//				end++;
//			}
			System.out.println("Common difference = " + commonDifference);
			
			int missing = missingNumber(progressionArray, commonDifference, 0, progressionArray.length-1);
			System.out.println(missing);
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
	
	// Once we know common difference use binary search to search for missing number
	public static int missingNumber(int [] arithmeticProgression, int commonDifference, int first, int last) {
		if (last - first == 2) {
			if ((arithmeticProgression[last] - arithmeticProgression[last-1]) == (arithmeticProgression[last-1] - arithmeticProgression[first])) {
				System.out.println("No missing numbers");
				return -1;
			} else {
				if ((arithmeticProgression[last-1] - arithmeticProgression[first]) != commonDifference) {
					return arithmeticProgression[first] + commonDifference;
				} else {
					return arithmeticProgression[last] - commonDifference;
				}
			}
		}
		
		int mid = midpoint(first, last);
		
		if(arithmeticProgression[mid] == (arithmeticProgression[0] + commonDifference*mid)) {
			return missingNumber(arithmeticProgression, commonDifference, mid, last);
		} else {
			return missingNumber(arithmeticProgression, commonDifference, first, mid);
		}
	}
	
	public static int midpoint(int first, int last) {
		return (int)(first + (last - first)*0.5);
	}
}
