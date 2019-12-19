package rainsofreasons;

import java.util.Arrays;

public class ArrayReplace {
	static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		for (int x = 0; x < inputArray.length; x++)
			if (inputArray[x] == elemToReplace)
				inputArray[x] = substitutionElem;
		return inputArray;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(arrayReplace(new int[] { 2, 3, 3 }, 3, 4)));
	}
}
