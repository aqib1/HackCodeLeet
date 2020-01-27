package challenges;

public class ReverseInteger {

	static int reverseInteger(int x) {
		String v = String.valueOf(x);
		v = v.contains("-") ? "-" + new StringBuilder(v.substring(1, v.length())).reverse().toString()
				: new StringBuilder(v.substring(0, v.length())).reverse().toString();
		return Integer.parseInt(v);
	}

	public static void main(String[] args) {

	}

}
