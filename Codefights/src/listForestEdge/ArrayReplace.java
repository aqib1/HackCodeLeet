package listForestEdge;

import java.util.Arrays;

public class ArrayReplace {

	static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		return Arrays.stream(inputArray).map(x -> x == elemToReplace ? substitutionElem : x).toArray();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
