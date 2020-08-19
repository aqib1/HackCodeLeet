package leetcode.strings;

public class MultiplyStrings {

	public static void main(String[] args) {
		System.out.println(multiply("12", "8"));
	}

	// Time complexity is O(n) and space is O(n+m)
	public static String multiply(String num1, String num2) {
		int num1Len = num1.length(), num2Len = num2.length();
		int[] result = new int[num1Len + num2Len];
		for (int n1 = num1Len - 1; n1 >= 0; n1--) {
			for (int n2 = num2Len - 1; n2 >= 0; n2--) {
				int mul = (num1.charAt(n1) - '0') * (num2.charAt(n2) - '0');
				int sum = result[n1 + n2 + 1] + mul;
				result[n1 + n2] += sum / 10;
				result[n1 + n2 + 1] = sum % 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int r : result) {
			if (sb.length() != 0 || r != 0)
				sb.append(r);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
