package darkwilderness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeArrayConsective {

	// 2, 3, 6 ,8
	// 4,5,7
	static int[] makeArrayConsecutive(int[] sequence) {
		List<Integer> consec = new ArrayList<>();
		Arrays.sort(sequence);
		System.out.println(Arrays.toString(sequence));
		for (int x = 1; x < sequence.length; x++) {
			if (sequence[x - 1] + 1 == sequence[x]) {
				continue;
			}
			int diff = sequence[x] - sequence[x - 1];
			int val = sequence[x - 1];
			for (int y = 0; y < diff - 1; y++) {
				consec.add(++val);
			}
		}
		return consec.stream().mapToInt(c -> c).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(makeArrayConsecutive(new int[] {-3, -1, 3 })));
	}

}
