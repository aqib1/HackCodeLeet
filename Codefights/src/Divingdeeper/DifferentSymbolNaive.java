package Divingdeeper;

import java.util.HashSet;
import java.util.Set;

public class DifferentSymbolNaive {
	static int differentSymbolsNaive(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray())
			set.add(c);
		return set.size();
	}

	public static void main(String[] args) {

	}

}
