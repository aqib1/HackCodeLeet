import java.util.Objects;

public class IsPalindromeSentence {

	public static int isPalindrome(String A) {
		if (Objects.isNull(A) || A.isEmpty()) {
			return 0;
		}

		int start = 0;
		int end = A.length() - 1;

		while (start < end) {
			if (!Character.isLetter(A.charAt(start)) && !Character.isDigit(A.charAt(start))) {
				++start;
			} else if (!Character.isLetter(A.charAt(end)) && !Character.isDigit(A.charAt(end))) {
				--end;
			} else {
				if (!Character.toString(A.charAt(start)).equalsIgnoreCase(Character.toString(A.charAt(end))))
					return 0;
				++start;
				--end;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
