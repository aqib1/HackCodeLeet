package lybrinthOfNestedLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeakNumbers {

	static int[] weakNumbers(int n) {
		if (n <= 4)
			return new int[] { 0, n };
		List<int[]> divs = new ArrayList<>();
		for (int x = 1; x <= n; x++) {
			int div = getAllDiviser(x);
			int[] pair = new int[] { div, (int) divs.stream().filter(t -> t[0] > div).count() };
			divs.add(pair);
		}
		int maxVal = Integer.MIN_VALUE;
		int count = 0;
		for(int [] data: divs) {
			if(data[1] > maxVal) {
				maxVal = data[1];
				count = 0;
			}
			if(maxVal == data[1]) 
				count++;
		}
		return new int[] {maxVal, count};
	}

	public static int getAllDiviser(int n) {
		int count = 0;
		for (int x = 1; x <= n; x++)
			if (n % x == 0)
				count++;
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(weakNumbers(9)));
	}

}
