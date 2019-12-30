package EruptionOfLight;

public class IsBeautifulString {

	static boolean isBeautifulString(String inputString) {
		int[] cal = new int[123];
		for (char c : inputString.toCharArray()) {
			cal[c]++;
		}
		for (int x = 98; x < cal.length; x++) {
			if (cal[x] > cal[x - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isBeautifulString("bbbaa"));
	}

}
