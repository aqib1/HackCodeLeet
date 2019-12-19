package IntroGates;

public class LargestNNumber {
	static int largestNumber(int n) {
		String val = "9";
		for (int x = 1; x < n; x++)
			val += "9";
		return Integer.parseInt(val);
	}

	public static void main(String[] args) {

	}
}
