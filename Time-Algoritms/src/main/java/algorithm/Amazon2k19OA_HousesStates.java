package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Amazon2k19OA_HousesStates {

	public static void main(String[] args) {
		System.out.println(cellCompete(new int[] { 1, 1, 1, 0, 1, 0 }, 2));
	}

	// time O(n) with space O(n)
	public static List<Integer> cellCompete(int[] states, int numberOfDays) {
		for (int x = 0; x < numberOfDays; x++) {
			int arr[] = new int[states.length];
			int left = 0;
			for (int state = 0; state < states.length; state++) {
				int right;
				if (state > 0) {
					left = states[state - 1];
				}
				if (state == states.length - 1)
					right = 0;
				else
					right = states[state + 1];

				if (left == right)
					arr[state] = 0;
				else
					arr[state] = 1;
			}
			states = arr;

		}

		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}
}
