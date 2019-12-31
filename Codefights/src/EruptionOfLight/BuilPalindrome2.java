package EruptionOfLight;

public class BuilPalindrome2 {
	static String buildPalindrome(String st) {
		if (st.equals(new StringBuffer(st).reverse().toString()))
			return st;

		String front = "";
		for (int i = 0; i < st.length(); i++) {
			front += st.charAt(i);
			String newSt = st + new StringBuilder(front).reverse().toString();
			if (newSt.equals(new StringBuilder(newSt).reverse().toString())) {
				return newSt;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
