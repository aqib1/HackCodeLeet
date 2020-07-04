package algorithm;

public class IntegerToRoman {

	int[] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < numbers.length && num > 0; x++) {
			if (numbers[x] <= num) {
				while (numbers[x] <= num) {
					num -= numbers[x];
					sb.append(romans[x]);
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		IntegerToRoman integerToRoman = new IntegerToRoman();
		System.out.println(integerToRoman.intToRoman(2000));
	}
}
