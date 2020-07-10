
public class StringInAlphabeticalOrder {

	public static void main(String[] args) {
		System.out.println(alphaOrder("BCTZa"));
	}

	// Time complexity is O(n) and space is O(1)
	private static boolean alphaOrder(String string) {
		for (int x = 1; x < string.length(); x++)
			if (string.charAt(x - 1) > string.charAt(x))
				return false;
		return true;
	}

}
