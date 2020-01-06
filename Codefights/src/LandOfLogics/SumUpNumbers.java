package LandOfLogics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumUpNumbers {

	static int sumUpNumbers(String inputString) {
		int sum = 0;
		String number = "";
		for (char c : inputString.toCharArray()) {
			if (Character.isDigit(c)) {
				number += c;
			} else {
				if (!number.isEmpty()) {
					sum += Integer.parseInt(number);
					number = "";
				}
			}
		}
		if (!number.isEmpty())
			sum += Integer.parseInt(number);
		return sum;
	}
	

	public static void main(String[] args) {
		System.out.println(sumUpNumbers("2 apples, 12 oranges"));
	}

}
