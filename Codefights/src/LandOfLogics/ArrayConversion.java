package LandOfLogics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayConversion {

	static int arrayConversion(int[] inputArray) {

		return arrayConversion(Arrays.stream(inputArray).boxed().collect(Collectors.toList()), 1);
	}

	private static int arrayConversion(List<Integer> inputArray, int i) {
		if (inputArray.size() == 1)
			return inputArray.get(0);
		List<Integer> li = new ArrayList<>();
		for (int c = 0; c < inputArray.size(); c += 2) {
			if (i % 2 == 0) {
				li.add(inputArray.get(c) * inputArray.get(c + 1));
			} else {
				li.add(inputArray.get(c) + inputArray.get(c + 1));
			}
		}
		return arrayConversion(li, ++i);
	}

	public static void main(String[] args) {
		System.out.println(arrayConversion(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }));
	}
}
