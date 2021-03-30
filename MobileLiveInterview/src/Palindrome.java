
public class Palindrome {

	public static boolean isPalindrome(String value) {
		char[] valueChar = value.toCharArray();
		int start = 0;
		int end = valueChar.length - 1;
		while (start < end) {
			if (valueChar[start] != valueChar[end])
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("aba"));
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome("abbc"));
		System.out.println(isPalindrome("abca"));
		System.out.println(isPalindrome("a"));
	}
}
