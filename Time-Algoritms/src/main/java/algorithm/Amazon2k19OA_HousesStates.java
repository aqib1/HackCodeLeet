package algorithm;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Amazon2k19OA_HousesStates {

	public static void main(String[] args) {
		// System.out.println(cellCompete(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7));
	}

	// time O(n) with space O(n)
	public List<Integer> cellCompete(int[] states, int days) {
		if (Objects.isNull(states) || states.length == 0)
			throw new EmptyStackException();
		for (int day = 0; day < days; day++) {
			int tempState[] = new int[states.length];
			int left = 0;
			for (int state = 0; state < states.length; state++) {
				int right;
				if (state > 0)
					left = states[state - 1];
				if (state == states.length - 1)
					right = 0;
				else
					right = states[state + 1];

				if (left == right)
					tempState[state] = 0;
				else
					tempState[state] = 1;
			}
			states = tempState;
		}
		return Arrays.stream(states).boxed().collect(Collectors.toList());
	}
}
