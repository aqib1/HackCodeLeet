package algorithm;

public class NumberOfSubstringsWithOnly1 {

	// "0110111"
	public int numSub(String s) {
		if (s == null || s.length() == 0)
			return 0;
		String[] ones = s.split("0");
		int count = 0, mod = (int) (1e9 + 7);

		for (String val : ones) {
			for (int x = val.length(); x >= 1; x--) {
				count += (x % mod);
			}
		}

		return count;
	}
}
