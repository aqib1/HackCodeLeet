package leetcode.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class LargeNumber {

	public String largestNumber(int[] nums) {
		if (Objects.isNull(nums) || nums.length == 0)
			return "";
		String result = "";
		String[] data = IntStream.of(nums).mapToObj(String::valueOf).toArray(String[]::new);
		Arrays.sort(data, (a, b) -> (b + a).compareTo(a + b));
		if (data[0].equals("0"))
			return "0";
		for (String s : data) {
			result += s;
		}
		return result;
	}

	public static void main(String[] args) {
		String[] data = { "3", "22" };

		Arrays.sort(data, (a, b) -> (b + a).compareTo(a + b));

		System.out.println(Arrays.toString(data));
	}
}
