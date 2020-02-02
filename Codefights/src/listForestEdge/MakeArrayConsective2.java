package listForestEdge;

import java.util.Arrays;

public class MakeArrayConsective2 {

	static int makeArrayConsecutive2(int[] statues) {
		int count = 0;
		Arrays.sort(statues);
		for (int x = 0; x < statues.length - 1; x++) {
			if (statues[x + 1] - statues[x] > 1) {
				count += (statues[x + 1] - statues[x]) - 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(makeArrayConsecutive2(new int[] { 6, 2, 3, 8 }));
	}

}
