package Divingdeeper;

public class FirstDigit {

	static char firstDigit(String inputString) {
		return (char) inputString.chars().filter(x -> Character.isDigit(x)).findFirst().orElse(Character.MIN_VALUE);
	}

	public static void main(String[] args) {
		System.out.println(firstDigit("qq-q"));
	}
}
