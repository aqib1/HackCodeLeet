package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	static Map<String, Integer> romanToInteger = new HashMap<>();
	static {
		romanToInteger.put("M", 1000);
		romanToInteger.put("CM", 900);
		romanToInteger.put("D", 500);
		romanToInteger.put("CD", 400);
		romanToInteger.put("C", 100);
		romanToInteger.put("XC", 90);
		romanToInteger.put("L", 50);
		romanToInteger.put("XL", 40);
		romanToInteger.put("X", 10);
		romanToInteger.put("IX", 9);
		romanToInteger.put("V", 5);
		romanToInteger.put("IV", 4);
		romanToInteger.put("I", 1);
	}

	public static int getNumberFromRoman(String roman) {
		if (romanToInteger.containsKey(roman))
			return romanToInteger.get(roman);
		int sum = 0;
		for (int x = 0; x < roman.length(); x++) {
			char c = roman.charAt(x);
			if (c == 'C' || c == 'X' || c == 'I') {
				if (x + 1 < roman.length()) {
					String key = Character.toString(c).concat(Character.toString(roman.charAt(x + 1)));
					if (romanToInteger.containsKey(key)) {
						sum += romanToInteger.get(key);
						x++;
						continue;
					}
				}

			}
			sum += romanToInteger.get(Character.toString(c));
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(getNumberFromRoman("MCMXCIV"));
	}

}
