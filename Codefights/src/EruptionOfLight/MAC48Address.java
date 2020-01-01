package EruptionOfLight;

import java.util.regex.Pattern;

public class MAC48Address {

	static boolean isMAC48Address(String inputString) {
		return Pattern.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$", inputString);
	}

	public static void main(String[] args) {
		
	}
}
