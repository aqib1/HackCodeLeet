package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Amazaon2k20OA_DemoTest {

	public static List<Integer> cellCompete(int[] states, int days) {
		List<Integer> result = new ArrayList<>();
		int[] stateWithBound = new int[states.length + 2];
		stateWithBound[0] = 0;
		stateWithBound[stateWithBound.length - 1] = 0;

		for (int x = 1; x < stateWithBound.length - 1; x++)
			stateWithBound[x] = states[x - 1];

		for (int x = 0; x < days; x++) {
			int arr[] = new int[stateWithBound.length];
			arr[0] = 0;
			arr[arr.length - 1] = 0;
			for (int state = 1; state < stateWithBound.length - 1; state++) {
				if (stateWithBound[state - 1] == stateWithBound[state + 1])
					arr[state] = 0;
				else
					arr[state] = 1;
			}
			stateWithBound = arr;
		}
		for (int x = 1; x < stateWithBound.length - 1; x++)
			result.add(stateWithBound[x]);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(cellCompete(new int[] { 1, 0, 0, 0, 0, 1, 0, 0 }, 1));
	}

}
