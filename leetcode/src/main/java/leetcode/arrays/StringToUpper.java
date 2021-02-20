package leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToUpper {

	public static String toUpper(String val) {
		return Arrays.stream(val.split(" "))
		.map(v -> v.length() == 3 ? v.toUpperCase() : v)
		.collect(Collectors.joining(" "));
	}
	
	public static void main(String[] args) {
		System.out.println(toUpper("this isa hskhsk"));
	}
}
