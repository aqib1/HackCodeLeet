package looptunnel;

public class FirstNonRepeatingCharacter {

	static char firstNotRepeatingCharacter(String s) {
		int c[] = new int[123];
		char result = '_';
		for (char t : s.toCharArray()) {
			c[t]++;
		}
		for (char t : s.toCharArray()) {
			if (c[t] == 1) {
				result = t;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(firstNotRepeatingCharacter("abacabad"));

	}

}
