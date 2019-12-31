package EruptionOfLight;

public class BuildPalindrome {
	static String buildPalindrome(String st) {
		if (isPalindrome(st))
			return st;
		int x = 0, y = st.length() - 1;
		while (x < y) {
			if(st.charAt(x) != st.charAt(y)) {
				st = new StringBuffer(st).insert((st.length() - x), st.charAt(x)).toString();
				y++;
			}
			x++;
			y--;
			if(isPalindrome(st))
				break;
		}
		return st;
	}

	static boolean isPalindrome(String st) {
		int x = 0, y = st.length() - 1;
		while (x < y) {
			if (st.charAt(x) != st.charAt(y))
				return false;
			x++;
			y--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(buildPalindrome("abcdc"));
	}
}
