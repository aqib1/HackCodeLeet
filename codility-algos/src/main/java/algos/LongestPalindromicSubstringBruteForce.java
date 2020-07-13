package algos;

public class LongestPalindromicSubstringBruteForce {

	// Time complexity O(n)3 and space is O(1) its a brute force so we will make it
	// more efficient
	public static void main(String[] args) {
		System.out.println(LPS("aaaabbaa"));
	}

	public static String LPS(String string) {
		if (string == null || string.isEmpty() || string.length() == 1)
			return string;
		String lps = String.valueOf(string.charAt(0));
		int max_len = Integer.MIN_VALUE;
		for (int x = 0; x < string.length(); x++) {
			String subStr = String.valueOf(string.charAt(x));
			for (int y = x + 1; y < string.length(); y++) {
				subStr += String.valueOf(string.charAt(y));
				if (max_len < subStr.length())
					if (subStr.equals(reverse(subStr))) {
						lps = subStr;
						max_len = subStr.length();
					}
			}
		}

		return lps;
	}

	private static String reverse(String subStr) {
		int i = 0, j = subStr.length() - 1;
		char[] arr = subStr.toCharArray();
		while (i < j) {
			char temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}
		return String.valueOf(arr);
	}
}
