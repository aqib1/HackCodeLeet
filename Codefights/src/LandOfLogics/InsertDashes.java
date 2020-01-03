package LandOfLogics;

public class InsertDashes {

	static String insertDashes(String inputString) {
		String insert = "";
		for (int x = 0; x < inputString.length() - 1; x++) {
			if (Character.isLetter(inputString.charAt(x)) && Character.isLetter(inputString.charAt(x + 1))) {
				insert += inputString.charAt(x) + "-";
			} else
				insert += inputString.charAt(x);
		}
		return insert + inputString.charAt(inputString.length() - 1);
	}

	public static void main(String[] args) {
		System.out.println(insertDashes("aaa bb c"));
	}
}
