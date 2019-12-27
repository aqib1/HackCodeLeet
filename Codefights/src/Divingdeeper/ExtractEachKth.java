package Divingdeeper;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ExtractEachKth {

//	static Integer[] extractEachKth(int[] inputArray, int k) {
//		List<Integer> li = new ArrayList<Integer>();
//		int count = 0;
//
//		for (int t = 0; t < inputArray.length; t++) {
//			count++;
//			if (count != k) {
//				li.add(inputArray[t]);
//			} else
//				count = 0;
//		}
//
//		return li.toArray(new Integer[li.size()]);
//	}

	static int[] extractEachKth(int[] inputArray, int k) {
		return IntStream.range(0, inputArray.length).filter(x -> ((x + 1) % k) != 0).map(i -> inputArray[i]).toArray();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(extractEachKth(new int[] { 2, 4, 6, 8, 10 }, 2)));
	}

}
