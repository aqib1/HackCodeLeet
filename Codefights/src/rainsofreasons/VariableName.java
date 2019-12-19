package rainsofreasons;

import java.util.regex.Pattern;

public class VariableName {

	static boolean variableName(String name) {
		return Pattern.matches("^[A-Za-z_]+([a-zA-Z_0-9]+)?", name);
	}
	public static void main(String[] args) {
		System.out.println(variableName("_AreYouMad"));
	}
}
