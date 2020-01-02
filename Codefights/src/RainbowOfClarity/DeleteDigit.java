package RainbowOfClarity;

public class DeleteDigit {
	static int deleteDigit(int n) {
		String strN = String.valueOf(n);
		int MAX = Integer.MIN_VALUE;
		for (int x = 0; x < strN.length(); x++) {
			int v = Integer.parseInt(new StringBuilder(strN).deleteCharAt(x).toString());
			if (MAX < v) {
				MAX = v;
			}
		}
		return MAX;
	}

	public static void main(String[] args) {
		System.out.println(deleteDigit(222219));
	}

}
