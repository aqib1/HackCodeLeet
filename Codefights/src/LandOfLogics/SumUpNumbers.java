package LandOfLogics;

import java.util.Arrays;

public class SumUpNumbers {

//	static int sumUpNumbers(String inputString) {
//		int sum = 0;
//		String number = "";
//		for (char c : inputString.toCharArray()) {
//			if (Character.isDigit(c)) {
//				number += c;
//			} else {
//				if (!number.isEmpty()) {
//					sum += Integer.parseInt(number);
//					number = "";
//				}
//			}
//		}
//		if (!number.isEmpty())
//			sum += Integer.parseInt(number);
//		return sum;
//	}
	
	static int sumUpNumbers(String inputString) {
		return Arrays.stream(inputString.split("\\D+"))
				.filter(x-> !x.isEmpty())
				.mapToInt(Integer::new).sum();
	}
	public static void main(String[] args) {
		System.out.println(sumUpNumbers("2 apples, 12 oranges"));
	}

}
